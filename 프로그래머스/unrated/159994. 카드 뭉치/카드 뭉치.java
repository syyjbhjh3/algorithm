import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int x = 0, y = 0;
        
        for(String str : goal){
            int cnt1 = Arrays.asList(cards1).indexOf(str);
            int cnt2 = Arrays.asList(cards2).indexOf(str);
            
            if(x == cnt1){
                x++;
            }else if(cnt1 != -1){
                answer = "No";
                return answer;
            }
            
            if(y == cnt2){
                y++;
            }else if(cnt2 != -1){
                answer = "No";
                return answer;
            }
        }
        return answer;
    }
}