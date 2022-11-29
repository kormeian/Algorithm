import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] W = new String[T];
		int[] K = new int[T];
		Map<Character, Integer>[] map = new Map[T];
		for (int i = 0; i < T; i++) {
			W[i] = br.readLine();
			char[] temp = W[i].toCharArray();
			map[i] = new HashMap<>();
			for (char c : temp) {
				if (map[i].containsKey(c)) {
					map[i].put(c, map[i].get(c) + 1);
				} else {
					map[i].put(c, 1);
				}
			}
			K[i] = Integer.parseInt(br.readLine());
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < T; i++) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (Character c : map[i].keySet()) {
				int value = map[i].get(c);
				if (value < K[i]) {
					continue;
				}
				int idx = -1;
				for (int j = 0; j <= value - K[i]; j++) {
					int firstIdx = W[i].indexOf(c, idx + 1);
					int lastIdx = firstIdx;
					for (int k = 1; k < K[i]; k++) {
						lastIdx = W[i].indexOf(c, lastIdx + 1);
					}
					idx = firstIdx;
					min = Math.min(min, lastIdx - firstIdx + 1);
					max = Math.max(max, lastIdx - firstIdx + 1);
				}
			}
			if (min == Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}