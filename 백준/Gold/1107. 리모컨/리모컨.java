import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> errBtn = new ArrayList<>();
        if (num > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<num; i++){
                errBtn.add(Integer.parseInt(st.nextToken()));
            }
        }

        int ans = Math.abs(100 - channel);  // Move only using +, - buttons

        int mini = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i = 0; i <= 999999; i++) {  // Brute force search
            String str = String.valueOf(i);
            boolean chk = true;
            for(int k = 0; k < str.length(); k++) {
                if(errBtn.contains(str.charAt(k) - '0')) {  // If a broken button is in the number, skip
                    chk = false;
                    break;
                }
            }
            if(!chk) continue;

            cnt = str.length() + Math.abs(i - channel);  // Calculate button presses + +/- moves

            if(cnt < mini) {
                mini = cnt;
            }
        }

        if(mini < ans) ans = mini;
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}