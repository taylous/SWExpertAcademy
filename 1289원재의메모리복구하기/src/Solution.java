import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static char[] originBit;
	static char[] currentBit;
	
	static int Answer;
	static int size;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			originBit = br.readLine().toCharArray();
			currentBit = new char[originBit.length];
			size = originBit.length;

			for(int i = 0; i < size; i++)
				currentBit[i] = '0';
			
			for(int i = 0; i < size; i++) {
				
				if(originBit[i] != currentBit[i]) {
					
					for(int j = i; j < size; j++)
						currentBit[j] = originBit[i];
					Answer++;
				}
			}
			
			System.out.println("#"+(test_case+1)+" "+Answer);
			Answer = 0;
		}
		br.close();
	}
}
