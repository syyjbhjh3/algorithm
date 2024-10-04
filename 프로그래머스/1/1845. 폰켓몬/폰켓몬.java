import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        int n = nums.length/2;
        answer = n < set.size() ? n : set.size();
        return answer;
    }
}