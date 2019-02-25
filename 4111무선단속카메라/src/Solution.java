import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[] sequence;
    static int[] cache;

    static int Answer;
    static int N;
    static int K;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("4111무선단속카메라\\sample_input.txt"));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());

            if(N <= K) {

                System.out.println("#" + (test_case + 1) + " 0");
                continue;
            }

            sequence = new int[N];
            cache = new int[N - 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++)
                sequence[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(sequence);

            for(int i = 0; i < cache.length; i++)
                cache[i] = sequence[i + 1] - sequence[i];
            Arrays.sort(cache);

            Answer = 0;
            for(int i = 0; i < N - K; i++)
                Answer += cache[i];

            System.out.println("#" + (test_case + 1) + " " + Answer);
        }

        br.close();
    }
}