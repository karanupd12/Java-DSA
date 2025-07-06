package GRAPHS.Questions;
import java.util.*;

/*
Problem: https://leetcode.com/problems/word-ladder/

Approach: This problem can be solved using BFS. We can treat each word as a node and the edges are formed by changing
one letter at a time to form another valid word in the word list.
- The BFS will explore all possible transformations from the beginWord until it reaches the endWord.
- Time Complexity: O(N * M * 26), where N is the number of words in the wordList, M is the length of each word, and 26 is
the number of letters in the alphabet.
- A set is used to keep track of the words that have already been visited to avoid cycles.

*/


public class WordLadder {
    class Pair{
        String word;
        int step;
        public Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair pair = q.poll();
            String word = pair.word;
            int steps = pair.step;
            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String replacedWord = new String(charArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }

        return 0;
    }
}
