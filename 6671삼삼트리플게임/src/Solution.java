import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

class SamSam implements Comparable<SamSam> {

	char color;
	int number;

	public SamSam(char color, int number) {

		this.color = color;
		this.number = number;
	}

	@Override
	public int compareTo(SamSam other) {

		return this.number < other.number ? -1 : 1;
	}
}

public class Solution {

	static SamSam[] samsam = new SamSam[9];
	static HashSet<String> set = new HashSet<>();

	static ArrayList<ArrayList<SamSam>> list = new ArrayList<>();

	static int Answer;
	static int[] rgb = new int[3];

	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
		char[] color, number;
		int r = 0, g = 0, b = 0;


		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {

			number = br.readLine().toCharArray();
			color = br.readLine().toCharArray();

			for(int i = 0; i < 3; i++)
				list.add(new ArrayList<>());
			
			for (int i = 0; i < 9; i++) {

				if (color[i] == 'R') {
					
					list.get(0).add(new SamSam(color[i], number[i]));
					r++;
				}
				else if (color[i] == 'G') {
					
					list.get(0).add(new SamSam(color[i], number[i]));
					g++;
				}
				else {
					
					list.get(0).add(new SamSam(color[i], number[i]));
					b++;
				}
			}
			
			//System.out.println("R");
			samSamTriple(new int[r], 0, r, 0);
			//System.out.println(rgb[0]);
			
			//System.out.println("G");
			samSamTriple(new int[g], 0, g, 1);
			//System.out.println(rgb[1]);
			
			//System.out.println("B");
			samSamTriple(new int[b], 0, b, 2);
			//System.out.println(rgb[2]);
			
			System.out.println("#"+(test_case+1)+" "+(rgb[0]+rgb[1]+rgb[2] == 3 ? "Win" : "Continue"));
			r = g = b = 0;
			Answer = 0;
			set.clear();
			list.clear();
		}
		br.close();
	}
	
	static void check(int[] combinations, int color) {
		
		LinkedList<Integer> num = new LinkedList<>();
		Collections.sort(list.get(color));
		int ret = 0;
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < combinations.length; j++) {
				if(i == combinations[j])
					num.add(j);
			}
			if(num.isEmpty())
				continue;
			
			if(list.get(0) == list.get(1) && list.get(1) == list.get(2))
				ret++;
			else if(num.get(0) + 1 == num.get(1) && num.get(1) + 1 == num.get(2))
				ret++;
			num.clear();
		}
		if(color == 0)
			rgb[0] = Math.max(rgb[0], ret);
		else if(color == 1)
			rgb[1] = Math.max(rgb[1], ret);
		else
			rgb[2] = Math.max(rgb[2], ret);
	}
	
	static void samSamTriple(int[] combinations, int count, int n, int color) {

		if(n == count) {
			
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < n; i++)
				sb.append(combinations[i]);
			
			if(set.contains(sb.toString()))
				return;
			set.add(sb.toString());
			
			//System.out.println(sb.toString());
			
			check(combinations, color);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			
			if(combinations[i] == 0) {
				
				combinations[i] = count / 3;
				samSamTriple(combinations, count + 1, n, color);
				combinations[i] = 0;
			}
		}
	}
}
