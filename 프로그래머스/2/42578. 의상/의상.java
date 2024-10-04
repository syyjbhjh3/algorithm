import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] arr : clothes){
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);    
        }
        
        for (int count : map.values()) {
            answer *= (count + 1);  // 해당 종류의 옷을 입지 않는 경우를 포함해 +1
        }
        
        return answer-1;
    }
}