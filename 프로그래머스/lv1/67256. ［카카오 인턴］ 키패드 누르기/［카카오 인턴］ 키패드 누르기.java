class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //양손 위치, 임의의 초기값
        int lHand = 10;
        int rHand = 12;
        
        //2,5,8,0 과의 거리를 넣을 변수
        int lLen = 0;
        int rLen = 0;
        
        for(int i=0; i<numbers.length; i++){
            //3
            if(numbers[i]%3 == 1){
                answer += "L";
                lHand = numbers[i];
            }else if(numbers[i]%3 == 0 && numbers[i]!=0){
                answer += "R";
                rHand = numbers[i];
            }else{
                numbers[i] = (numbers[i] ==0)? 11 : numbers[i];
                
                rLen = searchLen(rHand, numbers[i]);
                lLen = searchLen(lHand, numbers[i]);
                
                if(rLen > lLen){
                    answer += "L";
                    lHand = numbers[i];
                }else if(lLen > rLen){
                    answer += "R";
                    rHand = numbers[i];
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        rHand = numbers[i];
                    }else{
                        answer += "L";
                        lHand = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
    
    int searchLen(int hand, int num){
        int len = 1;

        if(hand%3 == 1){
            hand = (hand/3) + (hand%3);
        }else if(hand%3 == 2){
            hand = (hand/3) + (hand%3) -1;
            len = 0;
        }else{
            hand = hand/3;
        }
        
        num = (num/3) + (num%3) -1;
        
        int maxNum = Math.max(hand, num);
        int minNum = Math.min(hand, num);
        
        len = len + maxNum - minNum;
        
        return len;
    }
}