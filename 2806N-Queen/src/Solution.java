import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int Answer;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());

			if (N == 1)
				Answer = 1;
			else if (N == 2 || N == 3)
				Answer = 0;
			else {

				for (int i = 0; i < N; i++)
					nQueen(new boolean[N][N], i, N);
			}
			System.out.println("#" + (test_case + 1) + " " + Answer);
			Answer = 0;
		}
		br.close();
	}

	static void nQueen(boolean[][] copy, int idx, int queen) {

		if (idx == N) {

			if(queen == 0)
				Answer++;
			return;
		}
		boolean[][] chess = new boolean[N][N];
		int row, col;
		
		for (int i = 0; i < N; i++) {
			
			if(!copy[idx][i]) {

				for(int j = 0; j < N; j++)
					System.arraycopy(copy[j], 0, chess[j], 0, N);
				
				chess[idx][i] = true;
				row = idx - 1;
				col = i - 1;
				
				while(row >= 0 && col >= 0)
					chess[row--][col--] = true;
				
				row = idx - 1;
				while(row >= 0)
					chess[row--][i] = true;
				
				row = idx - 1;
				col = i + 1;
				while(row >= 0 && col < N)
					chess[row--][col++] = true;
				
				row = idx + 1;
				while(row < N)
					chess[row++][i] = true;
				
				row = idx + 1;
				col = i + 1;
				while(row < N && col < N)
					chess[row++][col++] = true;
				
				row = idx + 1;
				col = i - 1;
				while(row < N && col >= 0)
					chess[row++][col--] = true;
				
				nQueen(chess, idx + 1, queen - 1);
			}
		}
	}
}
