import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Location {
	
	int x;
	int y;
	
	Location(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	static int[][] matrix = new int[100][100];
	
	static int[] loX = { -1, 0, 1, 0 };
	static int[] loY = { 0, 1, 0, -1 };

	static int startX;
	static int startY;
	static int endX;
	static int endY;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number;
		char[] container;
		
		for(int test_case = 0; test_case < 10; test_case++) {
			
			number = br.readLine();
			
			for(int i = 0; i < 100; i++) {
				
				container = br.readLine().toCharArray();
				
				for(int j = 0; j < 100; j++) {
					
					matrix[i][j] = container[j] - '0';
					
					if(matrix[i][j] == 2) {
						
						startX = i;
						startY = j;
					}
					else if(matrix[i][j] == 3) {
						
						endX = i;
						endY = j;
					}
				}
			}
			System.out.println("#"+number+" "+ (maze2() ? 1 : 0));
		}
		br.close();
	}

	static boolean maze2() {
		
		ArrayDeque<Location> arrayDeque = new ArrayDeque<>();
		boolean[][] visited = new boolean[100][100];
		
		Location t;
		int x, y, nx, ny;
		
		arrayDeque.add(new Location(startX, startY));
		visited[startX][startY] = true;
		
		while(!arrayDeque.isEmpty()) {
			
			t = arrayDeque.remove();
			x = t.x;
			y = t.y;
			
			if(x == endX && y == endY)
				return true;
			
			for(int i = 0; i < 4; i++) {
				
				nx = x + loX[i];
				ny = y + loY[i];
				
				if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100)
					continue;
				if(visited[nx][ny] || matrix[nx][ny] == 1)
					continue;
				
				visited[nx][ny] = true;
				arrayDeque.add(new Location(nx, ny));
			}
		}
		return false;
	}
}
