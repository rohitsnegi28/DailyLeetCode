import java.util.Arrays;
import java.util.Scanner;

class Solution {
    /*
     * Problem:
     * You are given a positive integer array `skill` of even length `n` where `skill[i]`
     * denotes the skill of the ith player. You need to divide the players into `n / 2`
     * teams of size 2 such that the total skill of each team is equal.
     * 
     * The chemistry of a team is defined as the product of the skills of the two players
     * on that team. Return the sum of the chemistry of all the teams, or return -1 if 
     * there is no way to divide the players into teams such that the total skill of each
     * team is equal.
     * 
     * Example 1:
     * Input: skill = [3,2,5,1,3,4]
     * Output: 22
     * Explanation:
     * Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team
     * has a total skill of 6. The sum of the chemistry of all the teams is:
     * 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
     * 
     * Example 2:
     * Input: skill = [3,4]
     * Output: 12
     * Explanation: The two players form a team with a total skill of 7. The chemistry 
     * of the team is 3 * 4 = 12.
     * 
     * Example 3:
     * Input: skill = [1,1,2,3]
     * Output: -1
     * Explanation: There is no way to divide the players into teams such that the total 
     * skill of each team is equal.
     * 
     * Constraints:
     * - The length of the array `skill` is even.
     * - The array contains at least 2 players and at most 100,000 players.
     * - The skill of each player is between 1 and 1000.
     */

    // Method to calculate the sum of chemistry of all teams, or return -1 if the teams can't be formed equally
    public long dividePlayers(int[] skill) {
        // Sort the array to facilitate pairing the lowest with the highest skill
        Arrays.sort(skill);

        // Initialize variables
        int n = skill.length; // The length of the array
        long totalChemistry = 0; // To store the sum of the chemistry of all teams
        int targetSkill = skill[0] + skill[n - 1]; // The target total skill of each team (lowest + highest)

        // Iterate over the array to form teams
        for (int i = 0; i < n / 2; i++) {
            // Check if the current pair has the same total skill as the target
            if (skill[i] + skill[n - i - 1] != targetSkill) {
                return -1; // Return -1 if any pair doesn't meet the total skill requirement
            }

            // Calculate chemistry for the current team and add it to the total chemistry
            totalChemistry += (long) skill[i] * skill[n - i - 1];
        }

        // Return the total chemistry of all teams
        return totalChemistry;
    }

    public static void main(String[] args) {
        // Scanner is used to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input the size of the array
        System.out.println("Enter the size of the skill array (even number):");
        int n = scanner.nextInt();  // Take the size of the skill array

        // Initialize the skill array of integers with size n
        int[] skill = new int[n];

        // Prompt the user to input the skill levels of the players
        System.out.println("Enter the skill levels of the players:");
        for (int i = 0; i < n; i++) {
            skill[i] = scanner.nextInt();  // Take the skill levels one by one
        }

        // Create an object of the Solution class to call the dividePlayers method
        Solution solution = new Solution();

        // Call the dividePlayers method and store the result
        long result = solution.dividePlayers(skill);

        // Output the result: the sum of the chemistry of all teams, or -1 if teams can't be formed equally
        System.out.println(result);  // Print the result
    }
}
