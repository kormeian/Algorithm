class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        zip(0,0,arr.length,arr);
        return answer;
    }
    public static void zip(int x, int y, int size,int[][] arr){
        if(check(x, y, size, arr)){
            if(arr[x][y] == 0) answer[0]++;
            else answer[1]++;
        }else {
            zip(x,y,size/2,arr);
            zip(x+size/2,y,size/2,arr);
            zip(x,y+size/2,size/2,arr);
            zip(x+size/2,y+size/2,size/2,arr);
        }
    }
    public static boolean check(int x, int y, int size, int[][] arr){
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }
}