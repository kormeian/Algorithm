import java.util.Arrays;

class Solution {
    public int solution(String[][] clothes) {
        int answer = Arrays.stream(clothes)
                .map(x -> x[1])
                .distinct()
                .map(x -> (int)Arrays.stream(clothes).map(y -> y[1]).filter(y -> y.equals(x)).count())
                .map(x -> x+1)
                .reduce(1, (x,y) -> x*y);

        return --answer;
    }
}