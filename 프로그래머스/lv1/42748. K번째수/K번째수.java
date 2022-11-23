import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int firstIdx = commands[i][0];
            int lastIdx = commands[i][1];
            int cutIdx = commands[i][2];
            answer[i] = solve(firstIdx, lastIdx, cutIdx ,array);
        }
        return answer;
    }
    public static int solve(int i, int j, int k, int[] array){
        int[] cutArray = Arrays.copyOfRange(array, i-1,j);
        Arrays.sort(cutArray);
        return cutArray[k-1];
    }
}