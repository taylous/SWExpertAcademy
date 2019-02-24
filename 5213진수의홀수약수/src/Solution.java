import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] oddSum;

	static int Answer;
	static int L;
	static int R;

	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("5213진수의홀수약수\\sample_input.txt"));

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

            L = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());

            for(int start = L; start <= R; start++)
                Answer += oddSum[start];

			System.out.println("#"+(test_case+1) + " " + Answer);
			Answer = 0;
		}
		
		br.close();
	}
}