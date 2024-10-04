import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 저장할 해시맵 생성
        HashMap<String, String> phoneMap = new HashMap<>();
        
        // 모든 전화번호를 해시맵에 저장
        for (String phone : phone_book) {
            phoneMap.put(phone, phone);
        }
        
        // 각 전화번호의 접두어가 있는지 확인
        for (String phone : phone_book) {
            // 전화번호의 길이만큼 접두어를 확인
            for (int i = 1; i < phone.length(); i++) {
                // 현재 전화번호의 접두어가 해시맵에 존재하는지 확인
                if (phoneMap.containsKey(phone.substring(0, i))) {
                    return false;  // 접두어가 있으면 false 반환
                }
            }
        }
        
        return true;
    }
}