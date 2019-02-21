import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island implements Comparable<Island> {

	int number;
	int x;
	int y;
	double weight;

	Island(int number, int x, int y, double weight) {

		this.number = number;
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public int compareTo(Island other) {

		return this.weight < other.weight ? -1 : 1;
	}
}

public class Solution {

	static PriorityQueue<Island> priorityQueue = new PriorityQueue<>();
	static ArrayList<Island> islands = new ArrayList<>();
	static boolean[] visited;

	static double environmentalRate;
	static double Answer;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st, st2;
		int start, end;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {

				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st2.nextToken());

				islands.add(new Island(i, start, end, 0));
			}
			environmentalRate = Double.parseDouble(br.readLine());
			
			for (int i = 1; i < N; i++) {
				
				double result = Math.pow(islands.get(0).x - islands.get(i).x, 2) + Math.pow(islands.get(0).y - islands.get(i).y, 2);
				priorityQueue.offer(new Island(i, -1, -1, result * environmentalRate));
			}
			hanaro();
			System.out.println("#" + (test_case + 1) + " " + (long)Math.round(Answer));
			
			Answer = 0;
			islands.clear();
			priorityQueue.clear();
		}
		br.close();
	}

	static void hanaro() {

		boolean[] visited = new boolean[N];
		
		Island island;
		int number;
		double weight;
		int count = 0;
		
		visited[0] = true;

		while (!priorityQueue.isEmpty()) {

			island = priorityQueue.poll();
			number = island.number;
			weight = island.weight;
			
			if(count == N - 1)
				break;
			if(visited[number])
				continue;
			visited[number] = true;
			Answer += weight;
			count++;
			
			for(int i = 1; i < N; i++) {
				
				if(!visited[i])
					priorityQueue.offer(new Island(i, -1, -1,
							(Math.pow(islands.get(number).x - islands.get(i).x, 2) + Math.pow(islands.get(number).y - islands.get(i).y, 2)) * environmentalRate));
			}
		}
	}
}
