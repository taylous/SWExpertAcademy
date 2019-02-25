import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] ingredients;

    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("4012[모의SW역량테스트]요리사\\sample_input.txt"));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());

            ingredients = new int[N][N];

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++)
                    ingredients[i][j] = Integer.parseInt(st.nextToken());
            }
            Answer = Integer.MAX_VALUE;
            cook(new boolean[N], 0, N / 2);
            System.out.println("#" + (test_case + 1) + " " + Answer);
        }
        br.close();
    }

    static void cook(boolean[] table, int idx, int remain) {

        if (idx >= N && remain != 0)
            return;

        if (remain == 0) {

            int combinationA = 0;
            int combinationB = 0;

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {

                    if (i == j)
                        continue;

                    if (table[i] && table[j])
                        combinationA += ingredients[i][j];
                    else if(!table[i] && !table[j])
                        combinationB += ingredients[i][j];
                }
            }
            Answer = Math.min(Answer, Math.abs(combinationA - combinationB));
            return;
        }

        if (!table[idx]) {

            table[idx] = true;
            cook(table, idx + 1, remain - 1);
            table[idx] = false;
        }
        cook(table,idx + 1, remain);
    }
}