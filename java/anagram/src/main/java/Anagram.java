import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    private final String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(final List<String> candidates) {

        final int[] wordArray = word.toLowerCase().chars().sorted().toArray();
        return candidates.stream()
            .filter(candidate -> !word.equalsIgnoreCase(candidate))
            .filter(candidate -> Arrays.equals(wordArray, candidate.toLowerCase().chars().sorted().toArray()))
            .collect(Collectors.toList());
    }
}