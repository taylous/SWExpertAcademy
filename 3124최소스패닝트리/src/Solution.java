import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Location implements Comparable<Location> {

	int startVertex;
	int endVertex;
	int weight;

	Location(int startVertex, int endVertex, int weight) {

		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Location other) {
		return this.weight > other.weight ? 1 : -1;
	}
}

public class Solution {

	static PriorityQueue<Location> pq = new PriorityQueue<>();
	static int[] visited;
	static int[] parents;

	static long Answer;
	static int N;
	static int E;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("3124최소스패닝트리\\sample_input.txt"));
		StringTokenizer st = null;
		Location tmp = null;

		int p = 0;
		int q = 0;
		int c = 0;

		int pP = 0;
		int qP = 0;


		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			parents = new int[N + 1];
			for(int i = 0; i <= N; i++)
				parents[i] = i;

			for(int i = 0; i < E; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				p = Integer.parseInt(st.nextToken());
				q = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				pq.offer(new Location(p, q, c));
			}

			while(!pq.isEmpty()) {

				tmp = pq.poll();

				p = tmp.startVertex;
				q = tmp.endVertex;

				pP = getRoot(p);
				qP = getRoot(q);

				if(pP == qP)
					continue;

				union(p, q);

				Answer += tmp.weight;
			}

			System.out.println("#"+(test_case+1) + " " + Answer);

			pq.clear();
			Answer = 0;
		}
		
		br.close();
	}

	static int getRoot(int p) {

		if(p == parents[p])
			return p;

		return parents[p] = getRoot(parents[p]);
	}

	static void union(int p, int q) {

		int pP = getRoot(p);
		int pQ = getRoot(q);

		if(pP != pQ)
			parents[pP] = pQ;
	}
}