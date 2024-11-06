import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<String> al = new ArrayList<>(Arrays.asList             
                          ("a","b","c","d","e","f","g","h","i",
                           "j","k","l","m","n","o","p","q","r",
                           "s","t","u","v","w","x","y","z"));
        
        for(char ch : skip.toCharArray()){
            al.remove(al.indexOf(String.valueOf(ch)));
        }
        
        for(char ch : s.toCharArray()){
            int idx = al.indexOf(String.valueOf(ch)) + index;
            if (idx >= al.size()) {
                idx %= al.size();  // 인덱스가 리스트 크기보다 큰 경우 순환
            }
            
            answer += al.get(idx);
        }
        return answer;
    }
}
