class Solution {
    public int solution(int n) {
        int answer = n+1;
        boolean flag = true;
        
        int nCnt = oneCnt(n);
        
        while(flag){
            if(oneCnt(answer) == nCnt){
                flag = false;
            }else{
                answer++;   
            }
        }
        
        //System.out.print(nStr);
        return answer;
    }
    
    int oneCnt(int x){
        String str = Integer.toBinaryString(x);
        int count = 0;
        char[] strArr = str.toCharArray();
        for (char val : strArr) {
            if (val == '1') count++;
        }
        return count;
    }
}