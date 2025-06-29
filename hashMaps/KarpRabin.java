package hashMaps;
// Karp Rabin algorithm is a string matching algo that takes constant time by comparing the hashcode of substring with the
// same length of hashcode of main string -- if matches then we have found our substring in main string

public class KarpRabin {

    private final int PRIME = 101;
    private double calculateHash(String str) {
        double hash = 0;
        for(int i=0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    //for moving in main string with the same length , we will delete first char and add the last+1 char
    //this is called rolling hash
    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        for(int i=0; i<= text.length() - patternLength; i++) {
            if(textHash == patternHash) {
                if(text.substring(i, i+patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args) {
        KarpRabin algo = new KarpRabin();
        algo.search("JohnKaranMike", "Karan");
    }
}
