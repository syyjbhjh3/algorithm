import java.util.*;

class Solution {
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    boolean[][] visited;
    int[][] maps;

    public int solution(int[][] maps) {
        this.maps = maps; // 전역 변수에 할당
        visited = new boolean[maps.length][maps[0].length];
        return bfs();
    }
    
    int bfs(){
        int answer = 1; // 거리 초기화
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true; // 시작점 방문 처리
        
        while(!q.isEmpty()) {
            int size = q.size(); // 현재 레벨의 큐 사이즈
            
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];

                // 도착지에 도달하면 현재 거리 반환
                if(x == maps.length - 1 && y == maps[0].length - 1) {
                    return answer;
                }

                for(int j = 0; j < 4; j++) {
                    int nX = x + dx[j];
                    int nY = y + dy[j];

                    // 범위 체크
                    if(nX < 0 || nY < 0 || nX >= maps.length || nY >= maps[0].length) continue;

                    // 이동 가능하고 방문하지 않은 경우
                    if(maps[nX][nY] == 1 && !visited[nX][nY]) {
                        visited[nX][nY] = true; // 방문 처리
                        q.offer(new int[]{nX, nY}); // 큐에 추가
                    }
                }
            }
            answer++; // 한 단계 진행 후 거리 증가
        }
        return -1; // 도착할 수 없는 경우
    }
}
