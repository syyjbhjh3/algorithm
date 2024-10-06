import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. 숫자 배열을 문자열 배열로 변환
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 정렬 기준 설정
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        
        // 3. 정렬된 결과를 이어 붙임
        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }
        
        // 4. 모든 값이 0인 경우 처리
        if (nums[0].equals("0")) {
            return "0";
        }
        
        return answer.toString();
    }
}