import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean[] visited;
    static int[] score;

    static int Answer;
    static int N;
    static int MaxSize;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("3752가능한시험점수\\sample_input.txt"));
        StringTokenizer stringTokenizer = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());
            score = new int[N];

            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(stringTokenizer.nextToken());
                MaxSize += score[i];
            }
            visited = new boolean[MaxSize + 1];
            visited[0] = true;

            for(int index = 0; index < N; index++) {

                for(int i = MaxSize - 1; i >= 0; i--) {

                    if(visited[i])
                        visited[i + score[index]] = true;
                }
            }

            for(int i = 0; i <= MaxSize; i++)
                if(visited[i])
                    Answer++;

            System.out.println("#" + (test_case + 1) + " " + Answer);
            Answer = MaxSize = 0;
        }

        br.close();
    }
}