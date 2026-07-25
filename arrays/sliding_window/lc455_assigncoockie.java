class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int c=0;
        int k=s.length;
        int gl=g.length;
        int sl=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
       int i=0;int j=0;
       while(i<g.length&&j<s.length){
        if(s[j]>=g[i]){
            i++;
            c++;
        }
        j++;
       }
        return c;
    }
}

// Intuition

// The goal is to satisfy the maximum number of children.

// A child with smaller greed should get the smallest cookie that can satisfy them.
// If we give a large cookie to a less greedy child, we might not have a large enough cookie left for a greedier child.
// Therefore, we:
// Sort the greed array.
// Sort the cookie sizes.
// Always try to satisfy the current smallest greedy child with the current smallest available cookie.
// Why move j every time?

// There are two cases:

// Case 1: Cookie is big enough

// Child = 2
// Cookie = 3

// Assign the cookie.

// Move to:

// Next child (i++)
// Next cookie (j++)

// Case 2: Cookie is too small

// Child = 4
// Cookie = 2

// This cookie cannot satisfy the current child.

// Since the children are sorted, the next children will have greed ≥ 4.

// So cookie 2 cannot satisfy any remaining child.

// Discard it and try the next cookie.


// Arrays.sort(g) → O(n log n)
// Arrays.sort(s) → O(m log m)

// Two-pointer traversal:

// O(n + m)

// Overall:

// O(n log n + m log m)

// If n ≈ m, it is commonly written as:

// O(n log n)