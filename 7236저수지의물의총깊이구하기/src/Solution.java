import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Water {
	
	int x;
	int y;
	
	public Water(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	static ArrayDeque<Water> waters = new ArrayDeque<>();
	
	static char[][] reservoir;
	
	static int[] loX = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] loY = { -1, 0, 1, 1, 1, 0, -1, -1 };
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			
			reservoir = new char[N][N];
			
			for(int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++) {
					
					reservoir[i][j] = st.nextToken().charAt(0);
					
					if(reservoir[i][j] == 'W')
						waters.add(new Water(i, j));
				}
			}
			System.out.println("#"+(test_case+1)+" "+getTheTotalDepthOfTheWaterInTheReservoir());
		}
		br.close();
	}

	static int getTheTotalDepthOfTheWaterInTheReservoir() {
		
		Water water;
		int x, y, nx, ny;
		int maxDepth = 0, depth;
		
		while(!waters.isEmpty()) {
			
			water = waters.remove();
			x = water.x;
			y = water.y;
			depth = 0;
			
			for(int i = 0; i < 8; i++) {
				
				nx = x + loX[i];
				ny = y + loY[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				
				depth += reservoir[nx][ny] == 'W' ? 1 : 0;
			}
			maxDepth = Math.max(maxDepth, depth);
		}
		return maxDepth;
	}
}
