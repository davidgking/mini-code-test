package net.mini;

public class FunGame {
    // Stage 1

    /**
     * 1. If a number divisible by 3, print Fizz
     * 2. If a number divisible by 5, print Buzz
     * 3. If a number divisible by 3 or 5, print FizzBuzz
     */
    public void game1(){
        for (Integer i = 1; i <= 100; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0 && !(i % 5 == 0)) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0 && !(i % 3 == 0)) {
                    System.out.println("Buzz");
                } else {
                    System.out.println("FizzBuzz");
                }
            } else {
                System.out.println(i);
            }
        }
    }

    // Stage 2
    /**
     * 1. A number is Fizz if it is divisible by 3 or if it has a 3 in it.
     * 2. A number is Buzz if it is divisible by 5 or if it has a 5 in it.
     * 3. A number is FizzBuzz if it is divisible by 3 or 5 or if it has a 3 or 5 in it. (This requirement conflicts with requirement 1 and 2)
     * Requirement 3 should revise to "A number is FizzBuzz if it is divisible by 3 and 5 or if it has a 3 and 5 in it"
     */
    public void game2(){
        for (Integer i = 1; i <= 100; i++) {
            if (i % 3 == 0
                    || i % 5 == 0
                    || countCharOfNumber(i.toString(), "3") == 1
                    || countCharOfNumber(i.toString(), "5") == 1
                    || (countCharOfNumber(i.toString(), "3") == 1  && countCharOfNumber(i.toString(), "5") == 1)) {
                if (((i % 3 == 0 && !(i % 5 == 0) && countCharOfNumber(i.toString(), "5") == 0) || (countCharOfNumber(i.toString(), "3") == 1 && countCharOfNumber(i.toString(), "5") == 0 && !(i % 5 == 0)))) {
                    System.out.println("Fizz");
                } else if (((i % 5 == 0 && !(i % 3 == 0) && countCharOfNumber(i.toString(), "3") == 0) || (countCharOfNumber(i.toString(), "5") == 1 && countCharOfNumber(i.toString(), "3") == 0 && !(i % 3 == 0)))) {
                    System.out.println("Buzz");
                } else {
                    System.out.println("FizzBuzz");
                }
            } else {
                System.out.println(i);
            }
        }
    }

    // count pattern number
    private int countCharOfNumber(String numStr, String patternNumStr){
        if (numStr == null || numStr.equals("")) {
            return 0;
        }
        int index = numStr.indexOf(patternNumStr);
        int lastIndex = numStr.lastIndexOf(patternNumStr);
        if(index != -1){
            if(index == lastIndex){
                return 1;
            }else{
                numStr = numStr.substring(index, patternNumStr.length());
                String[] ps = numStr.split(patternNumStr);
                return ps.length;
            }
        }else{
            return 0;
        }
    }
}
