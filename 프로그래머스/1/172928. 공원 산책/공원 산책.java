class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 시작 위치 찾기
        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf("S") > -1) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }

        // 방향에 따른 이동 정의: N, S, W, E
        int[][] direction = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        String[] directions = { "N", "S", "W", "E" };
        
        // 이동 경로 처리
        for (String route : routes) {
            String[] temp = route.split(" ");
            String dir = temp[0];
            int distance = Integer.parseInt(temp[1]);

            // 방향에 맞는 인덱스를 찾아서 이동 처리
            for (int i = 0; i < directions.length; i++) {
                if (dir.equals(directions[i])) {
                    answer = checkMove(answer, direction[i], distance, park);
                    break;
                }
            }
        }
        return answer;
    }

    static int[] checkMove(int[] current, int[] direction, int distance, String[] map) {
        int rows = map.length;
        int cols = map[0].length();

        // 이동할 위치 계산
        int newRow = current[0] + direction[0] * distance;
        int newCol = current[1] + direction[1] * distance;

        // 범위 초과 검사
        if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
            return current;
        }

        // 이동 가능한지 체크 (장애물이 없는지 확인)
        for (int i = 1; i <= distance; i++) {
            int checkRow = current[0] + direction[0] * i;
            int checkCol = current[1] + direction[1] * i;
            if (map[checkRow].charAt(checkCol) == 'X') {
                return current;
            }
        }

        // 새로운 위치로 이동
        current[0] = newRow;
        current[1] = newCol;
        return current;
    }
}
