import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static double[][] task;

	static double Answer;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			Answer = Double.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			
			task = new double[N][N];

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++)
					task[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
			}
			dongchulsWorkDistribution(0, 0, 1.0);
			System.out.format("#%d %.6f\n", (test_case + 1), Answer * 100);
		}
		br.close();
	}

	static void dongchulsWorkDistribution(int remainTask, int worker, double sum) {

		if(sum <= Answer)
			return;
		
		if (worker == N) {

			Answer = Math.max(Answer, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			
			if((remainTask & (1 << i)) == 0) {
				
				int copyTask = remainTask;
				dongchulsWorkDistribution(copyTask | (1 << i), worker + 1, sum * task[worker][i]);
			}
		}
	}
}
