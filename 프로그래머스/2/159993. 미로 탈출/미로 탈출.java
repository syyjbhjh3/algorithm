import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    int[] dy = {0, 0, 1, -1};
    
    boolean[][] visited;
    char[][] map;
    
    public int solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        int[] start = searchMap(maps, "S");
        int[] levor = searchMap(maps, "L");
        int[] finish = searchMap(maps, "E");
        
        // 경유지로 가는 최단 경로
        int toLevor = bfs(start, levor);
        if (toLevor == -1) return -1;  // 경로가 없으면 -1 반환
        
        // 끝 지점으로 가는 최단 경로
        int toFinish = bfs(levor, finish);
        if (toFinish == -1) return -1; // 경로가 없으면 -1 반환
        
        return toLevor + toFinish; // 경유지를 거쳐 최종 목적지까지의 최단 경로
    }
    
    // 특정 문자를 찾는 함수
    static int[] searchMap(String[] maps, String str){
        for(int i = 0; i < maps.length; i++){
            if(maps[i].indexOf(str) > -1){
                return new int[]{i, maps[i].indexOf(str)};
            }
        }
        return new int[]{-1, -1}; // 못 찾은 경우
    }
    
    // BFS 함수
    int bfs(int[] start, int[] finish){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[map.length][map[0].length]; // 방문 초기화
        q.offer(new int[]{start[0], start[1], 0}); // x, y, 거리
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if(x == finish[0] && y == finish[1]) {
                return distance; // 목적지 도착
            }
            
            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // 경계 체크 및 방문하지 않았으며 장애물이 아닐 때
                if(newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length && 
                   !visited[newX][newY] && map[newX][newY] != 'X'){
                    visited[newX][newY] = true;
                    q.offer(new int[]{newX, newY, distance + 1});
                }
            }
        }
        
        return -1; // 경로가 없으면 -1 반환
    }
}
