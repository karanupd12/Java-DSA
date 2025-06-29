//searching missing element in arr [0,N] -- use cyclic sort approach
//ex arr=[1,3,2,5,0] therefore first sort array -- arr = [0,1,2,3,5]--missing element = 4
//asked in amazon


class Questions{
    public static void main(String[] args) {
        int[] arr={9,6,4,2,3,5,0,1,7};
        System.out.println(missingnumberin(arr));
    }

    public static int missingnumberin(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i];        
            if (arr[i] < arr.length && arr[i] != arr[correct]) {     
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;                                        
            }else{
                i++;
            }
        }
        for (int j=0 ; j<arr.length ; j++){
            if (arr[j]!=j){
                return j;
            }
        }return -1;
    }
}