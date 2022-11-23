import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int sum = -Integer.MAX_VALUE;
        int[] temp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=n-k;i++) {
            int curSum=0;
            for(int j=i;j<i+k;j++) {
                curSum +=temp[j];
            }
            sum = Math.max(sum, curSum);
        }
        System.out.println(sum);
    }
}
