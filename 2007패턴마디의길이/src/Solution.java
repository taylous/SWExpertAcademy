import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int Answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String source, pattern, patternNxt;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			source = br.readLine();
			
			for(int i = 1; i < 10; i++) {

				pattern = source.substring(0, i);
				patternNxt = source.substring(i, i + i);
				
				if(pattern.equals(patternNxt)) {
					
					Answer = i;
					break;
				}
			}
			System.out.println("#"+(test_case+1)+" "+Answer);
			Answer = 0;
		}
		br.close();
	}

}
