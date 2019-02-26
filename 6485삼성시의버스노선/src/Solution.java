import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] busRoute = new int[5001];
	
	static int Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb;
		
		int left, right;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				left = Integer.parseInt(st.nextToken());
				right = Integer.parseInt(st.nextToken());

				for(int j = left; j <= right; j++)
					busRoute[j]++;
			}
			sb = new StringBuffer();
			M = Integer.parseInt(br.readLine());
			while(M-- > 0) {
				
				sb.append(busRoute[Integer.parseInt(br.readLine())]);
				sb.append(" ");
			}
			System.out.println("#"+(test_case+1)+" "+sb.toString());
			Arrays.fill(busRoute, 0);
		}
		br.close();
	}

}
