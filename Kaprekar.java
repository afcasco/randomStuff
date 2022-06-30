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
	        System.out.println("kaprepan reps method: "+kaprekanReps(num));
        } else {
            System.out.println("All digits are the same... can't kaprekan");
        }
    }

    int kaprekanReps(int num) {
        int n = 0;
        while (num != KAPREKAN_NUMBER) {
            num = diffBigSmall(ascendingOrder(convertToArray(num)), descendingOrder(convertToArray(num)));
            n++;
        }
        return n;
    }

    int recursive(int num){
    	if(num!=KAPREKAN_NUMBER) {
    		n++;
    		return recursive(diffBigSmall(ascendingOrder(convertToArray(num)), descendingOrder(convertToArray(num))));
    	}
    	else return n;
    }

    boolean sameDigits(int num){
    	String s = ((Integer)num).toString();
	    int n = s.length();
	    for (int i = 1; i < n; i++)
	        if (s.charAt(i) != s.charAt(0))
	            return false;
	    return true;
	    }

    int[] convertToArray(int num) {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(nums);
        return nums;
    }

    int ascendingOrder(int nums[]) {

        int num = 0;
        int factor = 1000;
        for (int i = 0; i < 4; i++) {
            num = num + nums[i] * factor;
            factor = factor / 10;
        }
        return num;
    }

    int descendingOrder(int[] nums) {
        int reversed = 0;
        int factor = 1;
        for (int i = 0; i < 4; i++) {
            reversed = reversed + nums[i] * factor;
            factor = factor * 10;
        }
        return reversed;
    }

    int diffBigSmall(int x, int y) {
        return x > y ? x - y : y - x;
    }
}
