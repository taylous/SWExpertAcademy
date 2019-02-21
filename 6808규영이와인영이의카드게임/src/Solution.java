import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] gyuyeong;
	static int[] otherNumber;

	static int totalCase = 362880;
	static int Answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine());
			
			boolean[] chk = new boolean[19];
			gyuyeong = new int[9];
			otherNumber = new int[9];
			idx = 0;

			for (int i = 0; i < 9; i++) {
				gyuyeong[i] = Integer.parseInt(st.nextToken());
				chk[gyuyeong[i]] = true;
			}
			for(int i = 1; i <= 18; i++) {
				
				if(!chk[i])
					otherNumber[idx++] = i;
			}
			kyoungYungAndInYoungCardGame(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 }, 0);

			System.out.println("#" + (test_case + 1) + " " + Answer + " " + (totalCase - Answer));
			Answer = 0;
		}
		br.close();
	}

	static void kyoungYungAndInYoungCardGame(int[] inyeong, int idx) {

		if (idx == 9) {

			int gyuyeongScore = 0;
			int inyeongScore = 0;

			for (int i = 0; i < 9; i++) {

				if (gyuyeong[i] > otherNumber[inyeong[i]])
					gyuyeongScore += gyuyeong[i] + otherNumber[inyeong[i]];
				else
					inyeongScore += otherNumber[inyeong[i]] + gyuyeong[i];
			}
			Answer += gyuyeongScore > inyeongScore ? 1 : 0;
			return;
		}

		for (int i = idx; i < 9; i++) {

			int temp = inyeong[idx];
			inyeong[idx] = inyeong[i];
			inyeong[i] = temp;
			
			kyoungYungAndInYoungCardGame(inyeong, idx + 1);
			
			temp = inyeong[idx];
			inyeong[idx] = inyeong[i];
			inyeong[i] = temp;
		}
	}
}