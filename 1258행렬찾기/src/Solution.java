import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {
	
	int x;
	int y;
	int s;
	
	Location(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.s = this.x * this.y;
	}

	public int compareTo(Location other) {
		
		if(this.s < other.s)
			return -1;
		else if(this.s > other.s)
			return 1;
		else {
			
			if(this.x < other.x)
				return -1;
			else if(this.x > other.x)
				return 1;
		}
		return 0;
	}
}

public class Solution {

	static PriorityQueue<Location> priorityQueue = new PriorityQueue<>();
	
	static boolean[][] map;
	static boolean[][] visited;
	
	static int[] loX = { -1, 0, 1, 0 };
	static int[] loY = { 0, 1, 0, -1 };
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new boolean[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++)
					map[i][j] = st.nextToken().equals("0") ? false : true;
			}
			
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j < N; j++) {
					
					if(!visited[i][j] && map[i][j])
						findAMatrix(i, j);
				}
			}
			System.out.print("#"+(test_case+1)+" "+priorityQueue.size() + " ");
			while(!priorityQueue.isEmpty()) {
				
				Location location = priorityQueue.poll();
				
				System.out.print(location.x + " " + location.y + " ");
			}
			System.out.println();
		}
		br.close();
	}

	static void findAMatrix(int startX, int startY) {
		
		int x = 0;
		int y = 0;
		
		for(int col = startY; col < N; col++)
			if(map[startX][col])
				y++;
			else
				break;
		for(int row = startX; row < N; row++)
			if(map[row][startY])
				x++;
			else
				break;
		
		for(int row = startX; row < startX + x; row++) {
			
			for(int col = startY; col < startY + y; col++)
				visited[row][col] = true;
		}
		priorityQueue.offer(new Location(x, y));
	}
}
