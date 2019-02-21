import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] chk;

	static int N;
	static int K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			chk = new boolean[N + 1];

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				chk[Integer.parseInt(st.nextToken())] = true;

			System.out.print("#" + (test_case + 1) + " ");
			for (int i = 1; i <= N; i++)
				if (!chk[i])
					System.out.print(i + " ");
			System.out.println();
		}
		br.close();
	}
}