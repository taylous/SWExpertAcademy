import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Earthworm {

	int x;
	int y;

	Earthworm(int x, int y) {

		this.x = x;
		this.y = y;
	}
}

public class Solution {

	static ArrayList<Earthworm> earthworms = new ArrayList<>();
	static long Answer;
	static int N;

	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("1494사랑의카운슬러\\input.txt"));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			N = Integer.parseInt(br.readLine());

			for(int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				earthworms.add(new Earthworm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Answer = Long.MAX_VALUE;
			CounselorOfLove(0, 0, 0, 0);

			System.out.println("#"+(test_case+1) + " " + Answer);
			earthworms.clear();
		}
		
		br.close();
	}

	static void CounselorOfLove(long wormA, long wormB, int idx, int count) {

		if(idx == N) {

			if(count == N/2)
				Answer = Math.min(Answer, (wormA * wormA) + (wormB * wormB));
			return;
		}

		CounselorOfLove(wormA - earthworms.get(idx).x, wormB - earthworms.get(idx).y, idx + 1, count + 1);
		CounselorOfLove(wormA + earthworms.get(idx).x, wormB + earthworms.get(idx).y, idx + 1, count);
	}
}