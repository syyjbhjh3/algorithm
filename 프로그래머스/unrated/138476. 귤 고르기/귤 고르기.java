import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        int[] arr = new int[tangerine[tangerine.length-1]];
        
        for(int i : tangerine){
            arr[i-1] = arr[i-1]+1;
        }
        
        Arrays.sort(arr);
        
        int cnt = 0;
        
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] > 0){
                answer++;
                cnt += arr[i];
            }
            
            if(cnt >= k){
                break;
            }
        }
        
        return answer;
    }
}