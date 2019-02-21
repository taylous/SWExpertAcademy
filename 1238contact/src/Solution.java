import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Contactor {
	
	int number;
	int count;
	
	Contactor(int number, int count) {
		
		this.number = number;
		this.count = count;
	}
}

public class Solution {

	static boolean[][] contactNetwork;
	
	static int answerCount;
	static int answerNumber;
	
	static int N;
	static int maxVertex;
	static int start;
	
	public static void main(String[] args) throws Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		int from, to;
		
		for(int test_case = 0; test_case < 10; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			contactNetwork = new boolean[101][101];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N / 2; i++) {
				
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				maxVertex = Math.max(maxVertex, from);
				maxVertex = Math.max(maxVertex, to);
				
				contactNetwork[from][to] = true;
			}
			contact();
			
			System.out.println("#"+(test_case+1)+" "+answerNumber);
			answerCount = answerNumber = maxVertex = 0;
		}
		br.close();
	}

	static void contact() {
		
		ArrayDeque<Contactor> arrayDeque = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		
		arrayDeque.add(new Contactor(start, 0));
		visited[start] = true;
		
		while(!arrayDeque.isEmpty()) {
			
			int size = arrayDeque.size();
			
			for(int i = 0; i < size; i++) {
				
				
			}
		}
	}
}
