package exercise;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
    private static final int MAX_ATTEMPTS = 10;
    // 정답 숫자를 랜덤으로 생성하기 위해 상수 제거
    // private static final int[] ANSWER = {1, 4, 7};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("야구 게임 시작!");
        System.out.println("0부터 9까지의 숫자 중에서 중복 없이 3개의 숫자를 입력하세요.");
        System.out.println("각 숫자는 띄어쓰기나 콤마로 구분하여 입력하세요.");

        // 랜덤 정답 숫자 생성
        int[] answer = generateAnswer();

        for (int attempts = 1; attempts <= MAX_ATTEMPTS; attempts++) {
            System.out.print("시도 횟수 " + attempts + ": ");
            try {
                String userInput = scanner.nextLine();
                // 사용자 입력에 공백을 제거하여 숫자 추출
                userInput = userInput.replaceAll("\\s+", "");
                if (userInput.length() != 3)
                    throw new IllegalArgumentException("입력한 숫자의 개수가 올바르지 않습니다.");
                int[] userGuess = parseGuess(userInput);
                String result = checkGuess(userGuess, answer);
                System.out.println("결과: " + result);
                if (result.equals("3S")) {
                    System.out.println("정답을 맞추셨습니다! 축하합니다!");
                    return;
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("10번의 기회를 모두 사용했습니다. 정답은 " + answer[0] + ", " + answer[1] + ", " + answer[2] + "입니다.");
    }

    private static int[] generateAnswer() {
        // 랜덤으로 0부터 9까지의 숫자를 중복 없이 선택하여 정답 배열 생성
        Set<Integer> answerSet = new HashSet<>();
        while (answerSet.size() < 3) {
            int randomNumber = (int) (Math.random() * 10);
            answerSet.add(randomNumber);
        }
        int[] answer = new int[3];
        int index = 0;
        for (int num : answerSet) {
            answer[index++] = num;
        }
        return answer;
    }

    private static int[] parseGuess(String userInput) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(userInput.charAt(i)); // 문자열을 숫자로 변환
            if (num < 0 || num > 9 || uniqueNumbers.contains(num))
                throw new InputMismatchException("0부터 9까지의 숫자 중 중복 없이 3개를 입력하세요.");
            uniqueNumbers.add(guess[i] = num);
        }
        return guess;
    }

    private static String checkGuess(int[] userGuess, int[] answer) {
        int strike = 0, ball = 0, notInAnswer = 0;
        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == answer[i]) strike++;
            else if (contains(answer, userGuess[i])) ball++;
            else notInAnswer++;
        }
        StringBuilder result = new StringBuilder();
        if (strike > 0) result.append(strike).append("S ");
        if (ball > 0) result.append(ball).append("B ");
        if (notInAnswer > 0) result.append(notInAnswer).append("O ");
        return result.toString().trim();
    }

    private static boolean contains(int[] array, int target) {
        for (int num : array) if (num == target) return true;
        return false;
    }
}
