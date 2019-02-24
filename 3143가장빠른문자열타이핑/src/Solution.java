import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static String original;
	static String partial;

	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("3143가장빠른문자열타이핑\\sample_input.txt"));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());

			original = st.nextToken();
			partial = st.nextToken();

			System.out.println("#"+(test_case+1) + " " + FastestStringTyping());
		}
		
		br.close();
	}

	static int FastestStringTyping() {

		int ret = 0;

		for(int i = 0; i < original.length(); i++) {

			if(original.charAt(i) == partial.charAt(0)) {
				if(original.length() >= partial.length() + i && original.substring(i, i + partial.length()).equals(partial))
					i += partial.length() - 1;
			}
			ret++;
		}

		return ret;
	}
}