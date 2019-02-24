import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][][] cache;

	static int[] weights;
	static boolean[] available;

	static int Answer;
	static int N;

	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("3234준환이의양팔저울\\sample_input.txt"));
		StringTokenizer st = null;
		int value = 0;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());
			weights = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				weights[i] = Integer.parseInt(st.nextToken());

			init();
			JunhwanScales(0, 0, 0);

			System.out.println("#"+(test_case+1) + " " + Answer);

			Answer = 0;
			value = 0;
		}
		
		br.close();
	}

	static void init() {

		cache = new int[N + 1][N + 1][N + 1];
		available = new boolean[N];

		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				for(int k = 0; k < N; k++)
					cache[i][j][k] = -1;
	}

	static int JunhwanScales(int order, int left, int right) {

		if(order >= N) {

			Answer += (left >= right ? 1 : 0);
			return 0;
		}

		if(cache[order][left][right] != -1)
			return cache[order][left][right];

		for(int i = 0; i < N; i++) {

			if(!available[i]) {

				available[i] = true;
				cache[order][left + 1][right] = JunhwanScales( order + 1, left + 1, right) + weights[i];
				if(right + weights[i] <= left)
					cache[order][left][right + 1] = JunhwanScales( order + 1, left, right + 1) + weights[i];
				available[i] = false;
			}
		}

		return cache[order][left][right];
	}
}