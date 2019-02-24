import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Sand {

    int x;
    int y;

    Sand(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static ArrayDeque<Sand> arrayDeque = new ArrayDeque<>();
    static int[][] SandCastle;
    static int[][] NoSandArea;

    static int[] loX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] loY = {0, 1, 1, 1, 0, -1, -1, -1};

    static int Answer;
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("1907모래성쌓기\\sample_input.txt"));
        String[] container = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            container = br.readLine().split(" ");

            N = Integer.parseInt(container[0]);
            M = Integer.parseInt(container[1]);

            SandCastle = new int[N + 1][M + 1];
            for (int i = 0; i < N; i++) {

                container = br.readLine().split("");

                for (int j = 0; j < M; j++)
                    SandCastle[i][j] = container[j].equals(".") ? 0 : Integer.parseInt(container[j]);
            }
            SandsSweptByWaves();
            Answer = SandCasting();

            System.out.println("#" + (test_case + 1) + " " + Answer);
            arrayDeque.clear();
        }

        br.close();
    }

    static void SandsSweptByWaves() {

        NoSandArea = new int[N + 1][M + 1];

        for(int i = 1; i < N - 1; i++) {
            for(int j = 1; j < M - 1; j++) {

                if(SandCastle[i][j] != 0) {

                    int x = i;
                    int y = j;

                    for (int k = 0; k < 8; k++) {

                        int nx = x + loX[k];
                        int ny = y + loY[k];

                        if (SandCastle[nx][ny] == 0)
                            NoSandArea[i][j]++;
                    }

                    if(NoSandArea[i][j] >= SandCastle[i][j])
                        arrayDeque.add(new Sand(i, j));
                }
            }
        }
    }

    static int SandCasting() {

        int ret = 0;

        while(!arrayDeque.isEmpty()) {

            int size = arrayDeque.size();

            while(size-- > 0) {

                Sand sand = arrayDeque.remove();
                int x = sand.x;
                int y = sand.y;

                SandCastle[x][y] = 0;

                for (int i = 0; i < 8; i++) {

                    int nx = x + loX[i];
                    int ny = y + loY[i];

                    if (SandCastle[nx][ny] != 0) {
                        NoSandArea[nx][ny]++;

                        if (SandCastle[nx][ny] == NoSandArea[nx][ny]) {

                            SandCastle[nx][ny] = 0;
                            arrayDeque.add(new Sand(nx, ny));
                        }
                    }
                }
            }

            ret++;
        }

        return ret;
    }
}