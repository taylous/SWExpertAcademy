import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static String source;
	static int N;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("1234비밀번호\\input.txt"));
        StringTokenizer st;
        StringBuffer sb;
        int idx;

		for(int test_case = 0; test_case < 10; test_case++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            source = st.nextToken();
            sb = new StringBuffer(source);
            idx = 0;

            while (true) {

                if (idx >= sb.length() - 1)
                    break;

                if (sb.charAt(idx) == sb.charAt(idx + 1)) {

                    sb.deleteCharAt(idx);
                    sb.deleteCharAt(idx);

                    if (idx - 1 >= 0)
                        idx--;
                } else
                    idx++;
            }
            System.out.println("#" + (test_case + 1) + " " + sb.toString());
        }
		br.close();
	}
}