import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String[] sArray = {"R","T","C","F","J","M","A","N"};
        int[] cArray = new int[sArray.length];
        
        for(int i=0; i<cArray.length; i++){
            cArray[i] = 0;
        }
        
        for(int i=0; i<survey.length; i++){
            if(choices[i] != 4){
                String[] xArray = survey[i].split("");
                int score = 0;
                if(choices[i] < 4){
                    if(choices[i] == 1){
                        score = 3;
                    }else if(choices[i] == 2){
                        score = 2;
                    }else{
                        score = 1;
                    }
                    cArray[Arrays.asList(sArray).indexOf(xArray[0])] += score;
                }else if(choices[i] > 4){
                    if(choices[i] == 5){
                        score = 1;
                    }else if(choices[i] == 6){
                        score = 2;
                    }else{
                        score = 3;
                    }
                    cArray[Arrays.asList(sArray).indexOf(xArray[1])] += score;
                }   
            }
        }
        
        answer += (cArray[0] < cArray[1]) ? sArray[1] : sArray[0]; 
        answer += (cArray[2] < cArray[3]) ? sArray[3] : sArray[2]; 
        answer += (cArray[4] < cArray[5]) ? sArray[5] : sArray[4]; 
        answer += (cArray[6] < cArray[7]) ? sArray[7] : sArray[6]; 
        
        return answer;
    }
}