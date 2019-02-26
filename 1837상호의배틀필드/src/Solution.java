import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static char[][] battleField;

	static int[] loX = { -1, 0, 1, 0 };
	static int[] loY = { 0, 1, 0, -1 };

	static int tankX;
	static int tankY;

	static int Answer;
	static int H;
	static int W;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		char[] container;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			battleField = new char[H][W];

			for (int i = 0; i < H; i++) {

				container = br.readLine().toCharArray();

				for (int j = 0; j < W; j++) {
					battleField[i][j] = container[j];

					if (battleField[i][j] == '^' || battleField[i][j] == 'v' || battleField[i][j] == '<'
							|| battleField[i][j] == '>') {

						tankX = i;
						tankY = j;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			container = br.readLine().toCharArray();

			for (int i = 0; i < N; i++)
				sangHosBattlefield(container[i]);

			System.out.print("#" + (test_case + 1) + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					System.out.print(battleField[i][j]);
				System.out.println();
			}
		}
		br.close();
	}

	static char getDirection(char dir) {

		return dir == 'U' ? '^' : dir == 'D' ? 'v' : dir == 'R' ? '>' : dir == 'L' ? '<' : null;
	}

	static int getAddr(char dir) {

		return dir == 'U' ? 0 : dir == 'D' ? 2 : dir == 'L' ? 3 : dir == 'R' ? 1 : -1;
	}

	static void sangHosBattlefield(char command) {

		int nx, ny;
		int idx;

		switch (command) {

		case 'U':
		case 'D':
		case 'L':
		case 'R':

			battleField[tankX][tankY] = getDirection(command);
			idx = getAddr(command);

			nx = tankX + loX[idx];
			ny = tankY + loY[idx];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W)
				break;
			if (battleField[nx][ny] == '.') {

				char ch = battleField[tankX][tankY];
				battleField[tankX][tankY] = '.';
				battleField[nx][ny] = ch;

				tankX += loX[idx];
				tankY += loY[idx];
			}
			break;

		case 'S':

			if (battleField[tankX][tankY] == '^')
				idx = 0;
			else if (battleField[tankX][tankY] == 'v')
				idx = 2;
			else if (battleField[tankX][tankY] == '>')
				idx = 1;
			else
				idx = 3;

			int x = tankX;
			int y = tankY;

			while (true) {

				nx = x + loX[idx];
				ny = y + loY[idx];

				if (nx < 0 || nx >= H || ny < 0 || ny >= W)
					break;
				if (battleField[nx][ny] == '#')
					break;
				if (battleField[nx][ny] == '*') {
					battleField[nx][ny] = '.';
					break;
				}

				x += loX[idx];
				y += loY[idx];
			}
			break;
		}
	}
}
