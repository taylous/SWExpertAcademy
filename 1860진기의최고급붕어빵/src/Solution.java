import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static LinkedList<Integer> qualifications = new LinkedList<>();
	
	static int Answer;
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		
		boolean flag = false;
		int time, bungEoPpangCount, criteria;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = 0;
			bungEoPpangCount = 0;
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				qualifications.add(Integer.parseInt(st.nextToken()));
			Collections.sort(qualifications);
			
			while(true) {
				
				if(qualifications.isEmpty())
					break;
				
				if(time != 0 && time % M == 0)
					bungEoPpangCount += K;
				
				if(qualifications.peek() == time) {
					
					criteria = qualifications.peek();
					
					while(true) {
						
						if(qualifications.isEmpty())
							break;
						
						if(criteria == qualifications.peek()) {
							
							if(bungEoPpangCount == 0) {
								
								flag = true;
								break;
							}
							bungEoPpangCount--;
							qualifications.remove();
						}
						else
							break;
					}
				}
				
				if(flag) {
					
					Answer = 1;
					break;
				}
				flag = false;
				time++;
			}
			System.out.println("#"+(test_case+1)+" "+(Answer == 0 ? "Possible" : "Impossible"));
			qualifications.clear();
			flag = false;
			Answer = 0;
		}
		br.close();
	}

}
