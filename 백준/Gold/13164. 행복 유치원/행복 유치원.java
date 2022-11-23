import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N - 1; i++) {
			pq.add(heights[i + 1] - heights[i]);
		}
		int answer = 0;
		for (int i = 0; i < N - P; i++) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
}