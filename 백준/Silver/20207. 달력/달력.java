import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Pair {

		int S;
		int E;

		public Pair(int S, int end) {
			this.S = S;
			this.E = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
			if (a.S == b.S) {
				return b.E - a.E;
			}
			return a.S - b.S;
		});
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			pq.add(new Pair(S, E));
			max = Math.max(max, E);
		}
		int[][] map = new int[N][max + 2];
		while (!pq.isEmpty()) {
			Pair current = pq.poll();
			for (int i = 0; i < N; i++) {
				if (map[i][current.S] == 1) {
					continue;
				}
				for (int j = current.S; j <= current.E; j++) {
					map[i][j] = 1;
				}
				break;
			}
		}
		int start = 365;
		int end = 0;
		int height = 0;
		int answer = 0;
		for (int j = 1; j < map[0].length; j++) {
			boolean stop = true;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 1) {
					end = Math.max(end, j);
					start = Math.min(start, j);
					height = Math.max(height, i + 1);
					stop = false;
				}
			}
			if (stop) {
				answer += ((end - start + 1) * height);
				start = 365;
				end = 0;
				height = 0;
			}
		}
		System.out.println(answer);
	}
}