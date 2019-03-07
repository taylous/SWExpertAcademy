import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Location {
	
	int x;
	int y;
	int count;
	
	public Location(int x, int y, int count) {
		
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Solution {

	static LinkedList<Location> Answer = new LinkedList<>();
	
	static int[][] plate;
	static int[] platingCost = { 0, 2, 4, 7 };
	
	static int S;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 0; test_case < T; test_case++) {
			
			S = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			
			plate = new int[S][S];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				plate[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
			
			simplePlatingCost(0, 0, S, 3, true);
			
			sb.append("#");
			sb.append(test_case + 1);
			sb.append(" ");
			sb.append(Answer.size());
			sb.append(" ");
			
			while(!Answer.isEmpty()) {
				
				Location location = Answer.remove();
				sb.append(location.x);
				sb.append(" ");
				sb.append(location.y);
				sb.append(" ");
				sb.append(location.count);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static int countDamagedMetal(int row, int col, int size) {
		
		int count = 0;
		for(int i = row; i < row + size; i++) {
			
			for(int j = col; j < col + size; j++)
				count += plate[i][j] == 1 ? 1 : 0;
		}
		return count;
	}
	
	static Location findDamagedMetalPlate(int startX, int startY, int size, int platingSize) {
		
		int maxRow = 0, maxCol = 0, maxCount = 0, count;
		
		for(int i = startX; i <= startX + size - platingSize; i++) {
			
			for(int j = startY; j <= startY + size - platingSize; j++) {
				
				count = countDamagedMetal(i, j, platingSize);

				if(maxCount < count) {
					
					maxCount = count;
					maxRow = i;
					maxCol = j;
				}
			}
		}
		return new Location(maxRow, maxCol, maxCount);
	}
	
	static void provisionalPlating(int startX, int startY, int size, int preValue, int newValue) {
		
		for(int row = startX; row < startX + size; row++) {
			
			for(int col = startY; col < startY + size; col++)
				if(plate[row][col] == preValue)
					plate[row][col] = newValue;
		}
	}

	static int simplePlatingCost(int startX, int startY, int size, int platingSize, boolean flag) {
		
		int sum = 0, cost1, cost2;
		
		while(platingSize > 1) {
			
			Location location = findDamagedMetalPlate(startX, startY, size, platingSize);
			
			if(location.count == 0)
				break;
			cost1 = platingCost[platingSize];
			
			if(flag && platingSize == 3 && location.count <= 6) {
				
				int totalCost1 = simplePlatingCost(startX, startY, size, 3, false);
				int totalCost2 = simplePlatingCost(startX, startY, size, 2, false);
				
				if(totalCost2 < totalCost1) {
					
					platingSize = 2;
					continue;
				}
			}
			
			cost2 = 0;
			if(platingSize > 2) {
				
				Location location2 = findDamagedMetalPlate(location.x, location.y, platingSize, platingSize - 1);
				cost2 = platingCost[platingSize - 1];
				provisionalPlating(location2.x, location2.y, platingSize - 1, 1, 2);
				
				Location location3;
				do {
					
					location3 = findDamagedMetalPlate(location.x, location.y, platingSize, 2);
					if(location3.count > 1) {
					
						cost2 += platingCost[2];
						provisionalPlating(location3.x, location3.y, 2, 1, 2);
					}
				} while(location3.count > 1);
			}
			
			cost2 += platingCost[1] * countDamagedMetal(location.x, location.y, platingSize);
			provisionalPlating(location.x, location.y, platingSize, 2, 1);
			
			if(cost1 <= cost2) {
				
				provisionalPlating(location.x, location.y, platingSize, 1, flag ? 3 : 4);
				sum += cost1;
				
				if(flag)	
					Answer.add(new Location(location.x + 1, location.y + 1, platingSize));
			}
			else
				platingSize -= 1;
		}
		for(int i = startX; i < startX + size; i++) {
			
			for(int j = startY; j < startY + size; j++) {
				
				if(plate[i][j] == 1) {
					
					sum += platingCost[1];
					
					if(flag)	
						Answer.add(new Location(i + 1, j + 1, platingSize));
				}
			}
		}
		if(!flag)
			provisionalPlating(startX, startY, size, 4, 1);
		return sum;
	}
}
