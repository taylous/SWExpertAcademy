import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
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

	static char[][] mineField;

	static int[] loX = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] loY = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int Answer;
	static int N;

	public static void main(String args[]) throws Exception	{

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("1868파핑파핑지뢰찾기\\input.txt"));
		char[] container = null;
        int space = 0;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());
			Answer = Integer.MAX_VALUE;
			mineField = new char[N][N];

			for(int i = 0; i < N; i++) {

				container = br.readLine().toCharArray();

				for(int j = 0; j < N; j++) {
                    mineField[i][j] = container[j];

                    if(mineField[i][j] == '.')
                        space++;
                }
			}
			for(int i = 0; i < N; i++) {

			    for(int j = 0; j < N; j++)
			        if(mineField[i][j] == '.')
			            poppingPappingMinesweeper(new boolean[N][N], i, j, space - 1, 1);
            }
			System.out.println("#"+(test_case+1) + " " + Answer);
			space = 0;
		}
		br.close();
	}

	static void poppingPappingMinesweeper(boolean[][] copyVisited, int startX, int startY, int remain, int click) {

        //System.out.println("startX : " + startX + " startY : " + startY + " remain : " + remain);
	    if(remain <= 0) {

	        Answer = Math.min(Answer, click);
            return;
        }
	    ArrayDeque<Location> arrayDeque = new ArrayDeque<>();
	    boolean[][] visited = new boolean[N][N];
	    int count = 0;

	    for(int i = 0; i < N; i++)
	        System.arraycopy(copyVisited[i], 0, visited[i], 0, N);
	    boolean flag = false;

        arrayDeque.add(new Location(startX, startY));
        visited[startX][startY] = true;

	    while(!arrayDeque.isEmpty()) {

	        Location t = arrayDeque.remove();
	        int x = t.x;
	        int y = t.y;

	        for(int i = 0; i < 8; i++) {

	            int nx = x + loX[i];
	            int ny = y + loY[i];

	            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
	                continue;
	            if(mineField[nx][ny] == '*') {

	                flag = true;
	                break;
                }
	        }
	        if(!flag) {

                for(int i = 0; i < 8; i++) {

                    int nx = x + loX[i];
                    int ny = y + loY[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;
                    if(visited[nx][ny] || mineField[nx][ny] == '*')
                        continue;

                    visited[nx][ny] = true;
                    count++;
                    arrayDeque.add(new Location(nx, ny));
                }
            }
	        flag = false;
        }
	    if(remain - count <= 0) {

            Answer = Math.min(Answer, click);
            return;
        }

	    for(int i = 0; i < N; i++) {

	        for(int j = 0; j < N; j++) {

	            if(!visited[i][j] && mineField[i][j] == '.')
	                poppingPappingMinesweeper(visited, i, j, remain - count - 1, click + 1);
            }
        }
    }
}