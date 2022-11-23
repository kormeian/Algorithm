import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int K = Integer.parseInt(firstLine[0]);
        int N = Integer.parseInt(firstLine[1]);

        int[] lanLengths = new int[K];
        for (int i = 0; i < K; i++) {
            lanLengths[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lanLengths);

        long max = lanLengths[K - 1];
        long min = 1;
        while (max >= min) {
            long middle = (max + min) / 2;
            int cnt = 0;
            for (int lanLength : lanLengths) {
                cnt += lanLength / middle;
            }
            if (cnt >= N) min = middle + 1;
            else max = middle - 1;
        }
        System.out.println(max);
    }
}
