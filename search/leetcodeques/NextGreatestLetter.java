package search.leetcodeques;
public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        //BY LINEAR SEARCH
        int a = target;
        for (int i = 0; i < letters.length; i++){
            int b = letters[i];
            if (b > a ){
                return letters[i];
            }
        }
        return letters[0];

        //BY BINARY SEARCH
//        int a = target;
//        int s = 0;
//        int e = letters.length - 1;
//        int result = letters[0];
//        while (s <= e) {
//            int mid = s + (e - s) / 2;
//            int b = letters[mid];
//            if  ( a == b){
//                return letters[mid+1];
//            }
//            else if (b > a) {
//                e = mid - 1;
//                result = mid;
//            }
//            else
//                s = mid + 1;
//        }
//        return letters[result];
    }

    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'g';
        System.out.println(nextGreatestLetter(arr, target));
    }

}
