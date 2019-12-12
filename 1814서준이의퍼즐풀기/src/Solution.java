import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Location implements Comparable<Location> {

    int position;
    int required;

    public Location(int position, int required) {
        this.position = position;
        this.required = required;
    }

    @Override
    public int compareTo(Location other) {

        if(this.required < other.required)
            return 1;
        else if(this.required > other.required)
            return -1;
        else {

            if(this.position < other.position)
                return 1;
            else if(this.position > other.position)
                return -1;
        }
        return 1;
    }
}

public class Solution {

    static ArrayList<Location> locationR = new ArrayList<>();
    static ArrayList<Location> locationC = new ArrayList<>();

    static int[] requiredValueR;
    static int[] requiredValueC;
    static int[] requiredValueS;

	static int N;
	
	public static void main(String[] args) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("1814서준이의퍼즐풀기\\input.txt"));
        StringTokenizer st;
        int value;

		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {

		    N = Integer.parseInt(br.readLine());

            requiredValueR = new int[N];
		    requiredValueC = new int[N];
            requiredValueS = new int[N];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {

                value = Integer.parseInt(st.nextToken());
                requiredValueR[i] = value;
                locationR.add(new Location(i, value));
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {

                value = Integer.parseInt(st.nextToken());
                requiredValueC[i] = value;
                locationC.add(new Location(i, value));
            }
            Collections.sort(locationR);
            Collections.sort(locationC);
			System.out.println("#"+(test_case+1) + " " + (seoJoonsPuzzle() ? "Yes" : "No"));

			locationR.clear();
			locationC.clear();
		}
		br.close();
	}

	static boolean seoJoonsPuzzle() {

	    int required, criteria;

	    for(Location location : locationR) {

	        required = location.required;
	        criteria = 0;
	        for(Location obj : locationC) {

	            if(requiredValueS[obj.position] < requiredValueC[obj.position]) {

                    requiredValueS[obj.position]++;
                    criteria++;
                }
            }
	        if(criteria != required)
	            return false;
        }
	    return true;
    }
}