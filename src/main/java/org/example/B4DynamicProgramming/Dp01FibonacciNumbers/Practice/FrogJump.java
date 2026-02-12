package org.example.B4DynamicProgramming.Dp01FibonacciNumbers.Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/frog-jump/description/


/*
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.


Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

*/

public class FrogJump {
    class Solution {
        Set<Integer> stoneSet = new HashSet<>();
        Map<String, Boolean> memo = new HashMap<>();

        public boolean canCross(int[] stones) {
            for (int stone : stones) {
                stoneSet.add(stone);
            }
            return dfs(stones[stones.length - 1], 1, 1);
        }

        boolean dfs(int target, int pos, int jump) {
            String key = pos + "," + jump;
            if (memo.containsKey(key)) return memo.get(key);
            if (!stoneSet.contains(pos)) return false;
            if (pos == target) return true;

            for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                if (nextJump > 0 && dfs(target, pos + nextJump, nextJump)) {
                    memo.put(key, true);
                    return true;
                }
            }

            memo.put(key, false);
            return false;
        }
    }

}


/*
Thinking in the way to Jump Game. Here the issue was the loop not consider the cases.
class Solution {
    int n;
    public boolean canCross(int[] stones) {

        n = stones.length;
        if(stones[1]!=1) return false;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // start from 0 and can always go to 1 using 1 unit.
        return stepPossible(stones, dp, 1, 1);
    }
    boolean stepPossible(int stones[], int dp[], int step, int i){
        if(i==n-1){
            return true;
        }
        if(dp[i] !=-1) return dp[i]==1?true:false;
        int k = step;
        for(int pos = i; i+k<=stones[i+1]; pos++)
        stepPossible(stones, dp, k,pos);
        for(int pos = i; i+k+1<=stones[i+1]; pos++)
        stepPossible(stones, dp, k+1, pos);
        for(int pos = i; i+k-1<=stones[i+1]; pos++)
        stepPossible(stones, dp, k-1, pos);
        dp[i] = 0;
        return false;
    }
}

The k, k+1 and k-1 Always have to get the value in the array and the value should be present in array. So we can use map.
 */