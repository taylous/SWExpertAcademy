import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static double combination[] = {1.0, 18.0, 153.0, 816.0, 3060.0, 8568.0, 18564.0, 31824.0, 43758.0, 48620.0, 43758.0, 31824.0, 18564.0, 8568.0, 3060.0, 816.0, 153.0, 18.0, 1.0};
	static int[] prime = { 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0};
	static double Answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		double successA;
		double successB;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			successA = Double.parseDouble(st.nextToken()) / 100.0;
			successB = Double.parseDouble(st.nextToken()) / 100.0;
			
			
			for(int i = 0; i <= 18; i++) {
				
				for(int j = 0; j <= 18; j++) {
					
					if(prime[i] == 1 || prime[j] == 1)
						Answer += combination[i] * Math.pow(successA, i) * Math.pow(1 - successA, 18 - i) * combination[j] * Math.pow(successB, j) * Math.pow(1 - successB, 18 - j);
				}
			}
			System.out.format("#%d %.6f\n", (test_case+1), Answer);
			successA = successB = 0;
			Answer = 0;
		}
		br.close();
	}

}
