import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static HashMap<String, Integer> code = new HashMap<>();
	static HashSet<String> set = new HashSet<>();
	
	static int Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		String cryptograph;
		init();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				
				cryptograph = br.readLine().replace('0', ' ');
				cryptograph = cryptograph.trim();
		
				if(cryptograph.length() == 0)
					continue;
				if(set.contains(cryptograph))
					continue;

				set.add(cryptograph);
				cryptograph = cryptograph.replace(" ", "0");
				
				int[] ret = binaryCode(cryptograph);
				int decode = ((ret[0] + ret[2] + ret[4] + ret[6]) * 3) + (ret[1] + ret[3] + ret[5]) + ret[7];
				
				if(decode % 10 == 0) {
					
					for(int j = 0; j < 8; j++)
						Answer += ret[j];
				}
				else
					Answer = 0;
			}
			System.out.println("#"+(test_case+1)+" "+Answer);
			set.clear();
			Answer = 0;
		}
		br.close();
	}

	static void init() {
		
		code.put("0001101", 0);
		code.put("0011001", 1);
		code.put("0010011", 2);
		code.put("0111101", 3);
		code.put("0100011", 4);
		code.put("0110001", 5);
		code.put("0101111", 6);
		code.put("0111011", 7);
		code.put("0110111", 8);
		code.put("0001011", 9);
	}
	
	static int[] binaryCode(String cryptograph) {
		
		StringBuffer sb = new StringBuffer(cryptograph);
		int[] decodingCode = new int[8];
		int idx = 0;
		
		if(sb.length() != 56) {
			
			while(sb.length() != 56)
				sb.insert(0, "0");
		}
		
		for(int i = 0; i < 56; i += 7) {
			
			String temp = sb.substring(i, i + 7);
			
			if(code.containsKey(temp))
				decodingCode[idx++] = code.get(temp);
		}
		return decodingCode;
	}
}
