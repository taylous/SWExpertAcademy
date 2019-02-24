import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static HashSet<Integer> set = new HashSet<>();
    static int[][] grid = new int[4][4];

    static int[] loX = { -1, 0, 1, 0 };
    static int[] loY = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("2819격자판의숫자이어붙이기\\sample_input.txt"));
        StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    for(int i = 0; i < 4; i++) {

		        st = new StringTokenizer(br.readLine());

		        for(int j = 0; j < 4; j++)
		            grid[i][j] = Integer.parseInt(st.nextToken());
            }
		    for(int i = 0; i < 4; i++) {

		        for(int j = 0; j < 4; j++)
		            attachNumberOfGrid(grid[i][j], 1, i, j);
            }
            System.out.println("#" + (test_case + 1) + " " + set.size());
		    set.clear();
        }
		br.close();
	}

	static void attachNumberOfGrid(int result, int times, int x, int y) {

	    if(times == 7) {

	        set.add(result);
            return;
        }
	    int nx, ny;

	    for(int i = 0; i < 4; i++) {

	        nx = x + loX[i];
	        ny = y + loY[i];

	        if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
	            continue;

	        attachNumberOfGrid((result * 10) + grid[nx][ny], times + 7, nx, ny);
        }
    }
}