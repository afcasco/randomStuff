import java.util.Scanner;
import java.util.Arrays;
public class Kaprekar {

	static int n;
	private static final int KAPREKAN_NUMBER = 6174;

    public static void main(String[] args) {
        Kaprekar kaprekar = new Kaprekar();
        kaprekar.start();
    }

    void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entra un numero de 4 digits");
        int num = input.nextInt();
   
        if (!sameDigits(num)) {
            n=0;
	        System.out.println("recursive method "+ recursive(num));
	        System.out.println("kaprepar reps method: "+kaprekanReps(num));
        } else {
            System.out.println("All digits are the same... can't kaprekar this");
        }
    }

    // returns number of reps to reach kaprekar number
    int kaprekanReps(int num) {
        int n = 0;
        while (num != KAPREKAN_NUMBER) {
            num = diffBigSmall(ascendingOrder(convertToArray(num)), descendingOrder(convertToArray(num)));
            n++;
        }
        return n;
    }

    // same askaprekanReps but using recursion
    int recursive(int num){
    	if(num!=KAPREKAN_NUMBER) {
    		n++;
    		return recursive(diffBigSmall(ascendingOrder(convertToArray(num)), descendingOrder(convertToArray(num))));
    	}
    	else return n;
    }

    //check if all digits are the same
    boolean sameDigits(int num){
    	String s = ((Integer)num).toString();
	    for (int i = 1; i < s.length(); i++){
	        if (s.charAt(i) != s.charAt(0)){
	            return false;
	        }
	    }
	    return true;
	    }

	// convert number to array of ints to use Arrays.sort()
    int[] convertToArray(int num) {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(nums);
        return nums;
    }

    // convert arra to int (already sorted in covertToArray)
    int ascendingOrder(int nums[]) {

        int num = 0;
        int factor = 1000;
        for (int i = 0; i < 4; i++) {
            num = num + nums[i] * factor;
            factor = factor / 10;
        }
        return num;
    }

    // descending sort and convert to int
    int descendingOrder(int[] nums) {
        int reversed = 0;
        int factor = 1;
        for (int i = 0; i < 4; i++) {
            reversed = reversed + nums[i] * factor;
            factor = factor * 10;
        }
        return reversed;
    }

    // substracts smaller number from bigges number
    int diffBigSmall(int x, int y) {
        return x > y ? x - y : y - x;
    }
}
