import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int x= commands[i][0];
            int y= commands[i][1];
            int z= commands[i][2];
            
            answer[i] = slice(array, x, y, z);
        }
        
        return answer;
    }
    
    int slice(int[] array, int x, int y, int z){
        int k = 0;
        
        int[] arr = new int[y-x+1];
                
        for(int i=0; i<arr.length; i++){
            arr[i] = array[x-1];
            x++;
        }
        
        Arrays.sort(arr);
        return arr[z-1];
    }
}