class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int min, max;
        
        while(answer <= n){
            max = Math.max(a,b);
            min = Math.min(a,b);
            
            if(max-min == 1 && min%2 == 1){
                break;
            }else{
                a = a/2 + a%2;   
                b = b/2 + b%2;
                
                answer++;
            }
        }
        return answer;
    }
}