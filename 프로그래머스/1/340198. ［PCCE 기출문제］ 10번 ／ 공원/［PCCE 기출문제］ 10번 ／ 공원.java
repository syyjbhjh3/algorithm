import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        // 큰 매트부터 돌기 위해 내림차순 정렬
        Arrays.sort(mats);

        // 큰 매트부터 시도하여 배치가 가능하면 반환
        for (int i = mats.length - 1; i >= 0; i--) {
            if (canPlaceMatSlidingWindow(mats[i], park)) {
                return mats[i];
            }
        }
        
        return answer;
    }

    static boolean canPlaceMatSlidingWindow(int mat, String[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        // 슬라이딩 윈도우를 통해 매트가 들어갈 수 있는지 확인
        for (int r = 0; r <= rows - mat; r++) {
            // 윈도우 초기화 (가로 방향)
            int validCols = 0;

            for (int c = 0; c <= cols - mat; c++) {
                // 첫 번째 윈도우에서는 전체 영역을 검사
                if (c == 0) {
                    validCols = 0;
                    for (int i = 0; i < mat; i++) {
                        for (int j = 0; j < mat; j++) {
                            if (map[r + i][c + j].equals("-1")) {
                                validCols++;
                            }
                        }
                    }
                } else {
                    // 윈도우를 한 칸 오른쪽으로 이동하면서, 이전 열을 빼고 새로 들어온 열만 검사
                    for (int i = 0; i < mat; i++) {
                        // 이전 열 제외
                        if (map[r + i][c - 1].equals("-1")) {
                            validCols--;
                        }
                        // 새 열 추가
                        if (map[r + i][c + mat - 1].equals("-1")) {
                            validCols++;
                        }
                    }
                }

                // 모든 칸이 "O"인 경우 매트를 놓을 수 있음
                if (validCols == mat * mat) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
