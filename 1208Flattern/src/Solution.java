import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static int dump;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] container;
		
		int data;
		int min;
		int max;
		
		for(int test_case = 0; test_case < 10; test_case++) {
			
			dump = Integer.parseInt(br.readLine());
			
			container = br.readLine().split(" ");
			for(String var : container) {
				
				data = Integer.parseInt(var);
				
				maxHeap.offer(data);
				minHeap.offer(data);
			}
			
			while(dump-- > 0) {
				
				max = maxHeap.poll() - 1;
				min = minHeap.poll() + 1;
				
				maxHeap.offer(max);
				minHeap.offer(min);
			}
			System.out.println("#"+(test_case+1)+" "+(maxHeap.poll() - minHeap.poll()));
			maxHeap.clear();
			minHeap.clear();
		}
		br.close();
	}

}
