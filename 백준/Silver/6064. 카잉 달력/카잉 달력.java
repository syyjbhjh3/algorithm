import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            int answer = -1;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int k = x;
            while(k <= a*b){
                if((k-1)%b+1 == y){
                    answer = k;
                    break;
                }
                k += a;
            }
            System.out.println(answer);
        }
    }
}
