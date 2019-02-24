import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] wordList;

    static int alphabet;
    static int Answer;
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String word;
        int size, var, temp;

        int T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            wordList = new int[N];
            for (int i = 0; i < N; i++) {

                word = br.readLine().trim();
                size = word.length();
                var = 0;

                for (int j = 0; j < size; j++) {

                    temp = word.charAt(j) - 'a';

                    var |= (1 << temp);
                    alphabet |= (1 << temp);
                }
                wordList[i] = var;
            }
            temp = Integer.bitCount(alphabet);
            if (M > temp)
                globalWarming(0, 0, temp);
            else
                globalWarming(0, 0, M);
            System.out.println("#" + (test_case + 1) + " " + Answer);

            alphabet = 0;
            Answer = 0;
        }
        br.close();
    }

    static int checkingWord(int mask) {

        int ret = 0;

        for (int i = 0; i < N; i++) {

            if ((mask & wordList[i]) == wordList[i])
                ret++;
        }
        return ret;
    }

    static void globalWarming(int mask, int idx, int times) {

        if(26 - idx < times)
            return;
        if (idx == 26 && times != 0)
            return;

        if (times == 0) {

            Answer = Math.max(Answer, checkingWord(mask));
            return;
        }
        if ((alphabet & (1 << idx)) != 0) {

            int copyMask = mask;
            globalWarming(copyMask |= (1 << idx), idx + 1, times - 1);
        }
        globalWarming(mask, idx + 1, times);
    }
}