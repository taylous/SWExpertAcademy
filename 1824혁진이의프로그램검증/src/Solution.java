import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static String[][] expression;

    static int[] loX = {-1, 0, 1, 0};
    static int[] loY = {0, 1, 0, -1};

    static int Answer;
    static int Direction;
    static int Memory;

    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("1824혁진이의프로그램검증\\input.txt"));
        StringTokenizer st = null;
        String[] temp = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            expression = new String[N + 1][M + 1];

            for (int i = 0; i < N; i++) {

                temp = br.readLine().split("");

                for (int j = 0; j < M; j++)
                    expression[i][j] = temp[j];
            }
            Answer = 0;
            Direction = 1;
            Memory = 0;
            Answer = HyeogjinProgramVerification(new int[N + 1][M + 1], 0, 0);

            System.out.println("#" + (test_case + 1) + " " + (Answer > 0 ? "YES" : "NO"));
        }

        br.close();
    }

    static int getDirection(String dir) {

        if (dir.equals("^"))
            return 0;
        else if (dir.equals(">"))
            return 1;
        else if (dir.equals("v"))
            return 2;
        else
            return 3;
    }

    static int HyeogjinProgramVerification(int[][] visited, int x, int y) {

        if(Answer > 0)
            return Answer;

        int nx = 0;
        int ny = 0;

        visited[x][y]++;

        if (visited[x][y] >= 5)
            return 0;

        switch (expression[x][y]) {

            case ".":
                break;
            case "@":
                Answer++;
                break;
            case ">":
            case "<":
            case "v":
            case "^":
                Direction = getDirection(expression[x][y]);
                break;
            case "_":
                if (Memory == 0)
                    Direction = 1;
                else
                    Direction = 3;
                break;
            case "|":
                if (Memory == 0)
                    Direction = 2;
                else
                    Direction = 0;
                break;
            case "+":
                if (Memory == 15)
                    Memory = 0;
                else
                    Memory++;
                break;
            case "-":
                if (Memory == 0)
                    Memory = 15;
                else
                    Memory--;
                break;
            case "?":
                for (int i = 0; i < 4; i++) {

                    nx = x + loX[i];
                    ny = y + loY[i];

                    nx = nx < 0 ? N - 1 : nx;
                    nx = nx >= N ? 0 : nx;
                    ny = ny < 0 ? M - 1 : ny;
                    ny = ny >= M ? 0 : ny;

                    Direction = i;
                    Answer += HyeogjinProgramVerification(visited, nx, ny);

                    if(Answer > 0)
                        return 1;
                }
                return 0;

            default:
                Memory = Integer.parseInt(expression[x][y]);
                break;
        }

        nx = x + loX[Direction];
        ny = y + loY[Direction];

        nx = nx < 0 ? N - 1 : nx;
        nx = nx >= N ? 0 : nx;
        ny = ny < 0 ? M - 1 : ny;
        ny = ny >= M ? 0 : ny;

        return Answer += HyeogjinProgramVerification(visited, nx, ny);
    }
}