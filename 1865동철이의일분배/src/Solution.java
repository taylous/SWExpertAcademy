import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] task;
	static double[][] cache = new double[17][65537];
	
	static double Answer;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			task = new int[N][N];
			for(int i = 0; i <= 16; i++)
				Arrays.fill(cache[i], -1);
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
					
				for(int j = 0; j < N; j++)
					task[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.format("#%d %.6f\n", (test_case + 1), (dongchulsWorkDistribution(0, 0) * 100));
			Answer = 0.0;
		}
		br.close();
	}

	static double dongchulsWorkDistribution(int worker, int status) {
		
		if(worker >= N)
			return 1.0;
		if(cache[worker][status] != -1)
			return cache[worker][status];
		
		double ret = 0.0;
		
		for(int i = 0; i < N; i++) {
			
			if((status & 1 << i) == 0) {
				
				int tempStatus = status;
				tempStatus |= 1 << i;
				ret = Math.max(ret, dongchulsWorkDistribution(worker + 1, tempStatus) * (task[worker][i] / 100.0));
			}
		}
		return cache[worker][status] = ret;
	}
}
