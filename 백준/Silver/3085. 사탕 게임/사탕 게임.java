import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, swap(arr, i, j));
			}
		}

		System.out.print(max);
	}

	static int swap(char[][] arr, int x, int y) {
		int max = 0;

		// 배열을 복사해서 사용
		char[][] copyArr = deepCopy(arr);
		char temp = copyArr[x][y];

		// 오른쪽으로 스왑
		if (x < copyArr.length - 1) {
			copyArr[x][y] = copyArr[x + 1][y];
			copyArr[x + 1][y] = temp;
			max = search(copyArr);
		}

		// 원래 배열 복원 후 아래쪽으로 스왑
		copyArr = deepCopy(arr); // 원래 배열로 복원
		if (y < copyArr.length - 1) {
			copyArr[x][y] = copyArr[x][y + 1];
			copyArr[x][y + 1] = temp;
			max = Math.max(max, search(copyArr));
		}

		return max;
	}

	static char[][] deepCopy(char[][] original) {
		int length = original.length;
		char[][] copy = new char[length][length];
		for (int i = 0; i < length; i++) {
			copy[i] = original[i].clone();
		}
		return copy;
	}

	static int search(char[][] arr) {
		int total = 0;
		// 행 탐색
		for (int i = 0; i < arr.length; i++) {
			int max = 1;

			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					max++;
					total = Math.max(max, total);
				} else {
					max = 1;
				}
			}
		}

		// 열 탐색
		for (int i = 0; i < arr.length; i++) {
			int max = 1;

			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					max++;
					total = Math.max(max, total);
				} else {
					max = 1;
				}
			}
		}
		return total;
	}
}
