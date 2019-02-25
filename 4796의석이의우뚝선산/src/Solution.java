import java.util.Scanner;

public class Solution {

    static int[] mountain;

    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {

            N = sc.nextInt();
            mountain = new int[N];

            for (int i = 0; i < N; i++)
                mountain[i] = sc.nextInt();

            int uphill = 0;
            int downhill = 0;

            for (int i = 1; i < N; i++) {

                if (mountain[i - 1] < mountain[i]) {

                    if (uphill == 0 && downhill > 0) {
                        downhill = 0;
                    } else if (uphill > 0 && downhill > 0) {
                        Answer += uphill * downhill;
                        uphill = downhill = 0;
                    }
                }

                if (mountain[i - 1] < mountain[i])
                    uphill++;
                else if (mountain[i - 1] > mountain[i])
                    downhill++;


            }

            if(uphill > 0 && downhill > 0)
                Answer += uphill * downhill;
            System.out.println("#" + test_case + " " + Answer);
            Answer = 0;
        }

        sc.close();
    }
}