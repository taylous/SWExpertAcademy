import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

	static BigInteger A;
	static BigInteger B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
		
			st = new StringTokenizer(br.readLine());
			
			sb = new StringBuilder();
			A = new BigInteger(st.nextToken());
			B = new BigInteger(st.nextToken());
			
			/**
			 * 
			 */
			
			sb.append("#"+(test_case+1)+" "+(A.add(B)).toString());
			System.out.println(sb.toString());
		}
		br.close();
	}
}