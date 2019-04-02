import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static boolean[][] nation;
	static ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>(); 
	static int[] colorOrigin;

	static int Answer;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sampleinput.txt"));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());

			nation = new boolean[N][N];
			colorOrigin = new int[N];

			for(int i = 0; i < N; i++)
				adjacent.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				colorOrigin[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++)
					nation[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
			Answer = Integer.MAX_VALUE;
			for (int here = 0; here < N; here++) {
				
				for (int there = 0; there < N; there++) {

					if (nation[here][there])
						adjacent.get(here).add(there);
				}
			}			
			for(int here = 0; here < N; here++)
				coloringTheMap(new boolean[N], new int[N], here, 0);
			System.out.println("#" + (test_case + 1) + " " + (Answer == Integer.MAX_VALUE ? 0 : Answer));
			adjacent.clear();
		}
		br.close();
	}

	static boolean check(boolean[] visited) {

		for (int i = 0; i < N; i++) {

			if (!visited[i])
				return false;
		}
		return true;
	}

	static void coloringTheMap(boolean[] visited, int[] color, int here, int times) {

		visited[here] = true;
		if(check(visited)) {
			
			Answer = Math.min(Answer, times);
			return;
		}
		boolean[] available = new boolean[N + 1];
		int[] copyColor = new int[N];
		
		for(int there : adjacent.get(here))
			available[color[there]] = true;
		System.arraycopy(color, 0, copyColor, 0, N);
			
		for(int there : adjacent.get(here)) {
			
			if(!visited[there]) {
				
				for(int i = 1; i <= N; i++) {
					
					if(!available[i]) {
						
						copyColor[here] = i;
						coloringTheMap(visited, color, there, times + (colorOrigin[here] != there ? 1 : 0));
						
						copyColor[here] = 0;
						visited[there] = false;
					}
				}
			}
		}
	}
}
