package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
//        List<Integer> pobi = Arrays.asList(97, 98);
//        List<Integer> crong = Arrays.asList(197, 198);

        // initial input values
        List<Integer> pobi = Arrays.asList(97, 98);
        List<Integer> crong = Arrays.asList(297, 298);

        List<List> members = Arrays.asList(pobi, crong); // create list, number of participant of the game
        List<Integer> biggerNumbers = new ArrayList<>(); // create list, bigger numbers between sum and multiply

        for (int i = 0; i < members.size(); i++) { // first member (pobi) -> second -> ...
            for (int j = 0; j < members.get(i).size(); j++) { // first member's left page -> right -> second's -> ...

                int number = (int) members.get(i).get(j); // first member's left page number -> right -> second's -> ...
                int digit = number;
                int sum = 0;
                int multiply = 1;

                while (number > 0) { // loop for sum and multiply
                    digit = number % 10; // get the smallest digit

                    // update sum and multiply
                    sum += digit;
                    multiply *= digit;

                    number /= 10; // to get the next smallest digit
                }
                biggerNumbers.add(Math.max(sum, multiply)); // add bigger number between sum and multiply to the list in order of left page -> right
            }
        }

        // bigger numbers between left and right pages
        // first two elements = pobi
        // last two elements = crong
        int pobiNum = Math.max(biggerNumbers.get(0), biggerNumbers.get(1));
        int crongNum = Math.max(biggerNumbers.get(2), biggerNumbers.get(3));

        // show the result
        if (pobiNum > crongNum) {
            System.out.println(1);
        } else if (pobiNum < crongNum) {
            System.out.println(2);
        } else if (pobiNum == crongNum) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }
    }
}