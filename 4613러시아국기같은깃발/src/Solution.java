import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] flag;

    static int Answer;
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("4613러시아국기같은깃발\\sample_input.txt"));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            flag = new int[N][3];

            for (int i = 0; i < N; i++) {

                int W = 0, B = 0, R = 0;
                char[] container = br.readLine().toCharArray();

                for (int j = 0; j < M; j++) {

                    char ch = container[j];

                    if(ch == 'W')
                        W++;
                    else if(ch == 'B')
                        B++;
                    else
                        R++;
                }

                flag[i][0] = W;
                flag[i][1] = B;
                flag[i][2] = R;
            }
            Answer = Integer.MAX_VALUE;
            FlagLikeRussianFlag();

            System.out.println("#" + (test_case + 1) + " " + Answer);
        }

        br.close();
    }

    static void FlagLikeRussianFlag() {

        int W = 0, B = 0, R = 0;

        for(int white = 0; white < N - 2; white++) {

            W += flag[white][1] + flag[white][2];

            for(int blue = white + 1; blue < N - 1; blue++) {

                B += flag[blue][0] + flag[blue][2];

                for(int red = blue + 1; red < N; red++) {

                    R += flag[red][0] + flag[red][1];
                }

                Answer = Math.min(Answer, W + B + R);
                R = 0;
            }

            B = 0;
        }
    }
}