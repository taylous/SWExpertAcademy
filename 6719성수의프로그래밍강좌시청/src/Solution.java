import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static PriorityQueue<Integer> Lectures = new PriorityQueue<>();

	static double Answer;
	static int N;
	static int K;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("6719성수의프로그래밍강좌시청\\sample_input.txt"));
        StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                Lectures.offer(Integer.parseInt(st.nextToken()));
            while (Lectures.size() != K)
                Lectures.poll();

            while (K-- > 0)
                Answer = (Lectures.poll() + Answer) / 2;

            System.out.println("#" + (test_case+1) + " " + Answer);
            Lectures.clear();
            Answer = 0;
        }
		br.close();
	}
}