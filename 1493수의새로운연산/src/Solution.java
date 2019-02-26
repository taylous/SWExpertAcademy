import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] grid = new int[301][301];
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rowSum, colSum, ret;
		
		init();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			rowSum = colSum = ret = 0;
			
			for(int i = 1; i <= 200; i++) {
				
				for(int j = 1; j <= 200; j++) {
					
					if(N == grid[i][j] || M == grid[i][j]) {
						
						rowSum += i;
						colSum += j;
						ret++;
						break;
					}
				}
				if(ret == 2)
					break;
			}
			System.out.println("#" + (test_case + 1) + " " + grid[rowSum][colSum]);
		}
		br.close();
	}
	
	static int[] getOffset(int offset) {
		
		int[] ret = new int[2];
		int row = 1;
		int col = 1;
		
		while(true) {
			
			if(grid[row][col] == offset) {
			
				ret[0] = row;
				ret[1] = col;
				break;
			}
			
			if(grid[row][col] > offset)
				row--;
			else if(grid[row][col] < offset)
				col++;
		}
		return ret;
	}

	static void init() {

		int startNumber = 1;
		int startOffset = 1;
		int var, temp;
		int offset = 2;

		for (int i = 1; i <= 300; i++) {

			var = startNumber;
			temp = offset;

			for (int j = 1; j <= 300; j++) {

				grid[i][j] = var;
				var += temp;
				temp++;
			}
			startNumber += startOffset;
			startOffset++;
			offset++;
		}
	}
}