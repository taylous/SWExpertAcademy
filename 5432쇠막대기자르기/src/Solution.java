import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	
	static int Answer;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("5432쇠막대기자르기\\sample_input.txt"));
        Stack<Integer> stack = new Stack<>();

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {

		    char[] IronRod = br.readLine().toCharArray();

		    for(int i = 0; i < IronRod.length; i++) {

		        if(IronRod[i] == '(') {

		            stack.push(i);
		            continue;
                }

                if(stack.peek() == i - 1) {

                    stack.pop();
                    Answer += stack.size();
                }
                else {

                    Answer++;
                    stack.pop();
                }
            }

			System.out.println("#"+test_case+" "+Answer);
		    Answer = 0;
		    stack.clear();
		}
		
		br.close();
	}
}