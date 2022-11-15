import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int amt = 0;
        
        Arrays.sort(d);
        
        for(int i : d){
            amt += i;
            
            if(amt > budget){
                amt -= i;
                break;
            }
            
            answer++;
        }
        return answer;
    }
}