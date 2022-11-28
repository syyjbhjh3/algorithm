import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int minA = arrayA[0];
        int minB = arrayB[0];
        
        Set<Integer> set = new HashSet<>();
            
        for(int i = 2; i <= minA; i++) {
            if(minA % i == 0) set.add(i);
        }
        for(int i = 2; i <= minB; i++) {
            if(minB % i == 0) set.add(i);
        }
        
        List<Integer> list = new ArrayList<>(set);
        for(int k = 0; k < list.size(); k++) {
            boolean chk = true;
            
            for(int i = 0; i < arrayA.length; i++) {
                if(arrayA[i] % list.get(k) != 0 || arrayB[i] % list.get(k) == 0) {
                    chk = false;
                    break;
                }
            }
            if(chk) answer = Math.max(answer, list.get(k));

            chk = true;
            
            for(int i = 0; i < arrayB.length; i++) {
                if(arrayB[i] % list.get(k) != 0 || arrayA[i] % list.get(k) == 0) {
                    chk = false;
                    break;
                }
            }
            if(chk) answer = Math.max(answer, list.get(k));
        }
        
        
        return answer;
    }
}