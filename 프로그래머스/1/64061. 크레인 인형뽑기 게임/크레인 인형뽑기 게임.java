import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Integer> stack = new ArrayList<>(); // 뽑힌 인형을 저장할 리스트 (스택처럼 사용)
        int answer = 0;

        for (int move : moves) {
            int column = move - 1; // moves는 1부터 시작하므로 0-index로 변환
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 0) { // 인형 발견
                    int doll = board[i][column];
                    board[i][column] = 0; // 뽑은 인형 제거

                    // 스택의 맨 위 인형과 같은 종류인지 확인
                    if (!stack.isEmpty() && stack.get(stack.size() - 1) == doll) {
                        stack.remove(stack.size() - 1); // 연속된 인형 제거
                        answer += 2; // 터진 인형 수는 2개 증가
                    } else {
                        stack.add(doll); // 스택에 인형 추가
                    }
                    break; // 한 번 뽑았으면 다음 move로 이동
                }
            }
        }

        return answer;
    }
}
