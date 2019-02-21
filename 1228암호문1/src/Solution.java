import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static LinkedList<Integer> cryptogram = new LinkedList<>();

	static int Answer;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		StringBuilder sb;

		int idx, size;

		for (int test_case = 0; test_case < 10; test_case++) {

			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			while (N-- > 0)
				cryptogram.add(Integer.parseInt(st.nextToken()));

			M = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			while (M-- > 0) {

				st.nextToken();
				idx = Integer.parseInt(st.nextToken());
				size = Integer.parseInt(st.nextToken());

				while (size-- > 0) {

					cryptogram.add(idx++, Integer.parseInt(st.nextToken()));
				}
			}
			sb = new StringBuilder();
			System.out.print("#" + (test_case + 1) + " ");
			
			for (int i = 0; i < 10; i++) {

				if (cryptogram.isEmpty())
					break;
				sb.append(cryptogram.remove());
				sb.append(" ");
			}
			System.out.println(sb.toString());
			cryptogram.clear();
		}
		br.close();
	}

}
