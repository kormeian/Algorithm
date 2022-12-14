import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[][] myFriends = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			myFriends[a][b] = true;
			myFriends[b][a] = true;
		}
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		int answer = 0;
		for (int i = 2; i < n + 1; i++) {
			if (myFriends[1][i]) {
				if (!visited[i]) {
					visited[i] = true;
					answer++;
				}
				for (int j = 2; j < n + 1; j++) {
					if (i != j && myFriends[i][j] && !visited[j]) {
						visited[j] = true;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}