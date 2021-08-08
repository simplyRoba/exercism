import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {

        final String cleanPhrase = phrase.toLowerCase().replace(" ", "").replace("-", "");
        Set<Character> lettersInPhrasse = new HashSet<>();

        for (char letter: cleanPhrase.toCharArray()) {
            if (lettersInPhrasse.contains(letter)) {
                return false;
            } else {
                lettersInPhrasse.add(letter);
            } 
        }

        return true;
    }

}
