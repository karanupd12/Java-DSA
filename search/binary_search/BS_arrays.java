package search.binary_search;

class BS_arrays{
    public static void main(String[] args) {
        int[] arr={23, 45, 49, 56, 67, 78, 89, 93, 98};
        int target=78;
        System.out.print(binarySearch(arr , target));
    }

    static int binarySearch(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            //finding the middle element
            //int mid =(start+end)/2; --- might be possible that (start+end) exceeds the range of int in java , so better way is :
            int mid = start + (end - start)/2;
            if (target < arr[mid]){     
                end=mid-1;              //target is on left side of mid
            }
            else if (target > arr[mid]){
                start=mid+1;            //target is on right side of mid      
            }
            else{
                return mid;             //answer found , mid=target
            }
        }
        return -1;
    }
}

