import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> uidMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        
        //uid 별 최종 닉네임을 Map에 넣는다.
        for(String str : record){
            if(str.indexOf("Leave") == -1){
                String[] temp = str.split(" ");
                uidMap.put(temp[1], temp[2]);    
            }
        }
        
        for(String str : record){
            String[] temp = str.split(" ");
            
            if(temp[0].equals("Enter")){
                resultList.add(uidMap.get(temp[1])+"님이 들어왔습니다.");    
            }else if(temp[0].equals("Leave")){
                resultList.add(uidMap.get(temp[1])+"님이 나갔습니다.");    
            }
        }
        
        answer = resultList.stream().toArray(String[]::new);
        
        return answer;
    }
}