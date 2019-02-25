import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] sequence;
	static int N;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("5642합\\sample_input.txt"));
        StringTokenizer st;
        int sum, answer;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    N = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine());

		    sequence = new int[N];

		    for(int i = 0; i < N; i++)
                sequence[i] = Integer.parseInt(st.nextToken());

            sum = 0;
            answer = -9999;
		    for(int i = 1; i < N; i++) {

                sum += sequence[i];

		        if(sum > answer)
                    answer = sum;
		        if(sum < 0)
                    sum = 0;
            }
            System.out.println("#"+(test_case+1) + " " + answer);
		}
		br.close();
	}
}