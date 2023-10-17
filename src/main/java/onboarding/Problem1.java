package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
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


        // process the result
        int result = -1; // default result = error

        if ((pobi.get(1) - pobi.get(0)) == 1 & (crong.get(1) - crong.get(0) == 1)) { // only when the pages are sequential
            if (pobiNum > crongNum) {
                result = 1;
            } else if (pobiNum < crongNum) {
                result = 2;
            } else if (pobiNum == crongNum) {
                result = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("result: " + solution(Arrays.asList(131, 132), Arrays.asList(211, 212)));
    }
}