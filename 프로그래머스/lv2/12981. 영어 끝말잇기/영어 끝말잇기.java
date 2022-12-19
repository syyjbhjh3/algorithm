import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt = 1, person = 1;
        String last = "", first = "";
        
        Set<String> strSet = new HashSet<>();
        
        for(String word : words){
            if(last != ""){
                first = word.substring(0, 1);
                
                if(!last.equals(first)){
                    answer[0] = person;
                    answer[1] = cnt;
                    break;         
                }
            }
            
            last = word.substring(word.length()-1, word.length());
            
            if(strSet.contains(word)){
                answer[0] = person;
                answer[1] = cnt;
                break;       
            }else{
                strSet.add(word);
                person++;
            }
            
            if(person > n){
                cnt++;
                person = 1;
            }
        }

        return answer;
    }
}