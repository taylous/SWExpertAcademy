import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {

    static HashSet<String> hashSet = new HashSet<>();

    static String Answer;
    static char[] chars;
	static int K;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("1257[SW문제해결응용]6일차_K번째문자열\\input.txt"));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {

		    K = Integer.parseInt(br.readLine());
            chars = br.readLine().toCharArray();

            for(int i = 0; i < chars.length; i++)
                KthString(i);
            LinkedList<String> sortHash = new LinkedList<>(hashSet);
            Collections.sort(sortHash);

            while(K-- > 0)
                Answer = sortHash.remove();
			System.out.println("#"+test_case+" "+Answer);
			hashSet.clear();
		}
		
		br.close();
	}

	static void KthString(int idx) {

	    StringBuffer sb = new StringBuffer();

	    for(int i = idx; i < chars.length; i++) {

	        sb.append(chars[i]);
	        hashSet.add(sb.toString());
        }
    }
}