package Wayfair;

import java.util.*;

public class AnagramFinder {
    private Map<String, List<String>> anagramMap = new HashMap<>();

    public AnagramFinder(List<String> words) {
        for (String word : words) {
            String sortedWord = sortString(word);
            anagramMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
    }

    public List<List<String>> getSearchResult(List<String> queries) {
        List<List<String>> searchResults = new ArrayList<>();

        for (String query : queries) {
            String sortedQuery = sortString(query);
            List<String> anagramList = anagramMap.get(sortedQuery);
            if (anagramList != null) {
                Collections.sort(anagramList); // Sort the anagrams
            } else {
                anagramList = new ArrayList<>();
            }
            searchResults.add(anagramList);
        }

        return searchResults;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "hello", "world", "dog", "god");
        AnagramFinder finder = new AnagramFinder(words);

        List<String> queries = Arrays.asList("listen", "hello");
        List<List<String>> searchResults = finder.getSearchResult(queries);

        for (int i = 0; i < queries.size(); i++) {
            if (searchResults.get(i).isEmpty()) {
                System.out.println("No anagrams found for: " + queries.get(i));
            } else {
                System.out.println("Anagrams for " + queries.get(i) + ": " + searchResults.get(i));
            }
        }
    }
}
