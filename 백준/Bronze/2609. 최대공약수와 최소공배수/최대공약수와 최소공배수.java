import java.util.Scanner;

public class Main {
    private void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        // 유클리드 호제법
        int min = num1 > num2 ? min(num1, num2) : min(num2, num1);
        System.out.println(min);
        System.out.println((num1*num2)/min);
    }

    private int min(int max, int min){
        int temp;
        while (min > 0) {
            temp = max % min;
            max = min;
            min = temp;
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}