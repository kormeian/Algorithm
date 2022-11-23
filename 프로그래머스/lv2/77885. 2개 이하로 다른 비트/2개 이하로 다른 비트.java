import java.util.Arrays;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				String numberString = Long.toString(numbers[i], 2);
				int lastZeroIndex = numberString.lastIndexOf("0");
				if (lastZeroIndex != -1) {
					numberString =
						numberString.substring(0, lastZeroIndex) + "10" + numberString.substring(
							lastZeroIndex + 2, numberString.length());
				} else {
					numberString = "10" + numberString.substring(1, numberString.length());
				}
				answer[i] = Long.parseLong(numberString, 2);
			}

		}
		return answer;
    }
}