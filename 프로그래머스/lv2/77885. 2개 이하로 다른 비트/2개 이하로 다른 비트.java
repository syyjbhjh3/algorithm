class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        //beat 2진수
        for(int j=0; j<numbers.length; j++){
            String b = Long.toString(numbers[j], 2);
            
            for(int i=b.length()-1; i>=0; i--){
                if(i == b.length()-1 && b.charAt(i) == '0'){
                    b = b.substring(0, i) + "1" + b.substring(i+1);
                    break;
                }
                
                if(i != b.length()-1 && b.charAt(i) == '0'){
                    b = b.substring(0, i) + "10" + b.substring(i+2);
                    break;
                }
                
                if(i==0){
                    b = "10" + b.substring(1, b.length());
                }
            }
            answer[j] = Long.parseLong(b,2);
        }
        
        return answer;
    }
}