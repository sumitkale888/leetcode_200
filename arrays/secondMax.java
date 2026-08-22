public class secondMax {
    
}
// For an array, you can find the second maximum (second largest) without sorting:

int[] nums = {10, 5, 20, 8, 15};

int max = Integer.MIN_VALUE;
int secondMax = Integer.MIN_VALUE;

for (int num : nums) {
    if (num > max) {
        secondMax = max;
        max = num;
    } else if (num > secondMax && num != max) {
        secondMax = num;
    }
}

// System.out.println(secondMax);

// Output:

// 15
// How it works

// For every number:

// if (num > max)
// Current max becomes secondMax
// Current num becomes max
// else if (num > secondMax && num != max)
// Update secondMax
// num != max ensures we find the second distinct maximum

// Time Complexity: O(n)
// Space Complexity: O(1)