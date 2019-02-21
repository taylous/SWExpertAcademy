import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] sequence;
	
	static int Answer;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sequence = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(st.nextToken());	
		System.out.println(BubbleSorting());
		br.close();
	}
	
	static int BubbleSorting() {
		
		int size = N;
		int temp;
		
		for(int times = size - 1; times > 0; times--) {
			
			for(int i = 0; i < times; i++) {
				
				if(sequence[i] > sequence[i + 1]) {
					
					temp = sequence[i];
					sequence[i] = sequence[i + 1];
					sequence[i + 1] = temp;
				}
			}
		}
		return sequence[N / 2];
	}
}
