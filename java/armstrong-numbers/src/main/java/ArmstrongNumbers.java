class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int sum = 0;
        final String numberAsString = String.valueOf(numberToCheck);
        final int length = numberAsString.length();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(numberAsString.charAt(i));
            sum += Math.pow(digit, length);
        }

        return sum == numberToCheck;
    }
}
