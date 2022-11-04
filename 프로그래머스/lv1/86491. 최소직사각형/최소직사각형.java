import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] xArray = new int[sizes.length]; //가로
        int[] yArray = new int[sizes.length]; //세로
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                xArray[i] = sizes[i][1];
                yArray[i] = sizes[i][0];    
            }else{
                xArray[i] = sizes[i][0];
                yArray[i] = sizes[i][1];    
            }
        }
        
        int xMax = Arrays.stream(xArray).max().getAsInt();
        int yMax = Arrays.stream(yArray).max().getAsInt();
        
        answer = xMax * yMax;
        return answer;
    }
}