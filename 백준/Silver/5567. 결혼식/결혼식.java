import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Node {

		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, 1));
			list[to].add(new Node(from, 1));
		}
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(1, 0));
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		int answer = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.weight >= 2) {
				continue;
			}
			for (Node next : list[node.to]) {
				if (!visited[next.to]) {
					visited[next.to] = true;
					answer++;
					q.add(new Node(next.to, node.weight + 1));
				}
			}
		}
		System.out.println(answer);
	}
}