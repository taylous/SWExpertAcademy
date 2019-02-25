import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    static int[] R = new int[10];
    static int[] G = new int[10];
    static int[] B = new int[10];

    static int Answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] color, number;
        int r, g, b;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            number = br.readLine().toCharArray();
            color = br.readLine().toCharArray();
            r = g = b = 0;

            for(int i = 0; i < 9; i++) {

                if(color[i] == 'R') {

                    R[number[i] - '0']++;
                    r++;
                }
                else if(color[i] == 'G') {

                    G[number[i] - '0']++;
                    g++;
                }
                else {

                    B[number[i] - '0']++;
                    b++;
                }
            }

            if((r % 3 == 0 || r == 0) && (g % 3 == 0 || g == 0) && (b % 3 == 0 || b == 0)) {

                for(int i = 0; i < 10; i++) {

                    if(G[i] >= 3) {

                        Answer++;
                        G[i] -= 3;
                    }
                    else if(i < 8) {

                        if(G[i] >= 1 && G[i + 1] >= 1 && G[i + 2] >= 1) {

                            G[i] -= 1;
                            G[i + 1] -= 1;
                            G[i + 2] -= 1;
                            Answer++;
                            i--;
                        }
                    }
                }

                for(int i = 0; i < 10; i++) {

                    if(R[i] >= 3) {

                        Answer++;
                        R[i] -= 3;
                    }
                    else if(i < 8) {

                        if(R[i] >= 1 && R[i + 1] >= 1 && R[i + 2] >= 1) {

                            R[i] -= 1;
                            R[i + 1] -= 1;
                            R[i + 2] -= 1;
                            Answer++;
                            i--;
                        }
                    }
                }

                for(int i = 0; i < 10; i++) {

                    if(B[i] >= 3) {

                        Answer++;
                        B[i] -= 3;
                    }
                    else if(i < 8) {

                        if(B[i] >= 1 && B[i + 1] >= 1 && B[i + 2] >= 1) {

                            B[i] -= 1;
                            B[i + 1] -= 1;
                            B[i + 2] -= 1;
                            Answer++;
                            i--;
                        }
                    }
                }
            }
            System.out.println("#"+(test_case+1)+" "+(Answer == 3 ? "Win" : "Continue"));
            Answer = 0;

            Arrays.fill(R, 0);
            Arrays.fill(G, 0);
            Arrays.fill(B, 0);
        }
        br.close();
    }
}