import java.util.*;
class Solution {
    static int[] dir = new int[]{1, -1};
    static int cnt = 0;

    public static void cntNum(int num, int[][] picture, int x, int y) {
        if (x < 0 || x > picture[0].length - 1 ||
                y < 0 || y > picture.length - 1) return;
        else if (picture[y][x] == num) {
            picture[y][x] = -1;
            cnt++;
            cntNum(num, picture, x + dir[0], y);
            cntNum(num, picture, x + dir[1], y);
            cntNum(num, picture, x, y + dir[0]);
            cntNum(num, picture, x, y + dir[1]);
        }
        return;
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int[][] curPicture = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curPicture[i][j] = picture[i][j];
            }
        }
        int maxCnt = 0;
        int zone = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (curPicture[i][j] != 0 && curPicture[i][j] != -1) {
                    zone++;
                    int curNum = curPicture[i][j];
                    cntNum(curNum, curPicture, j, i);
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = zone;
        answer[1] = maxCnt;
        return answer;
    }
}