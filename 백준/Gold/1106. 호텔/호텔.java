import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C + 101];
		Arrays.fill(dp, 999999);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customers = Integer.parseInt(st.nextToken());
			for (int j = customers; j < C + 101; j++) {
				dp[j] = Math.min(dp[j], dp[j - customers] + cost);
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = C; i < C + 101; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);
		br.close();
	}

}