public class Main {

    public static void main(String[] args) {
        int[] fibonnaciNumbers = new int[40];
        fibonnaciNumbers[0] = 0;
        fibonnaciNumbers[1] = 1;
        int total = 1;
        int howManyOdd = 1;
        int howManyDivisibleByThree = 0;
        int totalDivisibleByThree = 0;
        for (int i = 2; i < 40; i++) {
            fibonnaciNumbers[i] = fibonnaciNumbers[i - 1] + fibonnaciNumbers[i - 2];
            total += fibonnaciNumbers[i];
            if (fibonnaciNumbers[i] % 2 == 1) {
                howManyOdd++;
            }
            if (fibonnaciNumbers[i] % 3 == 0) {
                howManyDivisibleByThree++;
                totalDivisibleByThree += fibonnaciNumbers[i];
            }
        }
        System.out.println("The first 40 Fibonacci numbers are:");

        for (int i = 0; i < 40; i++) {
            System.out.println(fibonnaciNumbers[i]);
        }
        System.out.println("The total is " + total);
        System.out.println("There are " + howManyOdd + " odd numbers.");
        System.out.println("There are " + howManyDivisibleByThree + " numbers exactly divisible by 3.");
        System.out.println("These total " + totalDivisibleByThree);
        System.out.println("The average is " + ((double)total /40) );
    }
}
