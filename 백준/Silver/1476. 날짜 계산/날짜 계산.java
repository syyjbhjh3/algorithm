import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strArr = br.readLine().split(" ");
        int x = 0, y = 0, z = 0, cnt = 0;
        int X = Integer.parseInt(strArr[0]); 
        int Y = Integer.parseInt(strArr[1]); 
        int Z = Integer.parseInt(strArr[2]);
        
        boolean flag = true;

        while (flag) {
            cnt++;
            x++;
            y++;
            z++;
            x = x == 16 ? 1 : x;
            y = y == 29 ? 1 : y;
            z = z == 20 ? 1 : z;

            if (x == X && y == Y && z == Z){
                flag = false;
                System.out.println(cnt);    
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}