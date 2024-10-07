import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
         PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scoville) {
            heap.add(s);
        }

        // 가장 작은 두 개의 스코빌 지수를 계속 섞습니다.
        while (heap.size() > 1 && heap.peek() < K) {
            int first = heap.poll(); // 가장 작은 값
            int second = heap.poll(); // 두 번째로 작은 값

            // 두 값을 섞어 새로운 스코빌 지수 생성
            int mixed = first + (second * 2);
            heap.add(mixed); // 새 스코빌 지수를 힙에 추가
            answer++; // 섞은 횟수 증가
        }

        // 모든 음식의 스코빌 지수가 K 이상인지 확인
        if (heap.peek() < K) {
            return -1;  // 스코빌 지수를 K 이상으로 만들 수 없을 때
        }
        
        return answer;
    }
}