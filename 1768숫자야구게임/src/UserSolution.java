
class UserSolution {
	
    public final static int N = 4;

    public void doUserImplementation(int guess[]) {
    	
    	guess[0] = 8;
    	guess[1] = 9;
    	guess[2] = 7;
    	guess[3] = 5;
    	
    	Solution.Result result = Solution.query(guess);
    	
    	System.out.println(result.strike);
    	System.out.println(result.ball);
    }
}