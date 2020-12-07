import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int[] condensed = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {

            for (int k = 0; k < nums.length - 1; k++) {
                condensed[k] = nums[k] + nums[k + 1];
            }
            for (int j = 0; j < condensed.length  ; j++) {
                nums[j] = condensed[j];
            }
        }
        System.out.println(nums[0]);
    }
}
