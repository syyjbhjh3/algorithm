import java.util.*;

public class Main {
    private void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        long ans = 0;

        for(int i=1; i<=s; i++){
            ans += i * (s/i);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}