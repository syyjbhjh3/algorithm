import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int MAX_SIZE = 1000000;
        boolean[] isPrime = new boolean[MAX_SIZE + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(MAX_SIZE); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX_SIZE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        String s; 

        while ((s=br.readLine()) != null) {
            int num = Integer.parseInt(s);
            if(num > 0){
                for(int i=3; i<=num/2; i+=2){
                    String str = null;
                    if(isPrime[i] && isPrime[num-i]){
                        str = num + " = " + i + " + " + (num-i);
                        ans.append(str).append('\n');
                        break;
                    }
                    if(i == num/2-1){
                        str = "Goldbach's conjecture is wrong.";
                        ans.append(str).append('\n');
                    }
                }
            }
        }
        System.out.print(ans.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
