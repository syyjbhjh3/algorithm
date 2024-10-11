import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
            
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    void dfs(int[] numbers, int target, int sum, int len) {
        if(numbers.length == len){
            if(sum == target){
                answer++;    
            }
            return;
        }
        
        dfs(numbers, target, sum+numbers[len] , len+1);
        dfs(numbers, target, sum-numbers[len] , len+1);
        
    }
}