import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] segmentArr;
	static int[] sequence;
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		StringTokenizer st;
		
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sequence = new int[N];
			init();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				sequence[i] = Integer.parseInt(st.nextToken());
			segmentTree(0, N - 1, 1);

			sb.append("#");
			sb.append(test_case + 1);
			sb.append(" ");
			while(M-- > 0) {
				
				st = new StringTokenizer(br.readLine());
				
				if(Integer.parseInt(st.nextToken()) == 1) {
					
					int idx = Integer.parseInt(st.nextToken()) - 1;
					int var = Integer.parseInt(st.nextToken());
					
					sequence[idx] += var;
					update(0, N - 1, 1, idx, var);
				}
				else {
					
					int a = Integer.parseInt(st.nextToken()) - 1;
					int b = Integer.parseInt(st.nextToken()) - 1;
					
					sb.append(travel(a, b, 0, N - 1, 1));
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static void init() {
		
        int x = (int) Math.ceil(Math.log(N) / Math.log(2));
        int segmentSize = (int) Math.pow(2, x) * 2 - 1;

        segmentArr = new int[segmentSize];
	}
	
	static int segmentTree(int low, int high, int node) {
		
		if(low == high)
			return segmentArr[node] = sequence[low];
		
		int mid = (low + high) / 2;
		
		segmentArr[node] += segmentTree(low, mid, node * 2);
		segmentArr[node] += segmentTree(mid + 1, high, (node * 2) + 1);
		
		return segmentArr[node];
	}
	
	static void update(int low, int high, int node, int index, int diff) {
		
		if(index < low || index > high)
			return;
		
		segmentArr[node] = segmentArr[node] + diff;
		
		if(low != high) {
			
			update(low, (low + high) / 2, node * 2, index, diff);
			update(((low + high) / 2) + 1, high, (node * 2) + 1, index, diff);			
		}
	}
	
	static int travel(int a, int b, int low, int high, int node) {

        if(a > high || b < low)
            return 0;

        if (a <= low && high <= b)
            return segmentArr[node];

        int mid = (low + high) / 2;
        return travel(a, b, low, mid, node * 2) + travel(a, b, mid + 1, high, (node * 2) + 1);
    }
}
