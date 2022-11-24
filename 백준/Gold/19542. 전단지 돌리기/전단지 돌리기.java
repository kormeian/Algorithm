import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] map = new ArrayList[N + 1];
		for (int i = 0; i < map.length; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			map[to].add(from);
		}
		boolean[] visited = new boolean[N + 1];
		visited[S] = true;
		dfs(S, D, map, visited);
		System.out.println(Math.max(0, (answer - 1) * 2));
	}

	public static int dfs(int cur, int D, ArrayList<Integer>[] map, boolean[] visited) {
		int result = 0;
		for (Integer to : map[cur]) {
			if (visited[to]) {
				continue;
			}
			visited[to] = true;
			result = Math.max(result, dfs(to, D, map, visited));
		}
		if (result >= D) {
			answer++;
		}
		return result + 1;
	}
}