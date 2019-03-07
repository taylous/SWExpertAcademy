import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] region;

	static int[] loX = { -1, 0, 1, 0 };
	static int[] loY = { 0, 1, 0, -1 };

	static int Answer;
	static int N;
	static int B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sampleInput.txt"));
		StringTokenizer st;
		int x, y;

		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			region = new int[N][N];

			while(B-- > 0) {

				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				
				region[x][y] = -1;
				safetyBase(x, y);
			}			
			System.out.println("#" + (test_case + 1) + " " + Answer);
			Answer = 0;
		}
		br.close();
	}

	static void safetyBase(int startX, int startY) {

		int x, y, count;

		for (int i = 0; i < 4; i++) {

			x = startX + loX[i];
			y = startY + loY[i];
			count = 0;

			while (x >= 0 && x < N && y >= 0 && y < N) {

				if(count++ == 2)
					break;
				
				if (region[x][y] != -1) {

					region[x][y]++;
					Answer = Math.max(Answer, region[x][y]);
				}
				x += loX[i];
				y += loY[i];
			}
		}
	}
}
