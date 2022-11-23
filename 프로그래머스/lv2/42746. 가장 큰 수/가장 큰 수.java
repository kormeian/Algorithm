import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .collect(Collectors.joining());
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}