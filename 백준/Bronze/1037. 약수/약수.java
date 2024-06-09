import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int s = Integer.parseInt(sc.nextLine());

        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                            	.mapToInt(Integer::parseInt)
		                        .boxed().collect(Collectors.toList());

        Collections.sort(list);

        System.out.println(list.get(0) * list.get(list.size()-1));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}