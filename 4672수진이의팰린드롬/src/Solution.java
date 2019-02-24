import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    static int Answer;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("4672수진이의팰린드롬\\sample_input.txt"));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);

            for (int offset = 0; offset < word.length; offset++) {
                for (int start = 0; start < word.length - offset; start++) {

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int end = start; end <= offset + start; end++)
                        stringBuilder.append(word[end]);

                    if (stringBuilder.length() == 1)
                        Answer++;
                    else
                        Answer += isPalindrome(stringBuilder.toString()) ? 1 : 0;
                }
            }

            System.out.println("#"+(test_case + 1)+" "+Answer);
            Answer = 0;
        }
        br.close();
    }

    static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (true) {

            if (start == end || start > end)
                break;

            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}