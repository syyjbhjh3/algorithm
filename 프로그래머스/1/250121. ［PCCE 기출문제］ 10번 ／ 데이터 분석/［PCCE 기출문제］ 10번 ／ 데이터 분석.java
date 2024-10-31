import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        String[] str = {"code", "date", "maximum", "remain"};
        
        // ext가 val_ext보다 작고, sort_by 기준으로 오름차순
        int idx = Arrays.asList(str).indexOf(ext);
        int sortIdx = Arrays.asList(str).indexOf(sort_by);
        
        for(int[] arr : data){
            if(arr[idx] < val_ext) list.add(arr);
        }
        
        list.sort(Comparator.comparingInt(arr -> arr[sortIdx]));
        
        int[][] answer = new int[list.size()][str.length];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}