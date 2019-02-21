import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static char[][] board;
	static int len;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		char[] container;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			System.out.print("#" + (test_case + 1) + " ");
			board = new char[5][15];
			len = 0;

			for (int i = 0; i < 5; i++) {

				container = br.readLine().toCharArray();
				System.arraycopy(container, 0, board[i], 0, container.length);
				if(len < container.length)
					len = container.length;
			}

			
			for (int j = 0; j < len; j++) {
				
				for (int i = 0; i < 5; i++) {
					
					if (board[i][j] == '\u0000')
						continue;
					System.out.print(board[i][j]);
				}
			}
			System.out.println();
		}
		br.close();
	}

}
