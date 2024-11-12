class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        // 각 인덱스에서 DFS 시작
        for (int i = 0; i < number.length; i++) {
            answer += dfs(number, i, 1, number[i]);
        }
        return answer;
    }
    
    static int dfs(int[] number, int idx, int count, int sum) {
        // 기저 조건: 세 숫자를 선택했을 때 합이 0인지 확인
        if (count == 3) {
            return sum == 0 ? 1 : 0;
        }
        
        int result = 0;
        
        // 다음 요소를 선택하기 위해 DFS 수행
        for (int i = idx + 1; i < number.length; i++) {
            result += dfs(number, i, count + 1, sum + number[i]);
        }
        
        return result;
    }
}
