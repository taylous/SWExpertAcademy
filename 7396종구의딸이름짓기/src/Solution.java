import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {

    char ch;
    int x;
    int y;

    public Location(char ch, int x, int y) {
        this.ch = ch;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Location other) {
        return this.ch < other.ch ? -1 : 1;
    }
}

public class Solution {

    static char[][] nameBoard;
    static String[][] cache;

    static int[] loX = { 1, 0 };
    static int[] loY = { 0, 1 };

    static StringBuffer Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("7396종구의딸이름짓기\\s_input.txt"));
        StringBuilder out = new StringBuilder();
        StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    st = new StringTokenizer(br.readLine());
		    Answer = new StringBuffer();

		    N = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(st.nextToken());

		    nameBoard = new char[N][M];
		    cache = new String[N][M];

		    for(int i = 0; i < N; i++)
		        System.arraycopy(br.readLine().toCharArray(), 0, nameBoard[i], 0, M);
			out.append("#");
			out.append(test_case+1);
			out.append(" ");
			out.append(namingJong_gusDaughter());
			out.append("\n");
		}
        System.out.println(out.toString());
		br.close();
	}

	static String namingJong_gusDaughter() {

        LinkedList<Location> linkedList = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        StringBuilder ret = new StringBuilder();
        Location location;

        int x, y, nx, ny, size, ch;
        int len = 1;

        linkedList.add(new Location(nameBoard[0][0], 0, 0));
        ret.append(nameBoard[0][0]);
        visited[0][0] = true;

        while(len < N + M - 1) {

            size = linkedList.size();
            ch = 'z';

            while (size-- > 0) {

                location = linkedList.remove();
                x = location.x;
                y = location.y;

                for (int i = 0; i < 2; i++) {

                    nx = x + loX[i];
                    ny = y + loY[i];

                    if (nx < N && ny < M) {

                        if(ch < nameBoard[nx][ny])
                            continue;

                        if(ch > nameBoard[nx][ny])
                            ch = nameBoard[nx][ny];
                        else if(ch == nameBoard[nx][ny] && visited[nx][ny])
                            continue;
                        visited[nx][ny] = true;
                        linkedList.add(new Location(nameBoard[nx][ny], nx, ny));
                    }
                }
            }
            ret.append((char)ch);
            len++;

            Collections.sort(linkedList);
            while(linkedList.size() != 1 && ch != linkedList.getLast().ch)
                linkedList.removeLast();
        }
        return ret.toString();
    }
}