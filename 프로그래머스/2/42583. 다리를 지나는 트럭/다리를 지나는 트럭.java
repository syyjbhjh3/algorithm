import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;  // 소요된 시간
        int current_weight = 0;  // 현재 다리 위의 총 무게
        
        Queue<Integer> bridge = new LinkedList<>();  // 다리 위에 있는 트럭들을 저장
        Queue<Integer> truckQueue = new LinkedList<>();  // 대기 중인 트럭들을 저장
        
        // 대기 중인 트럭들을 큐에 추가
        for (int truck : truck_weights) {
            truckQueue.offer(truck);
        }
        
        // 다리 길이만큼 0으로 초기화 (트럭이 없을 때)
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        while (!bridge.isEmpty()) {
            answer++;  // 1초 경과
            
            // 다리에서 트럭이 나가면 무게 감소
            current_weight -= bridge.poll();
            
            // 다음 트럭이 다리 위로 올라갈 수 있는지 확인
            if (!truckQueue.isEmpty()) {
                if (current_weight + truckQueue.peek() <= weight) {
                    // 트럭이 다리 위로 올라감
                    int nextTruck = truckQueue.poll();
                    bridge.offer(nextTruck);
                    current_weight += nextTruck;
                } else {
                    // 트럭이 다리 위로 올라갈 수 없으면 0을 넣음 (트럭 대기)
                    bridge.offer(0);
                }
            }
        }
        
        return answer;
    }
}
