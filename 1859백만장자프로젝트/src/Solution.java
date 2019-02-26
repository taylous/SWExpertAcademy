import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] elements;
	static long Answer;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		int max, maxIdx, start;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());
			max = maxIdx = start = 0;

			elements = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {

				elements[i] = Integer.parseInt(st.nextToken());

				if (max < elements[i]) {

					maxIdx = i;
					max = elements[i];
				}
			}
			while (start < N) {

				for (int i = start; i < maxIdx; i++)
					Answer += max - elements[i];

				int otherMaxIdx = maxIdx + 1;
				start = maxIdx + 1;
				max = 0;
				while (true) {

					for (int i = otherMaxIdx; i < N; i++) {

						if (max < elements[i]) {

							otherMaxIdx = i;
							max = elements[i];
						}
					}
					if (otherMaxIdx == maxIdx + 1) {

						otherMaxIdx++;
						start++;
						max = 0;
					} else {

						maxIdx = otherMaxIdx;
						break;
					}
				}
			}
			System.out.println("#" + (test_case + 1) + " " + Answer);
			Answer = 0;
		}
		br.close();
	}
}
