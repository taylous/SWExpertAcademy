import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] Tile;
    static boolean[][] check;

    static int Answer;
    static int N;
    static String Direction;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("6109추억의2048게임\\input.txt"));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            Direction = st.nextToken();

            Tile = new int[N][N];
            check = new boolean[N][N];

            for(int i = 0; i < N; ++i) {

                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; ++j)
                    Tile[i][j] = Integer.parseInt(st.nextToken());
            }

            if (Direction.equals("up")) {

                for(int i = 0; i < N; ++i)
                    Row_based_inspection(i, true);

            } else if (Direction.equals("down")) {

                for(int i = 0; i < N; ++i)
                    Row_based_inspection(i, false);

            } else if (Direction.equals("right")) {

                for(int i = 0; i < N; ++i)
                    Column_based_inspection(i, false);
            } else {

                for(int i = 0; i < N; ++i)
                    Column_based_inspection(i, true);
            }

            System.out.println("#" + (test_case + 1));
            for(int i = 0; i < N; ++i) {

                for(int j = 0; j < N; ++j)
                    System.out.print(Tile[i][j] + " ");
                System.out.println();
            }
        }
        br.close();
    }

    static void Row_based_inspection(int col, boolean operator) {

        int variable = operator ? 0 : N - 1;

        if(operator) {

            while(true) {

                if(variable == N)
                    break;

                if(Tile[variable][col] == 0 || variable - 1 < 0) {

                    variable++;
                    continue;
                }

                if(Tile[variable - 1][col] == 0) {

                    Tile[variable - 1][col] = Tile[variable][col];
                    Tile[variable][col] = 0;
                    variable--;
                }
                else {

                    if(Tile[variable - 1][col] == Tile[variable][col] && !check[variable - 1][col]) {

                        Tile[variable - 1][col] *= 2;
                        Tile[variable][col] = 0;
                        check[variable - 1][col] = true;
                    }
                    else {

                        variable++;
                    }
                }
            }
        }
        else {

            while(true) {

                if(variable < 0)
                    break;

                if(Tile[variable][col] == 0 || variable + 1 == N) {

                    variable--;
                    continue;
                }

                if(Tile[variable + 1][col] == 0) {

                    Tile[variable + 1][col] = Tile[variable][col];
                    Tile[variable][col] = 0;
                    variable++;
                }
                else {

                    if(Tile[variable + 1][col] == Tile[variable][col] && !check[variable + 1][col]) {

                        Tile[variable + 1][col] *= 2;
                        Tile[variable][col] = 0;
                        check[variable + 1][col] = true;
                    }
                    else {

                        variable--;
                    }
                }
            }
        }
    }

    static void Column_based_inspection(int row, boolean operator) {

        int variable = operator ? 0 : N - 1;

        if(operator) {

            while(true) {

                if(variable == N)
                    break;

                if(Tile[row][variable] == 0 || variable - 1 < 0) {

                    variable++;
                    continue;
                }

                if(Tile[row][variable - 1] == 0) {

                    Tile[row][variable - 1] = Tile[row][variable];
                    Tile[row][variable] = 0;
                    variable--;
                }
                else {

                    if(Tile[row][variable - 1] == Tile[row][variable] && !check[row][variable - 1]) {

                        Tile[row][variable - 1] *= 2;
                        Tile[row][variable] = 0;
                        check[row][variable - 1] = true;
                    }
                    else {

                        variable++;
                    }
                }
            }
        }
        else {

            while(true) {

                if(variable < 0)
                    break;

                if(Tile[row][variable] == 0 || variable + 1 == N) {

                    variable--;
                    continue;
                }

                if(Tile[row][variable + 1] == 0) {

                    Tile[row][variable + 1] = Tile[row][variable];
                    Tile[row][variable] = 0;
                    variable++;
                }
                else {

                    if(Tile[row][variable + 1] == Tile[row][variable] && !check[row][variable + 1]) {

                        Tile[row][variable + 1] *= 2;
                        Tile[row][variable] = 0;
                        check[row][variable + 1] = true;
                    }
                    else {

                        variable--;
                    }
                }
            }
        }
    }
}