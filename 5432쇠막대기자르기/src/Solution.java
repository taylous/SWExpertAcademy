import java.io.BufferedReader;
import java.io.InputStreamReader;

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
