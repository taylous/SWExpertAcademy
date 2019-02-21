import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution {

	static LinkedList<Integer> maxRoute = new LinkedList<>();
	static ArrayList<Integer> hotelLocation = new ArrayList<>();
	
	static int[][] distance;
	static int[][] sightseeingPoint;
	
	static int airPlane;
	
	static int Answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st;
		String[] container;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			distance = new int[N][N];
			sightseeingPoint = new int[N][3];
			
			for(int i = 0; i < N - 1 ; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				for(int j = i + 1; j < N; j++) {	
					distance[i][j] = Integer.parseInt(st.nextToken());
					distance[j][i] = distance[i][j];
				}
			}
			
			for(int i = 0; i < N; i++) {
				
				container = br.readLine().split(" ");
				
				if(container[0].equals("P")) {
					
					sightseeingPoint[i][0] = 1;
					sightseeingPoint[i][1] = Integer.parseInt(container[1]);
					sightseeingPoint[i][2] = Integer.parseInt(container[2]);
				}
				else if(container[0].equals("A")){
					
					sightseeingPoint[i][0] = 0;
					airPlane = i;
				}
				else {
					
					sightseeingPoint[i][0] = 2;
					hotelLocation.add(i);
				}
			}
			bumjunsTravelPlansToJejuIsland(new LinkedList<Integer>(), new boolean[N], 0, airPlane, 0, M - 1);
			System.out.print("#"+(test_case+1)+" "+Answer+" ");
			for(int path : maxRoute)
				System.out.print((path + 1) + " ");
			System.out.println();
			
			maxRoute.clear();
			hotelLocation.clear();
			Answer = 0;
		}
		br.close();
	}
	
	static int getNearHotelDistance(int location) {
		
		int var = Integer.MAX_VALUE;
		
		for(int idx : hotelLocation)
			var = Math.min(var, distance[location][idx]);
		return var;
	}
	

	static void bumjunsTravelPlansToJejuIsland(LinkedList<Integer> route, boolean[] visited, int satisfaction, 
			int currentLocation, int spentTime, int dayLeft) {
		
		if(dayLeft == -1)
			return;
		
		for(int next = 0; next < N; next++) {
			
			if(next == currentLocation)
				continue;
			if(visited[next]) {
				
				if(sightseeingPoint[next][0] != 2)
					continue;
			}
			if(spentTime + distance[currentLocation][next] + sightseeingPoint[next][1] > 540)
				continue;
			
			if(sightseeingPoint[next][0] == 0) {
				
				if(dayLeft == 0) {
					
					if(satisfaction > Answer) {
						
						maxRoute.clear();
						Answer = satisfaction;
						
						maxRoute.addAll(route);
						maxRoute.addLast(next);
					}
				}
				continue;
			}
			else if(sightseeingPoint[next][0] == 2) {
				
				if(dayLeft != 0) {
					
					route.addLast(next);
					visited[next] = true;
					bumjunsTravelPlansToJejuIsland(route, visited, satisfaction, next, 0, dayLeft - 1);
				}
				else
					continue;
			}
			else if(sightseeingPoint[next][0] == 1){
				
				if(dayLeft == 0) {
					
					if(spentTime + distance[currentLocation][next] + sightseeingPoint[next][1] +
							distance[next][airPlane] > 540)
						continue;
				}
				else if(dayLeft != 0) {
					
					if(spentTime + distance[currentLocation][next] + sightseeingPoint[next][1]
							+ getNearHotelDistance(next) > 540)
						continue;
				}
				route.addLast(next);
				visited[next] = true;
				bumjunsTravelPlansToJejuIsland(route, visited, satisfaction + sightseeingPoint[next][2], next, 
						spentTime + sightseeingPoint[next][1] + distance[currentLocation][next], dayLeft);
			}
			visited[next] = false;
			route.removeLast();
		}
	}
}
