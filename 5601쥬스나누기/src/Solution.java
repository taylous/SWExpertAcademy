import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuffer sb;
        int n;

        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {

            sb = new StringBuffer();
            n = sc.nextInt();

            for(int i = 0; i < n; i++) {

                sb.append(" 1/");
                sb.append(n);
            }
            System.out.println("#"+test_case+sb.toString());
        }
    }
}
