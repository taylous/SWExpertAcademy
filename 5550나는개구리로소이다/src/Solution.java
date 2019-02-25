import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

    static char[] cryingSound = { 'c', 'r', 'o', 'a', 'k' };
    static char[] recordedSound;

	static int Answer;

	public static void main(String args[]) throws Exception	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("5550나는개구리로소이다\\sample_input.txt"));
		int count = 0;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    recordedSound = br.readLine().toCharArray();

		    for(int start = 0; start <= recordedSound.length / 5; start++){

		        if(count == recordedSound.length)
		            break;

		        boolean chk = false;
		        int cryingSoundIdx = 0;

		        for(int i = 0; i < recordedSound.length; i++) {

		            if(recordedSound[i] == cryingSound[cryingSoundIdx]) {

		                cryingSoundIdx++;
                        recordedSound[i] = ' ';
                        count++;
                    }

		            if(cryingSoundIdx == 5) {
                        cryingSoundIdx = 0;
                        chk = true;
                    }
                }
                if(!chk || cryingSoundIdx != 0) {

                    Answer = -1;
                    break;
                }
                Answer++;
            }

			System.out.println("#"+(test_case+1) + " " + Answer);
			Answer = count = 0;
		}
		
		br.close();
	}
}