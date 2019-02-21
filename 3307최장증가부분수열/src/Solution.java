import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] sequence;
	static int[] cache;
	
	static int Answer;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			sequence = new int[N];
			cache = new int[N];
			java.util.Arrays.fill(cache, -1);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				sequence[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++)
				Answer = Math.max(Answer, LIS(i));
			System.out.println("#"+(test_case+1)+" "+Answer);
			Answer = 0;
		}
		br.close();
	}

	static int LIS(int idx) {
		
		if(cache[idx] != -1)
			return cache[idx];
		
		int ret = 1;
		for(int i = idx + 1; i < N; i++) {
			
			if(sequence[i] > sequence[idx])
				ret = Math.max(ret, LIS(i) + 1);
			
		}
		return cache[idx] = ret;
	}
}
