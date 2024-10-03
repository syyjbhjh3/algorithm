import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++){
            long answer = 0;
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            answer = arr[b] - arr[a-1];
            System.out.println(answer);
        }
    }
}
