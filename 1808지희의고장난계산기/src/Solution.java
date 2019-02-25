import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] numericButtons = new int[10];
	static int[][] cache;

	static int Answer;
	static int Result;

	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("1808지희의고장난계산기\\input.txt"));
		StringTokenizer st = null;
		int idx;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine(), " ");

			idx = 0;
			while(st.hasMoreTokens())
				numericButtons[idx++] = Integer.parseInt(st.nextToken());
			Result = Integer.parseInt(br.readLine());

			cache = new int[Result + 1][11];
			for(int[] init : cache)
				java.util.Arrays.fill(init, -1);
			Answer = JiHeesBrokenCalculator(1, 0);

			System.out.println("#"+(test_case+1) + " " + Answer + 1);
		}
		
		br.close();
	}

	static int JiHeesBrokenCalculator(int total, int idx) {

		if(idx >= 10) {

			if(total == Result)
				return 0;
			else
				return Integer.MAX_VALUE;
		}

		if(cache[total][idx] != -1)
			return cache[total][idx];

		String temp = "";
		int ret = Integer.MAX_VALUE;
		int value = 0;

		ret = JiHeesBrokenCalculator(total, idx + 1);

		while(value <= Result) {

			temp += numericButtons[idx];
			value = Integer.parseInt(temp);

			if (total * value <= Result)
				ret = Math.min(ret, JiHeesBrokenCalculator(total * numericButtons[idx], idx) + 1);
			else
				ret = Math.min(ret, JiHeesBrokenCalculator(total, idx + 1));
		}
		return cache[total][idx] = ret;
	}
}