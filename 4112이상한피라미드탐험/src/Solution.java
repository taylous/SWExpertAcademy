import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] level = new int[10154];

	static int Answer;
	static int A;
	static int B;

	public static void main(String args[]) throws Exception	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("4112이상한피라미드탐험\\sample_input.txt"));
		StringTokenizer st = null;
		init();

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			System.out.print("#"+(test_case+1) + " ");

			st = new StringTokenizer(br.readLine(), " ");

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			if(A < B) {

			    int t = A;
			    A = B;
			    B = t;
            }
			Answer = ExploreTheStrangePyramids();
			System.out.println(Answer);
		}

		br.close();
	}

	static int ExploreTheStrangePyramids() {

		int ret = 0;

		while(true) {

			if(A == B)
				return ret;

			if(level[A] == level[B]) {
				ret += Math.abs(A - B);
				B = A;
			}
			else if(A - getLocation(level[A]) <= B - getLocation(level[B])) {
				A -= (level[A] - 1);
				ret++;
			}
			else {
				A -= level[A];
				ret++;
			}
		}
	}

	static int getLocation(int currentHeight) {

		for(int i = 1; i <= 10153; i++)
			if(currentHeight == level[i])
				return i;

		return 0;
	}

	static void init() {

		int height = 1;
		int count = 0;

		//Initialize level
		for(int i = 1; i <= 10153; i++) {

			level[i] = height;
			count++;

			if(count == height) {
				height++;
				count = 0;
			}
		}
	}
}