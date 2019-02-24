import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int[] rowBoundary;
    static int[] colBoundary;

	static int Answer;
	static int N;
	
	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("1814서준이의퍼즐풀기\\input.txt"));
		StringTokenizer st = null;
		//boolean[][] puzzle;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());
			//puzzle = new boolean[N + 1][N + 1];
			rowBoundary = new int[N + 1];
			colBoundary = new int[N + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
                rowBoundary[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)
                colBoundary[i] = Integer.parseInt(st.nextToken());
            SolveThePuzzleOfSeoJun(0, 0);

            System.out.println("#"+(test_case+1) + " " + Answer);
            Answer = 0;
		}
		
		br.close();
	}

	static void SolveThePuzzleOfSeoJun(int rowIdx, int colIdx) {

	    if(rowIdx >= N) {

	        if(Answer == 0) {
                for (int i = 0; i < N; i++)
                    if (colBoundary[i] != 0)
                        return;
                Answer = 1;
            }
            else {

                Answer++;
            }

            return;
        }

        if(rowBoundary[rowIdx] == 0) {
            SolveThePuzzleOfSeoJun(rowIdx + 1, colIdx);
        }
	    else {

	        int temp = rowBoundary[rowIdx];
	        int count = 0;

            for (int col = 0; col < N; col++) {

                if(rowBoundary[rowIdx] == 0) {
                    SolveThePuzzleOfSeoJun(rowIdx + 1, colIdx = 0);
                }
                else if(colBoundary[col] == 0) {
                    continue;
                }
                else {

                    rowBoundary[rowIdx]--;
                    colBoundary[colIdx]--;
                    SolveThePuzzleOfSeoJun(rowIdx, colIdx + 1);
                    colBoundary[colIdx]++;
                    rowBoundary[rowIdx]++;
                }
            }
        }
    }
}