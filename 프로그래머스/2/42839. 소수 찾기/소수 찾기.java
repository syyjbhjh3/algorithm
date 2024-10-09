import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>(); // 중복 숫자를 제거하기 위한 Set
    public int solution(String numbers) {
        int answer = 0;
        
        // 주어진 문자열의 각 숫자를 배열로 변환
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        
        // 모든 자리 수에 대해 순열 생성
        for (int i = 1; i <= arr.length; i++) {
            dfs(arr, visited, "", i);
        }
        
        // 생성된 숫자 중 소수인 것들의 개수를 셈
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // DFS를 사용해 가능한 숫자 조합 생성
    private void dfs(char[] arr, boolean[] visited, String current, int depth) {
        if (depth == 0) {
            // 숫자를 만들었으면 set에 추가 (중복 방지)
            set.add(Integer.parseInt(current));
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, visited, current + arr[i], depth - 1); // 숫자를 이어붙임
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
