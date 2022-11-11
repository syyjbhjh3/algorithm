class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] engArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<engArr.length; i++){
            s = s.replaceAll(engArr[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}