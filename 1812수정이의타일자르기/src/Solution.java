import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Tile implements Comparable<Tile> {

	int height;
	int width;

	public Tile(int height, int width) {

		this.height = height;
		this.width = width;
	}

	@Override
	public int compareTo(Tile other) {
		
/*		if(this.height < other.height)
			return 1;
		else if(this.height > other.height)
			return -1;
		else {
			
			if(this.width < other.width)
				return 1;
			else if(this.width > other.width)
				return -1;
		}
		return 0;*/
		int left = Math.min(this.height, this.width);
		int right = Math.min(other.height, other.width);
		
		if(left < right)
			return 1;
		return -1;
	}
}

public class Solution {

	static PriorityQueue<Tile> boards = new PriorityQueue<>();
	static int[] tiles;

	static int Answer;
	static int N;
	static int M;

	public static void main(String args[]) throws Exception {

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		StringBuffer sb = new StringBuffer();
		Tile tile = null;
		boolean flag;
		int rSize;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			boards.offer(new Tile(M, M));
			tiles = new int[N];
			Answer = 1;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				tiles[i] = ((int) Math.pow(2, Integer.parseInt(st.nextToken())));
			Arrays.sort(tiles);

			for(int i = N - 1; i >= 0; i--) {

				rSize = tiles[i];
				flag = false;

				System.out.println("RequiredSize : " + rSize);
				for(Tile temp : boards)
					System.out.print("[" +temp.height + ", " + temp.width + "] ");
				System.out.println("\n");
				
				//for (int i = 0; i < boards.size(); i++) {

					if (boards.peek().height >= rSize && boards.peek().width >= rSize) {

						tile = boards.poll();

						if (tile.height == rSize) {

							if (tile.width - rSize > 0)
								boards.offer(new Tile(tile.height, tile.width - rSize));
						} else if (rSize == 1) {

							if (tile.height - rSize > 0)
								boards.offer(new Tile(tile.height - rSize, rSize));

							if (tile.width - rSize > 0)
								boards.offer(new Tile(tile.height, tile.width - rSize));
						} else {

							if (tile.height - rSize > 0)
								boards.offer(new Tile(tile.height - rSize, tile.width));
							if (tile.width - rSize > 0)
								boards.offer(new Tile(rSize, tile.width - rSize));
						}

						flag = true;
					}
				//}

				if (!flag) {

					Answer++;					
					
					if (M == rSize) {

						boards.offer(new Tile(M, M - rSize));
						
					} else if (rSize == 1) {

						boards.offer(new Tile(M - 1, M));
						boards.offer(new Tile(1, M - 1));
					} else {

						boards.offer(new Tile(M - rSize, M));
						boards.offer(new Tile(rSize, M - rSize));
					}
					
					System.out.print("ADD> ");
					for(Tile temp : boards)
						System.out.print("[" +temp.height + ", " + temp.width + "] ");
					System.out.println("\n");
				}
			}
			//System.out.println("#" + (test_case + 1) + " " + Answer);
			sb.append("#");
			sb.append(test_case + 1);
			sb.append(" ");
			sb.append(Answer);
			sb.append("\n");
			
			boards.clear();
		}
		System.out.println(sb.toString());
		br.close();
	}
}