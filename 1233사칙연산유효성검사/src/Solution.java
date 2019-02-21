import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {

	String item;
	int left;
	int right;

	public Node(String item, int left, int right) {

		this.item = item;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	static Node[] tree;

	static int Answer;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		String item;
		int no, var1, var2;

		for (int test_case = 0; test_case < 10; test_case++) {

			N = Integer.parseInt(br.readLine());

			System.out.print("#" + (test_case + 1) + " ");
			if (N % 2 == 0) {

				while(N-- > 0)
					br.readLine();
				System.out.println(0);
				continue;
			}
			st = new StringTokenizer(br.readLine());
				
			tree = new Node[N + 1];
			Answer = 1;

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				no = Integer.parseInt(st.nextToken());
				item = st.nextToken();

				if (st.hasMoreTokens())
					tree[no] = new Node(item, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else
					tree[no] = new Node(item, 0, 0);
			}
			try {
				for (int i = N; i >= 1; i--) {

					if (tree[i].left == 0)
						continue;
					var1 = Integer.parseInt(tree[tree[i].left].item);
					var2 = Integer.parseInt(tree[tree[i].right].item);
					
					switch (tree[i].item) {

					case "+":

						tree[i].item = String.valueOf((var1 + var2));
						break;

					case "-":

						tree[i].item = String.valueOf((var1 - var2));
						break;

					case "*":

						tree[i].item = String.valueOf((var1 * var2));
						break;

					case "/":

						try {
							tree[i].item = String.valueOf((var1 / var2));
						} catch (ArithmeticException e) {
						
							tree[i].item = "0";
						}
						break;
					}
				}
			} catch (NumberFormatException ignored) {

				Answer = 0;
			}
			System.out.println(Answer);
		}
		br.close();
	}

}
