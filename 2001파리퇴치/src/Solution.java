import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	
	static int Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
			
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i <= N - M; i++) {
				
				for(int j = 0; j <= N - M; j++)	
					Answer = Math.max(Answer, fightingParis(i, j));
			}
			System.out.println("#"+(test_case+1)+" "+Answer);
			Answer = 0;
		}
		br.close();
	}
	
	static int fightingParis(int startRow, int startCol) {
		
		int endRow = startRow + M;
		int endCol = startCol + M;
		int ret = 0;
		
		for(int row = startRow; row < endRow; row++) {
			
			for(int col = startCol; col < endCol; col++)
				ret += map[row][col];
		}
		return ret;
	}
}
