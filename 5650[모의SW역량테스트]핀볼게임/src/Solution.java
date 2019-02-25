import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Block {

    int number;
    int[] reflect;

    Block(int number) {

        this.number = number;

        if (this.number >= 1 && this.number <= 6)
            setReflect();
    }

    private void setReflect() {

        if (this.number == 1)
            this.reflect = new int[]{2, 3, 1, 0};
        else if (this.number == 2)
            this.reflect = new int[]{1, 3, 0, 2};
        else if (this.number == 3)
            this.reflect = new int[]{3, 2, 0, 1};
        else if (this.number == 4)
            this.reflect = new int[]{2, 0, 3, 1};
        else if (this.number == 5)
            this.reflect = new int[]{2, 3, 0, 1};
    }
}

class Location {

    int x;
    int y;
    int times;
    int dir;

    Location(int x, int y, int times, int dir) {

        this.x = x;
        this.y = y;
        this.times = times;
        this.dir = dir;
    }
}

public class Solution {

    static Block[][] pinBallMap;

    static int[][] wormHoleLeft = new int[5][2];
    static int[][] wormHoleRight = new int[5][2];

    static int[] loX = {-1, 0, 1, 0};
    static int[] loY = {0, 1, 0, -1};

    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());

            pinBallMap = new Block[N + 2][N + 2];
            init();

            for (int i = 1; i <= N; i++) {

                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 1; j <= N; j++) {

                    int number = Integer.parseInt(st.nextToken());

                    if (number != 0) {

                        if (number > 5) {

                            pinBallMap[i][j] = new Block(number);
                            number -= 6;

                            if (wormHoleLeft[number][0] == -1) {

                                wormHoleLeft[number][0] = i;
                                wormHoleLeft[number][1] = j;
                            } else {

                                wormHoleRight[number][0] = i;
                                wormHoleRight[number][1] = j;
                            }
                        } else {

                            pinBallMap[i][j] = new Block(number);
                        }
                    }
                }
            }

            for (int i = 1; i <= N + 1; i++) {

                for (int j = 1; j <= N + 1; j++) {

                    for (int k = 0; k < 4; k++) {
                        if (pinBallMap[i][j].number == 0)
                            Answer = Math.max(Answer, PinBallGame(i, j, k));
                    }
                }
            }

            System.out.println("#" + (test_case + 1) + " " + Answer);
            Answer = 0;
        }

        br.close();
    }

    static void init() {

        for (int i = 0; i <= N + 1; i++) {

            for (int j = 0; j <= N + 1; j++) {

                if (i == 0 || i == N + 1)
                    pinBallMap[i][j] = new Block(-2);
                else if (j == 0 || j == N + 1)
                    pinBallMap[i][j] = new Block(-2);
                else
                    pinBallMap[i][j] = new Block(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            Arrays.fill(wormHoleLeft[i], -1);
            Arrays.fill(wormHoleRight[i], -1);
        }
    }

    static int PinBallGame(int startX, int startY, int startD) {

        ArrayDeque<Location> arrayDeque = new ArrayDeque<>();
        int ret = 0;

        arrayDeque.add(new Location(startX, startY, 0, startD));

        while (!arrayDeque.isEmpty()) {

            Location t = arrayDeque.remove();
            int x = t.x;
            int y = t.y;
            int times = t.times;
            int dir = t.dir;

            int nx = x + loX[dir];
            int ny = y + loY[dir];

            if(pinBallMap[nx][ny].number == -2) {

                times++;

                if(dir == 0)
                    dir = 2;
                else if(dir == 1)
                    dir = 3;
                else if(dir == 2)
                    dir = 0;
                else
                    dir = 1;

                if(pinBallMap[x][y].number >= 1 && pinBallMap[x][y].number <= 5) {

                    dir = pinBallMap[x][y].reflect[dir];
                    times++;
                }
                else if(pinBallMap[x][y].number >= 6 && pinBallMap[x][y].number <= 10) {

                    int wormHoleNumber = pinBallMap[x][y].number - 6;

                    if(wormHoleLeft[wormHoleNumber][0] == x && wormHoleLeft[wormHoleNumber][1] == y) {

                        x = wormHoleRight[wormHoleNumber][0];
                        y = wormHoleRight[wormHoleNumber][1];
                    }
                    else {

                        x = wormHoleLeft[wormHoleNumber][0];
                        y = wormHoleLeft[wormHoleNumber][1];
                    }
                }
                else if (pinBallMap[x][y].number == -1 || (startX == x && startY == y))
                    return times;

                arrayDeque.add(new Location(x, y, times, dir));
                continue;
            }

            if (pinBallMap[nx][ny].number == -1 || (startX == nx && startY == ny))
                return times;

            if(pinBallMap[nx][ny].number >= 1 && pinBallMap[nx][ny].number <= 5) {

                dir = pinBallMap[nx][ny].reflect[dir];
                times++;
            }
            else if(pinBallMap[nx][ny].number >= 6 && pinBallMap[nx][ny].number <= 10) {

                int wormHoleNumber = pinBallMap[nx][ny].number - 6;

                if(wormHoleLeft[wormHoleNumber][0] == nx && wormHoleLeft[wormHoleNumber][1] == ny) {

                    nx = wormHoleRight[wormHoleNumber][0];
                    ny = wormHoleRight[wormHoleNumber][1];
                }
                else {

                    nx = wormHoleLeft[wormHoleNumber][0];
                    ny = wormHoleLeft[wormHoleNumber][1];
                }
            }

            arrayDeque.add(new Location(nx, ny, times, dir));
        }
        return ret;
    }
}