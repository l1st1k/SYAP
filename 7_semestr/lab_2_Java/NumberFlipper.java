public class NumberFlipper {
    public static void main(String[] args) {
        int numberToFlip = 46548;
        int flippedNumber = flipNumber(numberToFlip);
        System.out.println("Original Number: " + numberToFlip);
        System.out.println("Flipped Number: " + flippedNumber);
    }

    public static int flipNumber(int number) {
        // Handle negative numbers
        boolean isNegative = number < 0;
        if (isNegative) {
            number = -number;
        }

        int reversedNumber = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }

        return isNegative ? -reversedNumber : reversedNumber;
    }
}

