import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Location implements Comparable<Location> {

    int x;
    int y;
    int count;

    Location(int x, int y, int count) {

        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(Location other) {
        return this.count > other.count ? -1 : 1;
    }
}

public class Solution {

    static ArrayDeque<Location> adeque = new ArrayDeque<>();

    static int[][] room;
    static int[] loX = {-1, 0, 1, 0};
    static int[] loY = {0, 1, 0, -1};

    static int Key;
    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("1861정사각형방\\input.txt"));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());
            room = new int[N + 1][N + 1];

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; j++) {

                    room[i][j] = Integer.parseInt(st.nextToken());
                    adeque.add(new Location(i, j, 0));
                }
            }
            Key = Integer.MAX_VALUE;
            SquareRoom();

            System.out.println("#" + (test_case + 1) + " " + Key + " " + Answer);
            Answer = 0;
            adeque.clear();
        }

        br.close();
    }

    static void SquareRoom() {

        PriorityQueue<Location> list = new PriorityQueue<>(Collections.reverseOrder());
        Location t = null;

        boolean[][] visited = new boolean[N + 1][N + 1];
        int keyValue = 0;
        int count = 0;
        int x, y, nx, ny;


        while (!adeque.isEmpty()) {

            t = adeque.remove();
            x = t.x;
            y = t.y;

            list.offer(new Location(x, y, 1));

            while (!list.isEmpty()) {

                t = list.remove();
                x = t.x;
                y = t.y;
                keyValue = room[x][y];
                count = t.count;

                if (Answer < count) {

                    Key = keyValue;
                    Answer = count;
                } else if (Answer == count)
                    Key = Math.min(Key, keyValue);

                if (visited[x][y])
                    continue;
                visited[x][y] = true;
                count += 1;

                for (int i = 0; i < 4; i++) {

                    nx = x + loX[i];
                    ny = y + loY[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                        continue;
                    if (keyValue - room[nx][ny] != 1)
                        continue;

                    list.offer(new Location(nx, ny, count));
                }
            }

            for (boolean[] init : visited)
                java.util.Arrays.fill(init, false);
            list.clear();
        }
    }
}