package StringMatching;

public class NaiveStringMatching {
    public static void search(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        for(int i = 0; i < n; i++){
            int j;
            for(j = 0;j < m; j++){
                if(text.charAt(i+j) != pattern.charAt(j)) break;
            }
            if(j == m) System.out.println("Pattern Found at " + i);
        }
    }

    public static void main(String[] args) {
        String text = "nearmyear";
        String pattern = "ear";
        search(text, pattern);
    }
}
