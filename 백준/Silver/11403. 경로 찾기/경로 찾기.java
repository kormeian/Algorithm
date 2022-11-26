import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] map = new ArrayList[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i].add(j);
				}
			}
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visited;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			visited = new boolean[N + 1];
			q.add(i);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int next : map[cur]) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
			for (int j = 0; j < N; j++) {
				if (visited[j]) {
					sb.append("1 ");
				} else {
					sb.append("0 ");
				}
			}
			sb.replace(2 * N * (i + 1) - 1, 2 * N * (i + 1), "\n");
		}

		System.out.println(sb.toString());
	}
}