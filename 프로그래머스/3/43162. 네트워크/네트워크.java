import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    static void dfs(int start, int n, int[][] computers, boolean[] visited){    
        visited[start] = true;
        
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[start][i] == 1){
                dfs(i, n, computers, visited);
            }
        }
    }
}