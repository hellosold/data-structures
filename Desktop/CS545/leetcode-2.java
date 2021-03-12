/**
 *  1528. Shuffle String
 *  Given a string s and an integer array indices of the same length.
 *
 *  The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 *  Return the shuffled string.
 *
 *  Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 */

class Solution {
    public String restoreString(String s, int[] indices) {
        
        if (s.length() != indices.length) {
            return "";
        }
    
        char[] result = new char[indices.length];
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }
        
        // using StringBuilder to convert a sequence of char into a string
        StringBuilder sb = new StringBuilder();
        for(char c : result){
            sb.append(c);
        }
        return sb.toString();
    }

}

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 */

 class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
            
            i--;
            j--;
            
        }
        
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}