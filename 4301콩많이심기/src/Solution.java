import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static boolean[][] field;
	static int Answer;
	static int N;
	static int M;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("4301콩많이심기\\sample_input.txt"));
		StringTokenizer st = null;
		boolean chk = true;
		boolean chk2 = true;
		int count2 = 0;
		int count = 0;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine(), " ");

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			field = new boolean[N + 1][M + 1];

			//0 : Empty , 1 : Bean , 2 : Can't plant
			Answer = 0;
			count = 0;
			chk = true;
			for(int i = 0; i < N; i++) {

				count++;
				chk2 = chk;
				count2 = 0;
				for(int j = 0; j < M; j++) {

					field[i][j] = chk2;
					count2++;

					if(count2 == 2) {
						chk2 =  chk2 == true ? false : true;
						count2 = 0;
					}
				}

				if(count == 2) {

					chk = chk == true ? false : true;
					count = 0;
				}
			}

			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(field[i][j])
						Answer++;

			System.out.println("#"+(test_case+1) + " " + Answer);
		}
		
		br.close();
	}
}