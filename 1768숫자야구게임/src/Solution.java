import java.util.Scanner;

class Solution {
    private final static int N              = 4;  
    private final static int MAX_QUERYCOUNT = 1000000;

    private static int digits[] = new int[N]; 
    private static int digits_c[] = new int[10];

    private static int T;                          

	private static int querycount;
	
    // the value of limit_query will be changed in evaluation
	private final static int limit_query = 2520;

    static class Result {
        public int strike;                                
        public int ball;
	}
	
	private static boolean isValid(int guess[]) {
		int guess_c[] = new int[10];
		
		for (int count = 0; count < 10; ++count) guess_c[count] = 0;
		for (int idx = 0; idx < N; ++idx) {
			if (guess[idx] < 0 || guess[idx] >= 10 || guess_c[guess[idx]] > 0) return false;
			guess_c[guess[idx]]++;
		}
		return true;
	}
	
	// API : return a result for comparison with digits[] and guess[]
    public static Result query(int guess[]) {
		Result result = new Result();
		
		if (querycount >= MAX_QUERYCOUNT) {
			result.strike = -1;
			result.ball = -1;
			return result;
		}
		
		querycount++;
		
		if (!isValid(guess)) {
			result.strike = -1;
			result.ball = -1;
			return result;
		}
		
		result.strike = 0;
		result.ball = 0;

		for (int idx = 0; idx < N; ++idx)
			if (guess[idx] == digits[idx])
				result.strike++;
			else if (digits_c[guess[idx]] > 0)
				result.ball++;
		
		return result;
	}

	private static void initialize(Scanner sc) {
		for (int count = 0; count < 10; ++count) digits_c[count] = 0;
		
		String input;
		do input = sc.next(); while(input.charAt(0) < '0' || input.charAt(0) > '9');

		for (int idx = 0; idx < N; ++idx) {
			digits[idx] = input.charAt(idx) - '0';
			digits_c[digits[idx]]++;
		}
		
		querycount = 0;
	}

	private static boolean check(int guess[]) {
		for (int idx = 0; idx < N; ++idx)
			if (guess[idx] != digits[idx]) return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception
	{
		
		int total_score = 0;
		int total_querycount = 0;
		
		System.setIn(new java.io.FileInputStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		UserSolution usersolution = new UserSolution();
		for (int testcase = 1; testcase <= T; ++testcase) {
			initialize(sc);

			int guess[] = new int[N];
            usersolution.doUserImplementation(guess);

			if (!check(guess)) querycount = MAX_QUERYCOUNT;
			if (querycount <= limit_query) total_score++;
			System.out.printf("#%d %d\n", testcase, querycount);
			total_querycount += querycount;
		}
		if (total_querycount > MAX_QUERYCOUNT) total_querycount = MAX_QUERYCOUNT;
		System.out.printf("total score = %d\ntotal query = %d\n", total_score * 100 / T, total_querycount);
		sc.close();
	}
}