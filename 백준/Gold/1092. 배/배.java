import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] cranes = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cranes, Collections.reverseOrder());
		int M = Integer.parseInt(br.readLine());
		List<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(boxes, Collections.reverseOrder());
		if (boxes.get(0) > cranes[0]) {
			System.out.println(-1);
			return;
		}
		while (!boxes.isEmpty()) {
			int boxIndex = 0;
			for (int i = 0; i < N; ) {
				if (boxIndex == boxes.size()) {
					break;
				} else if (boxes.get(boxIndex) <= cranes[i]) {
					boxes.remove(boxIndex);
					i++;
				} else {
					boxIndex++;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}