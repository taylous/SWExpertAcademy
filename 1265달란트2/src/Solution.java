import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static long[][] cache;
	
	static int N;
	static int P;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			cache = new long[N + 1][P + 1];
			for(int i = 0; i <= N; i++)
				Arrays.fill(cache[i], -1);
			System.out.println("#"+(test_case+1)+" "+Dallant2(N, P));
		}
		br.close();
	}

	static long Dallant2(int dallant, int pack) {
		
		if(pack == 1)
			return dallant;
		
		if(cache[dallant][pack] != -1)
			return cache[dallant][pack];
		long ret = 0;
		
		for(int i = 1; i <= dallant - (pack - 1); i++)	
			ret = Math.max(ret, Dallant2(dallant - i, pack - 1) * i);
		return cache[dallant][pack] = ret;
	}
}
