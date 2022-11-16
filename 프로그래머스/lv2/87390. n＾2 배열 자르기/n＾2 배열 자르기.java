class Solution {
    public int[] solution(int n, long left, long right) {
        int start = (int)left;
        int finish = (int)right;
        int[] answer = new int[finish-start+1];
        
        int x = 0;
        int y = 0;
        int z = 0;
        
        for(int i=0; i<answer.length; i++){
            x = (int) (left / (long) n);
            y = (int) (left % (long) n);

            answer[i] = Math.max(x, y)+1;
            left++;
        }
        
        
        return answer;
        
    }
}

// 12345
// 22345
// 33345
// 44445
// 55555