import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static ArrayDeque<Integer> code = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		int cycle, number;
		
		for(int test_case = 0; test_case < 10; test_case++) {
			
			System.out.print("#" + br.readLine() + " ");
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			cycle = 1;
			
			while(st.hasMoreTokens())
				code.addLast(Integer.parseInt(st.nextToken()));
			
			while(true) {
				
				number = code.removeFirst() - cycle++;
				
				if(number <= 0) {
					
					while(!code.isEmpty()) {
						sb.append(code.remove());
						sb.append(" ");
					}
					sb.append(0);
					break;
				}
				cycle = cycle == 6 ? 1 : cycle;
				code.addLast(number);
			}
			System.out.println(sb.toString());
		}
		br.close();
	}

}
