import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Examination implements Comparable<Examination> {

	int judgingTime;
	int remainTime;

	Examination() {}
	Examination(int judgingTime) {

		this.judgingTime = judgingTime;
		this.remainTime = 0;
	}

	@Override
	public int compareTo(Examination other) {
		return (this.remainTime + this.judgingTime) > (other.remainTime + other.judgingTime) ? 1 : -1;
	}
}

public class Solution {

	static LinkedList<Examination> examinations = new LinkedList<>();

	static int Awaiter;
	static int N;

	public static void main(String args[]) throws Exception	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			Awaiter = Integer.parseInt(st.nextToken());

			for(int i = 0; i < N; i++)
				examinations.add(new Examination(Integer.parseInt(br.readLine())));
			Immigration();

			System.out.println("#"+(test_case+1) + " " + examinations.get(0).remainTime);
			examinations.clear();
		}

		br.close();
	}

	static void Immigration() {

		while(Awaiter-- > 0) {

			Collections.sort(examinations);
			examinations.get(0).remainTime += examinations.get(0).judgingTime;
		}
	}
}