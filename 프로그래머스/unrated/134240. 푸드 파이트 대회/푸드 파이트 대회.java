class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=0; i<food.length; i++){
            for(int j=1; j<=food[i]/2; j++){
                answer += Integer.toString(i);
            }
        }
        
        String reverse = "";
        for(int i=answer.length()-1; i>=0; i--){
            reverse += answer.charAt(i);
        }
        
        //물
        answer += "0";
        answer += reverse;
        
        return answer;
    }
}