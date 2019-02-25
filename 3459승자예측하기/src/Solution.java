import java.io.BufferedReader;
import java.io.FileReader;

public class Solution {

    public static void main(String args[]) throws Exception {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("3459승자예측하기\\sample_input.txt"));
        boolean isWinner = false;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            long N = Long.parseLong(br.readLine());

            if(N <= 3) {

                if(N == 1)
                    isWinner = false;
                else
                    isWinner = true;
            }
            else {

                long offset = 1;
                isWinner = true;

                while(N > 0) {

                    N -= offset;
                    offset *= isWinner ? 4 : 1;
                    isWinner = !isWinner;
                }

            }

            System.out.println("#"+test_case+" "+ (isWinner ? "Alice" : "Bob"));
        }

        br.close();
    }
}