import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int start = 0;
		while (N-- > 0) {
			int value = Integer.parseInt(br.readLine());
			if (value > start) {
				for (int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			} else if (stack.peekFirst() != value) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
		br.close();
	}

}