class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
                
        // brown + yellow = x*y
        // yellow가 1증가하면 brown +x or +y && x >= y
        // yellow는 x-1, y-1
        // 4,3 - 10,2
        // 4,4 - 12,4
        // 5,3 - 12,3
        // 5,4 - 14,6
        
        int totalArea = brown + yellow;
        
        for (int y = 3; y <= totalArea / y; y++) {
            int x = totalArea / y;
            
            if ((x - 2) * (y - 2) == yellow) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
            
        return answer;
    }
}