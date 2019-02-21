import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] ladder = new int[100][100];

	static int destX = 99;
	static int destY;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		for (int test_case = 0; test_case < 10; test_case++) {

			br.readLine();
			for (int i = 0; i < 100; i++) {

				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());

					if (i == 99 && ladder[i][j] == 2)
						destY = j;
				}
			}

			while (destX != 0) {

				if (destY - 1 >= 0 && ladder[destX][destY - 1] == 1) {

					while (destY - 1 >= 0 && ladder[destX][destY - 1] == 1)
						destY--;

				} else if (destY + 1 < 100 && ladder[destX][destY + 1] == 1) {

					while (destY + 1 < 100 && ladder[destX][destY + 1] == 1)
						destY++;
				}
				destX--;
			}
			System.out.println("#" + (test_case + 1) + " " + destY);
			destX = 99;
		}
		br.close();
	}

}
