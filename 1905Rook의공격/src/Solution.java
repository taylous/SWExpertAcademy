import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {

	int sum;
	int x;
	int y;

	public Location(int sum, int x, int y) {

		this.sum = sum;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Location other) {

		return this.sum < other.sum ? 1 : -1;
	}
}

public class Solution {

	static ArrayList<Location> location = new ArrayList<>();
	
	static int[][] board;
	static int[][] total;
	
	static int[] row;
	static int[] col;

	static int[] loX = { -1, 0, 1, 0 };
	static int[] loY = { 0, 1, 0, -1 };

	static int Answer;
	static int ret;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		StringTokenizer st;
		int sum;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());

			board = new int[N][N];
			total = new int[N][N];

			row = new int[N];
			col = new int[N];

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				sum = 0;

				for (int j = 0; j < N; j++) {

					sum += board[i][j] = Integer.parseInt(st.nextToken());
					col[j] += board[i][j];
				}
				row[i] = sum;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					total[i][j] = row[i] + col[j] - (board[i][j] * 2);
					location.add(new Location(total[i][j], i, j));
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(total[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			Collections.sort(location);
			int size = location.size();
			if(size > 100)
				size = 100;
			
			for(int i = 0; i < size; i++) {
				for(int j = i + 1; j < size; j++)
					Answer = Math.max(Answer, rookAttack(i, j));
			}
			System.out.println("#" + (test_case + 1) + " " + Answer);
			location.clear();
			Answer =  0;
		}
		br.close();
	}

	//메티즈님 풀이에서 아이디어를 얻었습니다.
	static int rookAttack(int rookIdx1, int rookIdx2) {

		Location rook1 = location.get(rookIdx1);
		Location rook2 = location.get(rookIdx2);
		
		int ret = total[rook1.x][rook1.y] + total[rook2.x][rook2.y];
		
		if(Answer > ret)
			return 0;
		
		if(rook1.y == rook2.y)
			ret -= col[rook1.y];
		else if(rook1.x == rook2.x)
			ret -= row[rook1.x];
		else
			ret -= (board[rook2.x][rook1.y] + board[rook1.x][rook2.y]);
		return ret;
	}
}
