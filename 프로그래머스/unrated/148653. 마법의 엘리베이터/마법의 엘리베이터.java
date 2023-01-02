class Solution {
    public int solution(int storey) {
        //0보다 작으면 동작 x
        //1번당 돌1개
        //0층으로 가기
        
        int answer = 0;
        int num, clone;
        boolean flag = true;
        
        
        while(storey > 0) {
            num = storey%10;
            
            //윗자리를 확인하여 반올림/반내림 결정
            if(num == 5){
                flag = getFlag(storey);
            }
            
            storey /= 10;
            
            if(flag){
                if(num > 5){
                    answer = answer + (10 - num);
                    storey++;
                }else{
                    answer += num;
                }    
            }else{
                if(num >= 5){
                    answer = answer + (10 - num);
                    storey++;
                }else{
                    answer += num;
                }    
            }
        }
        return answer;
    }
    
    public boolean getFlag(int num){
        boolean flag = true;
        
        while(num%10 == 5){
            num /= 10;
            int temp = num%10;
            
            if(temp != 5){
                if(temp > 5){
                    flag = false;              
                }
            }
            
            if(num == 5){
                flag = false;              
            }
        }
        
        return flag;
    }
}