class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        boolean flag = true;
        int beforeLen, afterLen;
        
        while(!s.equals("1")){
            beforeLen = s.length();
            s = s.replaceAll("0","");
            afterLen = s.length();
            
            answer[1] = answer[1] + (beforeLen - afterLen);
            answer[0]++;
            
            s = Integer.toString(afterLen, 2);
        }
        return answer;
    }
}