import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] reverveList;
    static Stack<Integer> stack = new Stack<>();

    static boolean[] visited;
    static boolean[] reverseVisited;

    static int Answer;
    static int V;
    static int E;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("3269강한연결 요소\\sample_input.txt"));
        StringTokenizer st = null;
        String t = null;
        int vertex = 0;


        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            System.out.print("#" + (test_case + 1) + " ");

            st = new StringTokenizer(br.readLine(), " ");

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            init();


            for(int i = 0; i < E; i++) {

                st = new StringTokenizer(br.readLine(), " ");

                int p = Integer.parseInt(st.nextToken()) - 1;
                int q = Integer.parseInt(st.nextToken()) - 1;

                list[p].add(q);
                reverveList[q].add(p);
            }

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    DFS(i);

            while (!stack.isEmpty()) {

                vertex = stack.pop();
                System.out.println(vertex);

                if (!reverseVisited[vertex]) {
                    SSC(vertex);
                    Answer++;
                }
            }

            System.out.println(Answer);
        }

        br.close();
    }

    static void init() {

        Answer = 0;

        visited = new boolean[V + 1];
        reverseVisited = new boolean[V + 1];

        list = new ArrayList[V + 1];
        reverveList = new ArrayList[V + 1];

        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
            reverveList[i] = new ArrayList<>();
        }

        java.util.Arrays.fill(visited, false);
        java.util.Arrays.fill(reverseVisited, false);
    }

    static void SSC(int here) {

        reverseVisited[here] = true;

        for (int there = 0; there < reverveList[here].size(); there++)
            if (!reverseVisited[reverveList[here].get(there)])
                SSC(reverveList[here].get(there));
    }

    static void DFS(int here) {

        visited[here] = true;

        for (int there = 0; there < list[here].size(); there++)
            if (!visited[list[here].get(there)])
                DFS(list[here].get(there));

        stack.push(here);
    }
}