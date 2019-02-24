import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Matrix {

    int row;
    int col;

    Matrix(int row, int col) {

        this.row = row;
        this.col = col;
    }
}

class Location {

    int x;
    int y;

    Location(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static boolean[][] container;
    static boolean[][] visited;

    static int[] loX = { -1, 0, 1, 0 };
    static int[] loY = { 0, 1, 0, -1 };

	static int Answer;
	static int N;
	
	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("1260[SW문제해결응용]7일차_화학물질2\\sample_input.txt"));
        StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    N = Integer.parseInt(br.readLine());

		    container = new boolean[N][N];
		    visited = new boolean[N][N];

		    for(int i = 0; i < N; i++) {

		        st = new StringTokenizer(br.readLine(), " ");

		        for(int j = 0; j < N; j++) {

		            if(!st.nextToken().equals("0"))
		                container[i][j] = true;
                }
            }

            for(int i = 0; i < N; i++) {

                for(int j = 0; j < N; j++) {

                    if(!visited[i][j] && container[i][j]) {

                        int[] matrixRange = Chemicals2(i, j);

                        System.out.println(matrixRange[0] + " " + matrixRange[1]);
                    }
                }
            }

			System.out.println("#"+(test_case+1) + " " + Answer);
		}
		
		br.close();
	}

	static int[] Chemicals2(int startX, int startY) {

        ArrayDeque<Location> arrayDeque = new ArrayDeque<>();
        int[] ret = new int[2];

        arrayDeque.add(new Location(startX, startY));
        visited[startX][startY] = true;

        int row = 0;
        int col = 0;

        while(!arrayDeque.isEmpty()) {

            Location t = arrayDeque.remove();
            int x = t.x;
            int y = t.y;

            for(int i = 0; i < 4; i++) {

                try {

                    int nx = x + loX[i];
                    int ny = y + loY[i];

                    if(visited[nx][ny] || !container[nx][ny])
                        continue;

                    row = Math.max(row, nx);
                    col = Math.max(col, ny);

                    visited[nx][ny] = true;
                    arrayDeque.add(new Location(nx, ny));

                } catch (ArrayIndexOutOfBoundsException e) { continue; }
            }
        }

        ret[0] = (row - startX) + 1;
        ret[1] = (col - startY) + 1;
        return ret;
    }
}