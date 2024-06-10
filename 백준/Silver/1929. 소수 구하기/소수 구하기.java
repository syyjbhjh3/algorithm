import java.util.Scanner;

public class Main {
    private void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        
        int num1 = Integer.parseInt(nums[0]);
        int num2 = Integer.parseInt(nums[1]);

        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        boolean[] isPrime = new boolean[max + 1];
        
        // Initialize the array with true values
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        
        // Implement the Sieve of Eratosthenes
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        
        // Collect prime numbers in the specified range
        for (int i = min; i <= max; i++) {
            if (isPrime[i]) {
                ans.append(i).append("\n");
            }
        }
        
        System.out.print(ans.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}