import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static char[] sStr;
    static char[] tStr;

    static int[] sCache;
    static int[] tCache;

    static long Answer;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("5949문자열변경하기\\input.txt"));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            sStr = br.readLine().toCharArray();
            tStr = br.readLine().toCharArray();

            sCache = new int[100001];
            tCache = new int[100001];

            int t_idx = 0;
            int s_idx = 0;

            for(int i = 0; i < sStr.length; ++i) {

                if(sStr[i] == tStr[i])
                    continue;

                if(sStr[i] == 'a') {

                    sCache[s_idx] = i;
                    s_idx++;
                }
                else {

                    tCache[t_idx] = i;
                    t_idx++;
                }
            }
            for(int i = 0; i < s_idx; ++i)
                Answer +=  (sCache[i] > tCache[i]) ? sCache[i] - tCache[i] : tCache[i] - sCache[i];

            System.out.println("#" + (test_case + 1) + " " + Answer);
            Answer = 0;
        }
        br.close();
    }
}