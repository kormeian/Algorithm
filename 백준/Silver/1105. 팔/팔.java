import java.io.*;
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        char[] l = s[0].toCharArray();
        char[] r = s[1].toCharArray();
        int cnt = 0;
        int differentIndex = 0;
        if (l.length == r.length) {
            for (int i = 0; i < l.length; i++) {
                if (l[i] == r[i]) {
                    if (l[i] == '8') {
                        cnt ++;
                    }
                }else break;
            }
        }
        System.out.println(cnt);
    }
}