import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Long[] answer = new Long[T];
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long sum = 0L;
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			for (int j = 0; j < K; j++) {
				pq.add(Long.valueOf(st.nextToken()));
			}
			while (pq.size() > 1) {
				Long a = pq.poll();
				Long b = pq.poll();
				sum += a + b;
				pq.add(a + b);
			}
			answer[i] = sum;
		}
		for (int i = 0; i < T; i++) {
			System.out.println(answer[i]);
		}
	}
}