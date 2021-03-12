// 237. Delete Node in a Linked List
// Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, 
// instead you will be given access to the node to be deleted directly.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// 876. Middle of the Linked List
// Given a non-empty, singly linked list with head node head, return a middle node of linked list.

// If there are two middle nodes, return the second middle node.

 

/** 
* Example 1:

* Input: [1,2,3,4,5]
* Output: Node 3 from this list (Serialization: [3,4,5])
* The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
* Note that we returned a ListNode object ans, such that:
* ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head; 
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }
}

// 242. Valid Anagram
// Given two strings s and t , write a function to determine if t is an anagram of s.

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true

import java.util.HashMap;
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (int i = 0; i < t.length(); i++) {
            if (charCount.containsKey(t.charAt(i))) {
                int count = charCount.get(t.charAt(i));
                charCount.put(t.charAt(i), count + 1);
            } else {
                charCount.put(t.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                int count = charCount.get(s.charAt(i));
                charCount.put(s.charAt(i), count - 1);
            } else {
                return false;
            }
        }
        for (int i : charCount.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;        
    }
}

// 278. First Bad Version
// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version // of your product fails the quality check. Since each version is developed based on the previous version, all the 
// versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the  
// following ones to be bad.

// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find
// the first bad version. You should minimize the number of calls to the API.

 
/**
 Example 1:

* Input: n = 5, bad = 4
* Output: 4
* Explanation:
* call isBadVersion(3) -> false
* call isBadVersion(5) -> true
* call isBadVersion(4) -> true
* Then 4 is the first bad version.

*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
