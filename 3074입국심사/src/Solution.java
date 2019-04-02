import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static long[] examination;
	
	static long Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long left, right, mid, boundary;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Answer = Long.MAX_VALUE;
			
			examination = new long[N];
			
			for(int i = 0; i < N; i++)
				examination[i] = Long.parseLong(br.readLine());
			Arrays.sort(examination);
			
			left = 0;
			right = examination[N - 1] * M;
			
			while(left <= right) {
				
				mid = (left + right) / 2;
				boundary = 0;
				
				for(int i = 0; i < N; i++)
					boundary += (mid / examination[i]);
				
				if(boundary >= M) {
					
					right = mid - 1;
					Answer = Math.min(Answer, mid);
				}
				else
					left = mid + 1;
			}
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
		br.close();
	}
}