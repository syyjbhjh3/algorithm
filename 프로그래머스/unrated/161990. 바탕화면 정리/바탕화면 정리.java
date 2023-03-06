class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int minX = -1, minY = -1, maxX = 0, maxY = 0, index = 0;
        
        for(String str : wallpaper){
            int min = str.indexOf("#");
            int max = str.lastIndexOf("#");
            
            minX = (min >= 0 && (minX >= min || minX == -1)) ? min:minX;
            minY = (min >= 0 && minY == -1) ? index:minY;
            maxX = (max >= 0 && maxX < max) ? max:maxX;
            maxY = (min >= 0) ? index:maxY;
            
            index++;
        }
        answer[0] = minY; 
        answer[1] = minX; 
        answer[2] = maxY+1; 
        answer[3] = maxX+1; 
        
        return answer;
    }
}