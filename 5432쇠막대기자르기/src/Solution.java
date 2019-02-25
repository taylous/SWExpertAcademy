import java.io.BufferedReader;
import java.io.InputStreamReader;
<<<<<<< HEAD

public class Solution {

	//static Stack<Character> stack = new Stack<>();
	static int Answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		char[] container;
		int bar = 0;
		int size;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			container = br.readLine().toCharArray();
			size = container.length;
			bar = 0;

			for (int i = 0; i < size; i++) {

				if (container[i] == '(') {

					if (container[i + 1] == ')') {

						Answer += bar;
						i++;
					} else
						bar++;;
				} else {

					Answer += 1;
					bar--;
				}
			}
			System.out.println("#" + (test_case + 1) + " " + Answer);
			Answer = 0;
		}
		br.close();
	}

}
=======
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
>>>>>>> f5f811e0f964cb248727b0a9688416a6d236ec10
