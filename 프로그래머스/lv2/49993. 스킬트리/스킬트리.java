import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String[] skillArr = skill.split("");
        int[] index = new int[skillArr.length];
        int[] clone = new int[skillArr.length];
        
        for(String str : skill_trees){
            int non = 27;
            for(int i=0; i<index.length; i++){
                if(str.indexOf(skillArr[i]) == -1){
                    index[i] = non;    
                    non++;
                    continue;
                }
                index[i] = str.indexOf(skillArr[i]);    
            }
            
            clone = index.clone();
            Arrays.sort(clone);
            
            if(Arrays.equals(clone, index)) {
                answer++;  
                System.out.println(str);
            }
        }
        return answer;
    }
}