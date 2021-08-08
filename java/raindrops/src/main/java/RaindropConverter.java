class RaindropConverter {

    private static final String PLING = "Pling";
    private static final String PLANG = "Plang";
    private static final String PLONG = "Plong";

    String convert(int number) {
        StringBuilder rainDropStringBuilder = new StringBuilder();

        if (number % 3 == 0) {
            rainDropStringBuilder.append(PLING);
        }
        if (number % 5 == 0) {
            rainDropStringBuilder.append(PLANG);
        }
        if (number % 7 == 0) {
            rainDropStringBuilder.append(PLONG);
        }

        if (rainDropStringBuilder.length() == 0) {
            rainDropStringBuilder.append(number);
        }
        
        return rainDropStringBuilder.toString();
    }

}
