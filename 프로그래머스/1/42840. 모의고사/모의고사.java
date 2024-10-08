import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];  // 각 사람의 점수
        int[] kim = {1,2,3,4,5};
        int[] lee = {2,1,2,3,2,4,2,5};
        int[] hong = {3,3,1,1,2,2,4,4,5,5};
        
        // 각 사람의 점수를 계산
        for(int i=0; i<answers.length; i++){
            if(answers[i] == kim[i % kim.length]){
                answer[0]++;
            }
            if(answers[i] == lee[i % lee.length]){
                answer[1]++;
            }
            if(answers[i] == hong[i % hong.length]){
                answer[2]++;
            }
        }

        // 최대 점수를 찾음
        int maxScore = Math.max(answer[0], Math.max(answer[1], answer[2]));
        
        List<Integer> list = new ArrayList<>();
        
        // 최대 점수를 받은 사람(들)을 리스트에 추가
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == maxScore) {
                list.add(i + 1);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
