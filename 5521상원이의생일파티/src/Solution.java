import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static ArrayDeque<Integer> friends = new ArrayDeque<>();

    static boolean[][] Relationship;
    static boolean[] visited;

	static int Answer;
	static int N;
	static int M;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("5521상원이의생일파티\\sample_input.txt"));
        StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    st = new StringTokenizer(br.readLine());

		    N = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(st.nextToken());

		    Relationship = new boolean[N + 1][N + 1];
		    visited = new boolean[N + 1];

		    while(M-- > 0) {

		        st = new StringTokenizer(br.readLine());

		        int to = Integer.parseInt(st.nextToken());
		        int from = Integer.parseInt(st.nextToken());

		        Relationship[to][from] = true;
		        Relationship[from][to] = true;
            }

		    for(int i = 2; i <= N; ++i)
		        if(Relationship[1][i])
		            friends.add(i);
		    visited[1] = true;

		    while(!friends.isEmpty())
		        BirthdayParty(friends.remove());

			System.out.println("#"+(test_case+1) + " " + Answer);
            friends.clear();
            Answer = 0;
		}
		br.close();
	}

	static void BirthdayParty(int start) {

	    if(!visited[start])
            Answer++;
	    visited[start] = true;

	    for(int i = 1; i <= N; ++i) {

	        if(Relationship[start][i] && !visited[i]) {

	            visited[i] = true;
	            Answer++;
            }
        }
    }
}