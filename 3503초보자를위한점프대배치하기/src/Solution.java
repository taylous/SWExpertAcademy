import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int[] sequence;

    static int Answer;
    static int N;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("3503초보자를위한점프대배치하기\\sample_input.txt"));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            System.out.print("#" + (test_case + 1) + " ");

            N = Integer.parseInt(br.readLine());

            sequence = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < N; i++)
                pq.offer(Integer.parseInt(st.nextToken()));

            InstallingAJumpstartForBeginners();
            System.out.println(Answer);

            pq.clear();
        }

        br.close();
    }

    static void InstallingAJumpstartForBeginners() {

        int idx = 3;
        int end = N - 1;

        sequence[1] = pq.poll();
        sequence[2] = pq.poll();
        sequence[N] = pq.poll();

        Answer = Math.max(Math.abs(sequence[1] - sequence[2]), Math.abs(sequence[1] - sequence[N]));
        System.out.println("현재 : " + Answer);
        while (!pq.isEmpty()) {

            sequence[idx++] = pq.poll();

            if (pq.isEmpty())
                break;

            sequence[end--] = pq.poll();
        }

        for (int i = 3; i <= N - 1; i++) {
            Answer = Math.max(Answer, Math.abs(sequence[i] - sequence[i + 1]));
            Answer = Math.max(Answer, Math.abs(sequence[i] - sequence[i - 1]));
        }
    }
}