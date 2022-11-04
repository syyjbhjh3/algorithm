import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] mailCnt = new int[id_list.length];
        
        //중복제거
        String[] reportArr = Arrays.stream(report).distinct().toArray(String[]::new);
        
        String[] xArray = new String[reportArr.length];
        String[] yArray = new String[reportArr.length];
        
        for(int i=0; i<reportArr.length; i++){
            String[] temp = reportArr[i].split(" ");
            xArray[i] = temp[0];
            yArray[i] = temp[1];
        }
        
        //신고횟수
        for(int i=0; i<reportArr.length; i++){
            answer[Arrays.asList(id_list).indexOf(yArray[i])] +=1;
        }
        
        //최고값이 정지 기준 이상으로 넘어가면
        int maxCnt = Arrays.stream(answer).max().getAsInt();
        
        if(maxCnt >= k){
            for(int i=0; i<answer.length; i++){
                if(answer[i] >= k){
                    //신고 당하는 사람 아이디
                    for(int j=0; j<yArray.length; j++){
                        if(id_list[i].equals(yArray[j])){
                            mailCnt[Arrays.asList(id_list).indexOf(xArray[j])] +=1;
                        }       
                    }
                }
            }
        }
        return mailCnt;
    }
}