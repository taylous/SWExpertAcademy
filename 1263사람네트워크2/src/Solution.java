import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex> {
	
	int from;
	int weight;
	
	public Vertex(int from, int weight) {
		
		this.from = from;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Vertex other) {
		
		return this.weight < other.weight ? -1 : 1;
	}
}

public class Solution {

	static int[][] adjacent;
	static int Answer;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			Answer = Integer.MAX_VALUE;
			
			adjacent = new int[N][N];
			for(int i = 0; i < N; i++) {
			
				for(int j = 0; j < N; j++)
					adjacent[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int start = 0; start < N; start++)
				Answer = Math.min(Answer, peopleNetwork2(start));
			System.out.println("#"+(test_case+1)+" "+Answer);
		}
		br.close();
	}

	static int peopleNetwork2(int start) {
		
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();		
		int[] dist = new int[N];
		
		Vertex vertex;
		int from, weight;
		int ret = 0;
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		priorityQueue.offer(new Vertex(start, 0));
		dist[start] = 0;
		
		while(!priorityQueue.isEmpty()) {
			
			vertex = priorityQueue.poll();
			from = vertex.from;
			weight = vertex.weight;
			
			if(weight > dist[from])
				continue;
			
			for(int to = 0; to < N; to++) {
				
				if(adjacent[from][to] == 1 && dist[to] > dist[from] + adjacent[from][to]) {
					
					dist[to] = dist[from] + adjacent[from][to];
					priorityQueue.offer(new Vertex(to, weight + 1));
				}
			}
		}
		for(int var : dist) {
			
			if(ret > Answer) {
			
				ret = Integer.MAX_VALUE;
				break;
			}
			ret += var;
		}
		return ret;
	}
}