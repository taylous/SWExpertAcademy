import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;

	static int N;
	static int M;

	public static void main(String args[]) throws Exception	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("3289서로소집합\\sample_input.txt"));
		StringTokenizer st = null;
		int separator, pP, qP;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			for(int i = 0; i <= N; i++)
				parents[i] = i;

            System.out.print("#"+(test_case + 1)+" ");
			while(M-- > 0) {

				st = new StringTokenizer(br.readLine(), " ");

				separator = Integer.parseInt(st.nextToken());

				if(separator == 1) {

					pP = getRoot(Integer.parseInt(st.nextToken()));
					qP = getRoot(Integer.parseInt(st.nextToken()));

					if(pP == qP) {

						System.out.print("1");
						continue;
					}

					System.out.print("0");
					continue;
				}
				else
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			}
			System.out.println();
		}

		br.close();
	}

	static int getRoot(int n) {

		if(n == parents[n])
			return n;
		return parents[n] = getRoot(parents[n]);
	}

	static void union(int p, int q) {

		int pP = getRoot(p);
		int qP = getRoot(q);

		if(pP == qP)
			return;

		parents[pP] = qP;
	}
}