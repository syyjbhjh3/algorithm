import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int box = 1; box <= order.length; box++)
        {
            if(order[i] != box)
            {
                stack.add(box);
                continue;
            }

            i++;
            answer++;

            while (stack.size() != 0 && order[i] == stack.peek())
            {
                stack.pop();
                i++;
                answer++;
            }
        }

        return answer;        
    }
}