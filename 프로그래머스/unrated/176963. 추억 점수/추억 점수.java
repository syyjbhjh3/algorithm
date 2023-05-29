import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap map = new HashMap<String,Integer>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);    
        }
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(String key : photo[i]){
                sum = map.get(key) != null ? sum +  (Integer)map.get(key) : sum;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}