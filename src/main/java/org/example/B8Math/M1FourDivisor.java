package org.example.B8Math;

// https://leetcode.com/problems/four-divisors/description

// Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.
// Input: nums = [21,4,7]
// Output: 32
// 21 has 4 divisors: 1, 3, 7, 21
// 4 has 3 divisors: 1, 2, 4
// 7 has 2 divisors: 1, 7
// The answer is the sum of divisors of 21 only.
// To see the factor of a number it can be till i*i<=num meaning sqrt(n).

// Fact If one number divides another exactly, then both the divisor and the quotient are factors of the original number. 3 si a factor of 12 sp 12/3 = 4 is also a factor of 12.

public class M1FourDivisor {
    static int valid(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                sum += i;
                if (num / i != i) { // 3 is the factor meaning 12/3 = 4 is also the factor.
                    count++; // The number is perfect square say 36 then 6 is a factor and 36/6=6 is same number. The number id calculated twice so to verify if the number is not same then add.
                    sum += num / i;
                }
            }
        }
        return count == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += valid(nums[i]);
        }
        return sum;
    }
}
