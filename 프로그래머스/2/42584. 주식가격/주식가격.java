class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int sec = 0;
            
            // i 번째 이후의 가격들과 비교
            for (int j = i + 1; j < prices.length; j++) {
                sec++;
                if (prices[i] > prices[j]) {
                    // 가격이 떨어지면 종료
                    break;
                }
            }
            
            // 떨어지지 않은 시간을 저장
            answer[i] = sec;
        }
        
        return answer;
    }
}