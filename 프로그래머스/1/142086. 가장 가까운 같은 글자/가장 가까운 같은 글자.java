class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        // 1. 0부터 i까지 자른다.
        // 2. 자른 글자에서 lastindexOf
        // 3. i - lastIndexOf
        for(int i=1; i<s.length(); i++){
            String str = s.substring(0,i);
            
            if(str.lastIndexOf(s.charAt(i)) > -1){
                answer[i] = i - str.lastIndexOf(s.charAt(i));
            }else{
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}