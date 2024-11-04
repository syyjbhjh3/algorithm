class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        // 슬라이딩 윈도우
        int len = t.length() - p.length() + 1;
        long pNum = Long.parseLong(p);  // p 문자열을 Long 타입으로 변환
        
        for (int i = 0; i < len; i++) {
            // t의 부분 문자열을 Long 타입으로 변환하여 비교
            long subNum = Long.parseLong(t.substring(i, p.length() + i));
            if (subNum <= pNum) answer++;
        }
        return answer;
    }
}
