import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		solution(N);
	}
 
	public static int solution(int n) {
		long answer = 0;

		for(int i = 1; i<=n; i++) {
    		if(i<10)
    			answer++;
    		else if(i>=10 && i<100)
    			answer += 2;
    		else if(i>=100 && i<1000)
    			answer += 3;
    		else if(i>=1000 && i<10000)
    			answer += 4;
    		else if(i>=10000 && i<100000)
    			answer += 5;
    		else if(i>=100000 && i<1000000)
    			answer += 6;
    		else if(i>=1000000 && i<10000000)
    			answer += 7;
    		else if(i>=10000000 && i<100000000)
    			answer += 8;
			else if(i>=100000000)
    			answer += 9;
    	}
    	System.out.println(answer);

		return 0;
	}
}