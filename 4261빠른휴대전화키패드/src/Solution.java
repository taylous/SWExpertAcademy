import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	static HashMap<Character, Integer> hashMap = new HashMap<>();

    static int[] keyMap;
	static int Answer;
	static int N;
	
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("4261빠른휴대전화키패드\\sample_input.txt"));
        StringTokenizer st = null;
        String[] temp = null;
		init();

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

			System.out.print("#"+(test_case+1) + " ");

			st = new StringTokenizer(br.readLine(), " ");

			temp = st.nextToken().split("");
			N = Integer.parseInt(st.nextToken());

			keyMap = new int[temp.length];
			for(int i = 0; i < temp.length; i++)
			    keyMap[i] = Integer.parseInt(temp[i]);

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
			    Answer += FastCellPhoneKeypad(st.nextToken());

			System.out.println(Answer);
			Answer = 0;
		}
		
		br.close();
	}

	static void init() {

		hashMap.put(' ', 1);

		hashMap.put('a', 2);
		hashMap.put('b', 2);
		hashMap.put('c', 2);

		hashMap.put('d', 3);
		hashMap.put('e', 3);
		hashMap.put('f', 3);

		hashMap.put('g', 4);
		hashMap.put('h', 4);
		hashMap.put('i', 4);

		hashMap.put('j', 5);
		hashMap.put('k', 5);
		hashMap.put('l', 5);

		hashMap.put('m', 6);
		hashMap.put('n', 6);
		hashMap.put('o', 6);

		hashMap.put('p', 7);
		hashMap.put('q', 7);
		hashMap.put('r', 7);
		hashMap.put('s', 7);

		hashMap.put('t', 8);
		hashMap.put('u', 8);
		hashMap.put('v', 8);

		hashMap.put('w', 9);
		hashMap.put('x', 9);
		hashMap.put('y', 9);
		hashMap.put('z', 9);
	}

	static int FastCellPhoneKeypad(String word) {

	    if(word.length() != keyMap.length)
	        return 0;

	    for(int i = 0; i < keyMap.length; i++) {
            if (keyMap[i] == hashMap.get(word.charAt(i))) {
                continue;
            } else
                return 0;
        }

        return 1;
    }
}