import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    static ArrayList<Integer> list = new ArrayList<>();
    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("5603건초더미\\sample_input.txt"));
        int average;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            N = Integer.parseInt(br.readLine());
            average = 0;

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(br.readLine()));
                average += list.get(i);
            }
            Collections.sort(list);
            average /= N;

            for (int i = 0; i < N; i++) {

                if(average - list.get(i) <= 0)
                    break;
                Answer += average - list.get(i);
            }
            System.out.println("#" + (test_case + 1) + " " + Answer);
            list.clear();
            Answer = 0;
        }
        br.close();
    }
}