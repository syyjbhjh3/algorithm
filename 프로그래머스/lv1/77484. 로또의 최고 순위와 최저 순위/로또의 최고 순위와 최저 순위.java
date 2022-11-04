import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int[] rank = {6,6,5,4,3,2,1};
        int zCnt = 0;
        int sCnt = 0;
        
        //0의 갯수
        Arrays.sort(lottos);
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] > 0){
                break;
            }else{
                zCnt++;
            }
        }
        
        //0제외 맞은 갯수
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    sCnt++;
                }
            }
        }
        
        answer[0] = (sCnt+zCnt > 6) ? rank[6] : rank[sCnt+zCnt];
        answer[1] = rank[sCnt];
        
        return answer;
    }
}