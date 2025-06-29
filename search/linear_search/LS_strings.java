package search.linear_search;

public class LS_strings {
    public static void main(String[] args) {
        String name = "charlie";
        char target = 'l';
        System.out.println(linearsearch1(name , target));
        System.out.println(linearsearch1(name , target));
    }

    public static boolean linearsearch1(String str , char target){
    if (str.length()==0){
        return false;
    }

    //using "for" loop for search
    for (int i=0 ; i<str.length() ; i++){
        if (str.charAt(i)==target){            
            return true;                                        
        }
    }   
    return false; 
    }
    
    public static boolean linearsearch2(String str , char target){
        if (str.length()==0){
            return false;
        }
    
        //using "for each" loop for search
        for(char ch : str.toCharArray()){
            if (ch == target){
                return true;
            }
        } 
       return false; 
    }
}
