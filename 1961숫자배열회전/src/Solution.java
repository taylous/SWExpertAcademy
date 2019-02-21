import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] matrix;
	
	static int[][] rotate90;
	static int[][] rotate180;
	static int[][] rotate270;

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;

		int ptr;
		int i, j;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());

			matrix = new int[N][N];
			
			rotate90 = new int[N][N];
			rotate180 = new int[N][N];
			rotate270 = new int[N][N];
			

			for (i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				for (j = 0; j < N; j++)
					matrix[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + (test_case + 1));
			
			//1 2 3
			//4 5 6
			//7 8 9
			ptr = N - 1;
			i = 0;
			for (int col = 0; col < N; col++) {
				
				j = 0;
				
				for (int row = 0; row < N; row++)
					rotate90[i][j++] = matrix[ptr--][col];
				i++;
				ptr = N - 1;
			}

			i = 0;
			for (int row = N - 1; row >= 0; row--) {

				j = 0;
				
				for (int col = N - 1; col >= 0; col--)
					rotate180[i][j++] = matrix[row][col];
				i++;
			}
			
			ptr = 0;
			i = 0;
			for (int col = N - 1; col >= 0; col--) {

				j = 0;
				
				for (int row = 0; row < N; row++)
					rotate270[i][j++] = matrix[row][col];
				i++;
			}
			
			for(int row = 0; row < N; row++) {
				
				for(int col = 0; col < N; col++)	
					System.out.print(rotate90[row][col]);
				System.out.print(" ");
				for(int col = 0; col < N; col++)	
					System.out.print(rotate180[row][col]);
				System.out.print(" ");
				for(int col = 0; col < N; col++)	
					System.out.print(rotate270[row][col]);
				System.out.println();
			}
		}
		br.close();
	}

}
