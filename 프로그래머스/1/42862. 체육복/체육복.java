import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 체육복을 가진 학생이 도난당한 경우 처리
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) {
            lostSet.add(l);
        }
        
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                // 여벌 체육복을 가진 학생이 도난당한 경우는 제외
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }
        
        // 체육복 빌려주는 과정 처리
        for (int r : reserveSet) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }
        
        // 최종적으로 체육수업에 참여할 수 있는 학생 수는 전체 학생 수에서 남은 lostSet의 크기를 뺀 값
        return n - lostSet.size();
    }
}
