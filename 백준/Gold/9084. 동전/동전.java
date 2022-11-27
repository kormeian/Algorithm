import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] coins = new int[N];
			for (int j = 0; j < N; j++) {
				coins[j] = Integer.parseInt(st.nextToken());
			}
			int money = Integer.parseInt(br.readLine());
			int[] dp = new int[money + 1];
			dp[0] = 1;
			for (int coin : coins) {
				for (int j = coin; j <= money; j++) {
					dp[j] += dp[j - coin];
				}
			}
			sb.append(dp[money]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}