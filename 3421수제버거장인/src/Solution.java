import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<Integer>[] list;

    static int Answer;
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("3421수제버거장인\\sample_input.txt"));
        StringTokenizer st = null;
        int p = 0;
        int q = 0;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++)
                list[i] = new ArrayList<>();

            while (M-- > 0) {

                st = new StringTokenizer(br.readLine(), " ");

                p = Integer.parseInt(st.nextToken());
                q = Integer.parseInt(st.nextToken());

                list[p].add(q);
                list[q].add(p);
            }
            Answer = 0;
            for (int i = 1; i <= N; i++) {

                Answer++;
                int check = 0;
                check |= (1 << i);

                HomemadeBurgerMaster(i, check);
            }

            System.out.println("#" + (test_case + 1) + " " + (Answer + 1));
        }

        br.close();
    }

    static void HomemadeBurgerMaster(int idx, int chk) {

        if(idx > N)
            return;

        ArrayList<Integer> tempList = list[idx];

        for(int i : tempList)
            chk |= (1 << i);

        for(int i = idx + 1; i <= N; i++)
            if((chk & (1 << i)) == 0) {

                Answer++;
                chk |= (1 << i);
                HomemadeBurgerMaster(i, chk);
                chk ^= (1 << i);
            }
    }
}