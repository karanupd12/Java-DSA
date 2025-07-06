package GRAPHS.Questions;
import java.util.*;

/*

Problem - https://leetcode.com/problems/word-ladder-ii/
Approach :-
- Start BFS by enqueuing a path containing just beginWord, and on each level, generate all valid one-letter
transformations of the last word in every path.

- For each valid transformation in the dictionary, append it to the path, enqueue the new path, and track visited words at
the current level (to avoid cross-contamination across paths).

- When level increases, remove all locally visited words from the dictionary (to avoid revisiting), and collect only those
paths that first reach endWord, ensuring all are shortest in length.

Time Complexity (TC): O(N × L²) , N = total number of words in the dictionary.
L = length of each word (since all words are same length in this problem).

Space Complexity (SC): O(N × L) for storing the paths and visited words.
 */


public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList); // word lookup set
        Queue<List<String>> queue = new LinkedList<>(); // BFS queue to store paths
        List<List<String>> result = new ArrayList<>();  // stores all shortest paths

        queue.offer(new ArrayList<>(List.of(beginWord))); // start with beginWord
        List<String> visitedThisLevel = new ArrayList<>(); // words visited at current level
        int level = 0;

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();

            // prune visited words once level increases
            if (path.size() > level) {
                level++;
                for (String word : visitedThisLevel) dict.remove(word);
                visitedThisLevel.clear();
            }

            String lastWord = path.get(path.size() - 1);

            // if endWord reached, add to result if path is shortest
            if (lastWord.equals(endWord)) {
                if (result.isEmpty() || path.size() == result.get(0).size())
                    result.add(path);
            }

            // try changing each character to find valid next words
            char[] wordChars = lastWord.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char originalChar = wordChars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    wordChars[i] = c;
                    String nextWord = new String(wordChars);
                    if (dict.contains(nextWord)) {
                        path.add(nextWord); // add next word to current path
                        queue.offer(new ArrayList<>(path)); // enqueue new path
                        visitedThisLevel.add(nextWord); // mark visited at this level
                        path.remove(path.size() - 1); // backtrack
                    }
                }
                wordChars[i] = originalChar; // restore character
            }
        }

        return result;
    }
}
