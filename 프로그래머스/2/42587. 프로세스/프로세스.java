import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
        }
        
        boolean[] visit = new boolean[priorities.length];
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            visit[x] = true;
            boolean higher = false;
            
            for(int i=0; i<priorities.length; i++){
                if(visit[i]) continue;
                if(y<priorities[i]){
                    higher = true;
                    break;
                }
            }
            
            if(higher){
                queue.offer(new int[]{x,y});
                visit[x] = false;
            }else{
                answer++;
                if(x == location) break;
            }
        }
        return answer;
    }
}