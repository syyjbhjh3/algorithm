import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int []arr) {
        return IntStream.range(0, arr.length)
        .filter(i -> i == 0 || arr[i-1] != arr[i])
        .map(i -> arr[i])
        .toArray();
    }
}