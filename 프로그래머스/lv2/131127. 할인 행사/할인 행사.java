import java.util.Arrays;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0; i<discount.length-9; i++){
            //number와 비교될 배열
            int[] arr = new int[number.length];
            
            for(int j=i; j<=i+9; j++){ 
                if(Arrays.asList(want).indexOf(discount[j]) > -1){
                    arr[Arrays.asList(want).indexOf(discount[j])] += 1;    
                }
            }
            
            if(Arrays.equals(arr,number)){    
                answer++;
            }
        }
        
        return answer;
    }
}