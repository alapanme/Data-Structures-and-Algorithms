//https://leetcode.com/problems/majority-element/

package com.alapan.dsalgo.leetcode;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    public int bruteForceSolution(int[] nums) { //Time Complexity is O(n^2). Space complexity is O(1)
        if (nums.length == 1) {
            return nums[0];
        } else {
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count += 1;
                    }
                }
                if (count > nums.length / 2) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //---------------------------//

    public HashMap<Integer, Integer> countAndNums(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!counts.containsKey(nums[i])) {
                counts.put(nums[i], 1);
            } else {
                counts.put(nums[i], counts.get(nums[i]) + 1);
            }
        }
        return counts;
    }

    public int optimizedSolution(int[] nums) { //Time Complexity is O(n). Space Complexity is O(n)
        HashMap<Integer, Integer> counts = countAndNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    //---------------------------//

    public int optimizedBoyerMooreVotingAlgo(int[] nums) { //Time Complexity is O(n). Space Complexity is O(1)
        /*
         * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
         * Here, the 7 at index 0 is selected to be the first candidate for majority element.
         * count will eventually reach 0 after index 5 is processed, so the 5 at index 6 will be the next candidate.
         * In this case, 7 is the true majority element, so by disregarding this prefix, we are ignoring an equal number of majority and minority
         * elements - therefore, 7 will still be the majority element in the suffix formed by throwing away the first prefix.
         *
         * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 5, 5, 5, 5]
         * Now, the majority element is 5 (we changed the last run of the array from 7s to 5s), but our first candidate is still 7.
         * In this case, our candidate is not the true majority element, but we still cannot discard more majority elements than
         * minority elements (this would imply that count could reach -1 before we reassign candidate, which is obviously false).
         * Therefore, given that it is impossible (in both cases) to discard more majority elements than minority elements,
         * we are safe in discarding the prefix and attempting to recursively solve the majority element problem for the suffix.
         * Eventually, a suffix will be found for which count does not hit 0, and the majority element of that suffix will
         * necessarily be the same as the majority element of the overall array.
         */

        int majorityElement = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majorityElement = nums[i];
            }
            if (majorityElement != nums[i]) {
                count = count - 1;
            } else {
                count++;
            }
        }
        return majorityElement;
    }


    public static void main(String[] args) {
        majorityElement obj = new majorityElement();
        System.out.println(obj.bruteForceSolution(new int[]{8, 8, 7, 7, 7}));
        System.out.println(obj.optimizedSolution(new int[]{8, 8, 7, 7, 7}));
        System.out.println(obj.optimizedBoyerMooreVotingAlgo(new int[]{3, 3, 4}));
    }
}
