//package exercise;
//
//import java.util.Scanner;
//
//public class InputMismatchEx {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while(true) {
//            System.out.println("점수를 입력하세요");
//            String input = scanner.nextLine();
//
//            if (input.equals("q"))
//                break;
//
//            try {
//                int score = scanner.nextInt();
//
//                if (score >= 60) {
//                    System.out.println("합격입니다.");
//                } else
//                    System.out.println("다음에 다시 봐요.");
//            }
//        }catch{
//
//        }
//        System.out.println("프로그램 종료");
//        scanner.close();
//    }
//}
