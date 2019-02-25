import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
=======
import java.io.InputStreamReader;
>>>>>>> f5f811e0f964cb248727b0a9688416a6d236ec10
import java.util.StringTokenizer;

public class Solution {

<<<<<<< HEAD
	static LinkedList<String> wordList = new LinkedList<>();
	static LinkedList<Character> alphabetList = new LinkedList<>();
	static int[] alphabet;
	
	static int Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		HashSet<Character> set = new HashSet<>();
		StringTokenizer st;
		
		String word;
		boolean flag;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine().trim());
			
			alphabet = new int[26];
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				
				word = br.readLine().trim();
				wordList.add(word);
				
				for(int j = 0; j < word.length(); j++)					
					set.add(word.charAt(j));
				
				Iterator<Character> it = set.iterator();
				while(it.hasNext())
					alphabet[it.next() - 'a']++;
				set.clear();
			}
			
			while(M-- > 0) {
				
				int maxCount = 0;
				int maxAlphabet = 0;
				
				for(int i = 0; i < 26; i++) {
					
					if(maxCount < alphabet[i]) {
						
						maxAlphabet = i;
						maxCount = alphabet[i];
					}
				}
				alphabet[maxAlphabet] = 0;
				alphabetList.add((char)(maxAlphabet + 'a'));
			}
			
			for(int i = 0; i < wordList.size(); i++) {
				
				word = wordList.get(i);
				flag = false;
				
				for(int j = 0; j < word.length(); j++) {
					
					if(!alphabetList.contains(word.charAt(j))) {
						
						flag = true;
						break;
					}
				}
				if(!flag)
					Answer++;
			}
			System.out.println("#"+(test_case+1)+" "+Answer);
			wordList.clear();
			alphabetList.clear();
			Answer = 0;
		}
		br.close();
	}

}
=======
    static int[] wordList;

    static int alphabet;
    static int Answer;
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String word;
        int size, var, temp;

        int T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(br.readLine().trim());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            wordList = new int[N];
            for (int i = 0; i < N; i++) {

                word = br.readLine().trim();
                size = word.length();
                var = 0;

                for (int j = 0; j < size; j++) {

                    temp = word.charAt(j) - 'a';

                    var |= (1 << temp);
                    alphabet |= (1 << temp);
                }
                wordList[i] = var;
            }
            temp = Integer.bitCount(alphabet);
            if (M > temp)
                globalWarming(0, 0, temp);
            else
                globalWarming(0, 0, M);
            System.out.println("#" + (test_case + 1) + " " + Answer);

            alphabet = 0;
            Answer = 0;
        }
        br.close();
    }

    static int checkingWord(int mask) {

        int ret = 0;

        for (int i = 0; i < N; i++) {

            if ((mask & wordList[i]) == wordList[i])
                ret++;
        }
        return ret;
    }

    static void globalWarming(int mask, int idx, int times) {

        if(26 - idx < times)
            return;
        if (idx == 26 && times != 0)
            return;

        if (times == 0) {

            Answer = Math.max(Answer, checkingWord(mask));
            return;
        }
        if ((alphabet & (1 << idx)) != 0) {

            int copyMask = mask;
            globalWarming(copyMask |= (1 << idx), idx + 1, times - 1);
        }
        globalWarming(mask, idx + 1, times);
    }
}
>>>>>>> f5f811e0f964cb248727b0a9688416a6d236ec10
