package org.example.Premium.Amazon.AmazonExplore.Design;

import java.util.LinkedHashMap;
import java.util.TreeMap;

// https://leetcode.com/problems/min-stack/

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class -
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

public class MinStack {

        LinkedHashMap<Integer, Integer> lmp;
        TreeMap<Integer, Integer> tmp;
        int pos;

        public MinStack() {
            lmp = new LinkedHashMap<>();
            tmp = new TreeMap<>();
            pos = 0;
        }

        public void push(int val) {
            lmp.put(pos, val);
            tmp.put(val, tmp.getOrDefault(val, 0) + 1);
            pos++;
        }

        public void pop() {
            if (pos == 0)
                return;
            Integer val = lmp.get(pos - 1); // lmp.put(val,pos); cannot be done as we cant get the last element in the map with the size.Map need key and pos can be the key.
            if (val == null)
                return;
            // tmp.remove(val); // remove the value. // It will not work as map does not contain duplicate for key. When we remove the element in the map then the entire detail of the element is removed and in case if it the min value then will not get the track. (5,1) and (5,3) the value will be (5,3) and it will be removed so next time say min is 5 will not get any 5. So we need to store the freq in the treemap.
            lmp.remove(pos - 1); // remove the key of the lmp which pos.
            int freq = tmp.get(val);
            if (freq == 1) {
                tmp.remove(val);
            } else {
                tmp.put(val, freq - 1);
            }
            pos--;
        }

        public int top() {
            return lmp.get(pos - 1);
        }

        public int getMin() {
            if (tmp.isEmpty())
                return Integer.MAX_VALUE;
            return tmp.firstKey();
        }
    }
// I did using LinkedHashMap to track the position and TreeMap to sort based on the key to get the min.
