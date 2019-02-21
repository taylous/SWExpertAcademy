import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		char[] container;
		int answer;
		int start;
		int end;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			container = br.readLine().toCharArray();
			start = 0;
			end = container.length - 1;
			answer = 1;
			
			while(true) {
			
				if(start >= end)
					break;
				
				if(container[start++] != container[end--]) {
					
					answer = 0;
					break;
				}
			}
			System.out.println("#"+(test_case+1)+" "+answer);
		}
		br.close();
	}
}