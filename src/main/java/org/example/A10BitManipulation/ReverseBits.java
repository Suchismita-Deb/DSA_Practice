package org.example.A10BitManipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;// Shifting n to the right and we are not shifting 1 to the left.
            res = res | (bit << (31 - i));
        }
        return res;
    }
}
