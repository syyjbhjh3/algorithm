import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            int remainingDays = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.offer(remainingDays);
        }

        int deploy = 1;
        int prev = queue.poll(); 
    
        while(!queue.isEmpty()) {
            int current = queue.peek();

            if (prev >= current) {  
                deploy++;
            } else {
                list.add(deploy);   
                deploy = 1;        
                prev = current;     
            }
            queue.poll(); 
        }

        list.add(deploy);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
