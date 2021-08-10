
public class PigLatinTranslator {

    private static final String AY = "ay";
    private static final String QU = "qu";

    public String translate(String phrase) {
        final StringBuilder phraseBuilder = new StringBuilder();
        for (String word : phrase.split(" ")) {
            phraseBuilder.append(translateWord(word.toLowerCase())).append(" ");
        }
        return phraseBuilder.toString().trim();
    }

    public String translateWord(String word) {

        if (word.length() <=1) return "";

        final StringBuilder t = new StringBuilder(word);

        if (checkRule1(word)) {
            t.append(AY); 
        } else if (checkRule3(word)) {
            if (word.startsWith(QU)) { 
                moveBack(t, 2);
            } else {
                moveBack(t, 3);
            }
            t.append(AY);
        } else if (checkRule4(word)) {
            if (word.length() == 2) {
                moveBack(t, 1);
            } else {
                moveBack(t, word.split("y")[0].length());
            }
            t.append(AY);
        } else {
            //rule 2
            moveBack(t, firstVowelIndex(word));
            t.append(AY);
        }

        return t.toString();
    }

    private boolean checkRule1(final String word) {
        return word.matches("^[aeuio].*$") || word.startsWith("xr") || word.startsWith("yt");
    }
    private boolean checkRule3(final String word) {
        return word.matches("^[^aeuio]?qu.*$");
    }

    private boolean checkRule4(final String word) {
        return word.matches("^[^aeuio]+y.*$");
    }

    private void moveBack(final StringBuilder t, final int end) {
        final String moveBack = t.substring(0, end);
            t.append(moveBack);
            t.delete(0, end);
    }

    private boolean isVowel(final char c) {
        return String.valueOf(c).matches("^[aeuio]$");
    }

    private int firstVowelIndex(final String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) return i;
        }
        return -1;
    }
}