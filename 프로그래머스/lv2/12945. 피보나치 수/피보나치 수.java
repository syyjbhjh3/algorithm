import java.util.*;

class Solution {
    public int solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0,1));
        
        int answer = 0;
        
        for(int i=2; i<n; i++){
            list.add((list.get(i-2)%1234567) + (list.get(i-1)%1234567));
        }
        
        answer = (list.get(n-2) + list.get(n-1)) % 1234567;
        
        return answer;
    }
}