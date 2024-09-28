import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] king = new int[k];
        int min = 0;
        
        for(int i = 0; i < king.length; i++){
            king[i] = -1;
        }
        
        for(int i = 1; i <= score.length; i++){
            if(king[0] == 0 || king[0] < score[i-1]){
                king[0] = score[i-1];
            }
            Arrays.sort(king);
            

            if(king[0] < 0){
                for(int j = 0; j < king.length; j++){
                    if(king[j] >= 0){
                        answer[i-1] = king[j];
                        break;
                    }
                }
            }else{
                answer[i-1] = king[0];
            }
            
        }
        return answer;
    }
}