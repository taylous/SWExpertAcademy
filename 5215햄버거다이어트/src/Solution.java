import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] flavorScore;
	static int[] calorieScore;

	static int[][] cache;
	
	static int Answer;
	static int N;
	static int L;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			cache = new int[N + 1][L + 1];
			for(int i = 0; i <= N; i++)
				java.util.Arrays.fill(cache[i], -1);
			
			flavorScore = new int[N];
			calorieScore = new int[N];
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				flavorScore[i] = Integer.parseInt(st.nextToken());
				calorieScore[i] = Integer.parseInt(st.nextToken());
			}
			Answer = hamburgerDiet(0, 0);
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
		br.close();
	}

	static int hamburgerDiet(int idx, int calorieSum) {
		
		if(idx >= N)
			return 0;
		
		if(cache[idx][calorieSum] != -1)
			return cache[idx][calorieSum];
		
		int ret = hamburgerDiet(idx + 1, calorieSum);
		if(calorieScore[idx] + calorieSum <= L)
			ret = Math.max(ret, hamburgerDiet(idx + 1, calorieSum + calorieScore[idx]) + flavorScore[idx]);	
		return cache[idx][calorieSum] = ret;
	}
}
