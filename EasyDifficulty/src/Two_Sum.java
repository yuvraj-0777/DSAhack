/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

EXAMPLE :
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

public class Two_Sum {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] + array[j] == target) {
                    System.out.println(j + "," + i);
                    break;
                }
            }
        }
    }
}
