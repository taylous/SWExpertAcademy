import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] cost;
    static long[][] cache;

	static int Answer;
	static int N;
	static int K;

	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("4699콩순이의가장싼팰린드롬\\sample_input.txt"));
        StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {

		    st = new StringTokenizer(br.readLine(), " ");

		    N = Integer.parseInt(st.nextToken());
		    K = Integer.parseInt(st.nextToken());
		    Answer = Integer.MAX_VALUE;

		    StringBuilder stringBuilder = new StringBuilder(br.readLine());
		    cost = new int[K][2];
		    cache = new long[N + 1][N + 1];
		    for(int i = 0; i < N; i++)
		        java.util.Arrays.fill(cache[i], - 1);

		    for(int i = 0; i < K; i++) {

		        st = new StringTokenizer(br.readLine(), " ");

		        cost[i][0] = Integer.parseInt(st.nextToken());
		        cost[i][1] = Integer.parseInt(st.nextToken());
            }
            KongSuniuiTheCheapestPalindream(stringBuilder, 0);

			System.out.println("#"+test_case+" "+Answer);
		}
		
		br.close();
	}

	static void KongSuniuiTheCheapestPalindream(StringBuilder stringBuilder, int total) {

	    if(total > Answer)
	        return;

        //System.out.println("str : " + stringBuilder.toString());
	    boolean chk = false;
	    int start = 0;
	    int end = stringBuilder.length() - 1;

	    while(true) {

	        if(start == end || start > end) {

	            chk = true;
	            break;
            }

	        if(stringBuilder.charAt(start) == stringBuilder.charAt(end)) {

	            start++;
	            end--;
            }
            else {

                char ch;

                //System.out.println("0 : " + stringBuilder.toString());
                //
                ch = stringBuilder.charAt(start);

                stringBuilder.insert(end + 1, ch);
                //System.out.println("1 " + stringBuilder.toString());
                KongSuniuiTheCheapestPalindream(stringBuilder, total + cost[ch - 97][0]);
                stringBuilder.deleteCharAt(end + 1);
                //System.out.println("1 " + stringBuilder.toString());
                //
                stringBuilder.deleteCharAt(start);
                //System.out.println("2 " + stringBuilder.toString());
                KongSuniuiTheCheapestPalindream(stringBuilder, total + cost[ch - 97][0]);
                stringBuilder.insert(start, ch);
                //System.out.println("2 " + stringBuilder.toString());
                //
                ch = stringBuilder.charAt(end);

                stringBuilder.insert(start, ch);
                //System.out.println("3 " + stringBuilder.toString());
                KongSuniuiTheCheapestPalindream(stringBuilder, total + cost[ch - 97][0]);
                stringBuilder.deleteCharAt(start);
                //System.out.println("3 " + stringBuilder.toString());
                //
                stringBuilder.deleteCharAt(end);
                //System.out.println("4 " + stringBuilder.toString());
                KongSuniuiTheCheapestPalindream(stringBuilder, total + cost[ch - 97][1]);
                stringBuilder.insert(end, ch);
                //System.out.println("4 " + stringBuilder.toString());

                break;
            }
        }

        if(chk) {

            //System.out.println(total);
            Answer = Math.min(total, Answer);
        }
    }
}