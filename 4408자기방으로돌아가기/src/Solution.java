import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Room implements Comparable<Room> {

    int start;
    int end;

    Room(int start, int end) {

        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room other) {

        if (this.start < other.start)
            return -1;
        else if (this.start == other.start) {

            if (this.end < other.end)
                return -1;
            else if (this.end == other.end)
                return 0;
        }
        return 1;
    }
}

public class Solution {

    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Room[] rooms = null;
        boolean[] visited = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());
            rooms = new Room[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine(), " ");

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if (start > end) {

                    int t = start;
                    start = end;
                    end = t;
                }

                rooms[i] = new Room(start, end);
            }

            Arrays.sort(rooms);
            for (int i = 0; i < N; i++) {

                int offset = rooms[i].end;

                if (!visited[i]) {

                    Answer++;
                    visited[i] = true;

                    for (int j = i + 1; j < N; j++) {

                        if (!visited[j] && rooms[j].start > offset) {

                            visited[j] = true;
                            offset = rooms[j].end;
                        }
                    }
                }
            }

            System.out.println("#" + (test_case + 1) + " " + Answer);
            Answer = 0;
        }

        br.close();
    }
}