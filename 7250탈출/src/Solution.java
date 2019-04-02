import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Area {

	char type;
	int fire;

	public Area(char type, int fire) {

		super();
		this.type = type;
		this.fire = fire;
	}
}

class Location {

	int x;
	int y;
	int passes;
	int traveled;

	public Location(int x, int y, int passes, int traveled) {

		super();
		this.x = x;
		this.y = y;
		this.passes = passes;
		this.traveled = traveled;
	}
}

public class Solution {

	static ArrayDeque<Location> fireLocation = new ArrayDeque<>();
	static Area[][] map;

	static int[][] marvel = new int[3][3];
	static int[] loX = { -1, 0, 1, 0 };
	static int[] loY = { 0, 1, 0, -1 };

	static int scottAnswer;
	static int villainAnswer;
	static int N;
	static int M;
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sampleInput.txt"));
		StringTokenizer st;
		char[] container;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Area[N][M];
			for(int i = 0; i < 3; i++)
				Arrays.fill(marvel[i], -1);

			for (int i = 0; i < N; i++) {

				container = br.readLine().toCharArray();

				for (int j = 0; j < M; j++) {

					if (container[j] == 'S') {

						marvel[0][0] = i;
						marvel[0][1] = j;						
						
					} else if (container[j] == 'V') {

						marvel[1][0] = i;
						marvel[1][1] = j;
						
					} else if (container[j] == 'E') {

						marvel[2][0] = i;
						marvel[2][1] = j;		
						
					} else if (container[j] == 'F') {

						fireLocation.add(new Location(i, j, 0, 0));
					}
					map[i][j] = new Area(container[j], 987654321);
				}
			}
			fire();
			if (marvel[1][0] != -1)
				escape(marvel[1][0], marvel[1][1], true);
			escape(marvel[0][0], marvel[0][1], false);

			System.out.println("#" + (test_case + 1) + " " + (villainAnswer >= scottAnswer ? scottAnswer : -1));
			villainAnswer = scottAnswer = Integer.MAX_VALUE;
		}
		br.close();
	}

	static void fire() {

		boolean[][] visited = new boolean[N][M];
		Location location;
		int x, y, nx, ny, traveled;

		while (!fireLocation.isEmpty()) {

			location = fireLocation.remove();
			x = location.x;
			y = location.y;
			traveled = location.traveled;

			for (int i = 0; i < 4; i++) {

				nx = x + loX[i];
				ny = y + loY[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (visited[nx][ny] || map[nx][ny].type == 'W' || map[nx][ny].type == 'X')
					continue;

				visited[nx][ny] = true;
				map[nx][ny].fire = traveled + 1;
				fireLocation.add(new Location(nx, ny, 0, traveled + 1));
			}
		}
	}

	static void escape(int startX, int startY, boolean who) {

		ArrayDeque<Location> arrayDeque = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][K + 2];

		Location location;
		int x, y, nx, ny, passes, traveled;
		
		arrayDeque.add(new Location(startX, startY, K + 1, 0));
		visited[startX][startY][K] = true;

		while (!arrayDeque.isEmpty()) {

			location = arrayDeque.remove();
			x = location.x;
			y = location.y;
			passes = location.passes;
			traveled = location.traveled;

			if (x == marvel[2][0] && y == marvel[2][1]) {

				if (who)
					villainAnswer = traveled;
				else
					scottAnswer = traveled;
				return;
			}

			for (int i = 0; i < 4; i++) {

				nx = x + loX[i];
				ny = y + loY[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (visited[nx][ny][passes])
					continue;

				if (who) {

					if (map[nx][ny].type == 'W' || map[nx][ny].type == 'X')
						continue;

					visited[nx][ny][passes] = true;
					arrayDeque.add(new Location(nx, ny, passes, traveled + 1));
				} else {

					if (map[nx][ny].type == 'F' || map[nx][ny].type == 'X')
						continue;
					if (nx == marvel[2][0] && ny == marvel[2][1]) {

						scottAnswer = traveled + 1;
						return;
					}
					if (map[nx][ny].fire <= traveled)
						continue;

					if (map[nx][ny].type == 'A') {

						visited[nx][ny][passes] = true;
						arrayDeque.add(new Location(nx, ny, K + 1, traveled + 1));
						
					} else if (map[nx][ny].type == 'W') {

						if (passes == 0)
							continue;

						visited[nx][ny][passes] = true;
						arrayDeque.add(new Location(nx, ny, passes - 1, traveled + 1));
					}
				}
			}
		}
	}
}
