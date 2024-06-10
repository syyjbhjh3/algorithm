import java.util.Scanner;

public class Main {
    private void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        
        int ans = 0;

        for(String num : nums){
            int n = Integer.parseInt(num);
            for(int i=2; i<=n; i++){
                if(i==n){
                    ans++;
                    break;
                }
                if(n%i==0){
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}