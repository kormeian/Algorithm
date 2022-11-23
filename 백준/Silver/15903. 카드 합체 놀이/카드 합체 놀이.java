import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] nums = new long[n];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long curSum = pq.poll() + pq.poll();
            pq.add(curSum);
            pq.add(curSum);
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
