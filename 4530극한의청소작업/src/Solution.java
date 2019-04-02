import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static long aFour;
	static long bFour;
	static long Answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		StringTokenizer st;
		
		long A, B;
		String strA, strB;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			strA = st.nextToken();
			strB = st.nextToken();
			
			aFour = extremeCleaningWork(strA.toCharArray());
			bFour = extremeCleaningWork(strB.toCharArray());
			
			A = Long.parseLong(strA);
			B = Long.parseLong(strB);
			
			if(A < 0 && B > 0) {
				
				Answer = B - A;
				Answer -= aFour;
				Answer -= bFour;
				Answer -= 1;
			}
			else if(A > 0 && B < 0) {
				
				Answer = A - B;
				Answer -= aFour;
				Answer -= bFour;
				Answer -= 1;
			}
			else {
				
				Answer = Math.abs(A - B);
				Answer -= Math.abs(aFour - bFour);
			}			
			System.out.println("#"+(test_case+1)+" "+ Answer);
			Answer = 0;
		}
		br.close();
	}

	static long extremeCleaningWork(char[] floor) {
		
		int n = floor.length, digit = 1;
		long four = 0, number;
		
		for(int i = n - 1; i >= 0; i--) {
			
			if(floor[i] == '-')
				continue;
			number = floor[i] - '0';
			
			if(number > 4)
				four += ((number - 1) * (Math.pow(10, (digit - 1)) - Math.pow(9, (digit - 1))) + Math.pow(10, digit - 1));
			else
				four += (number * (Math.pow(10, (digit - 1)) - Math.pow(9, (digit - 1))));
			digit++;
		}
		return four;
	}
}
