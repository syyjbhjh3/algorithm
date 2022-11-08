class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long amt = 0;
        
        for(int i=1; i<=count; i++){
            amt += price * i;
        }
        
        answer = (money > amt) ? 0 : amt-money;

        return answer;
    }
}