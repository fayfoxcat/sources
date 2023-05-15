package JavaBase.Search;

/**
 * 二分法（折半）查找
 */
public class DichotomySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,9,14,36,47,68,78,99};
        int value = 0;
        System.out.println(dichotomy(array, value));
    }

    private static int dichotomy(int[] array ,int value){
        int min = 0;
        int max = array.length-1;
        while (min<=max){
            int mid = (max + min)/2;
            if (value>array[mid]){
                min = mid+1;
            }else if(value<array[mid]){
                max = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
