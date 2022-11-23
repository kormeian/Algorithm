import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        Set<Integer>[] set = new Set[9];
        int curN = N;
        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
            set[i].add(curN);
            curN = curN * 10 + N;
        }
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i/2; j++) {
                for(Integer first : set[j]){
                    for(Integer second : set[i-j]){
                        set[i].add(first + second);
                        set[i].add(first - second);
                        set[i].add(second - first);
                        set[i].add(first * second);
                        if(first != 0){
                            set[i].add(second / first);
                        }
                        if(second != 0){
                            set[i].add(first / second);
                        }
                        if(set[i].contains(number))
                            return i;
                    }
                }
            }
        }
        return -1;
    }
}