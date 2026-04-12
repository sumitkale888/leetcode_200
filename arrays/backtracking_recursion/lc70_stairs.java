class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

}

// Because of
// the rules
// of the
// problem.

// In Climbing Stairs,
// you are
// allowed to
// take only:

// 1 step 2 steps🧠
// CORE REASON

// To reach
// step i, your
// last move
// must be either:

// 1 ️⃣
// From i-1
// You were
// at step i-1 Took 1 step 2 ️⃣
// From i-2
// You were
// at step i-2 Took 2 steps

// 👉
// There is
// no other possibility

// 🔁That’
// s why:

// 𝑑𝑝[𝑖]=𝑑𝑝[𝑖−1]+𝑑𝑝[𝑖−2]dp[i]=dp[i−1]+dp[i−2
// ]

// You are standing on step i.

// Now ask:
“From where could I have come in the last move?”

// Only 2 options:

// from (i-1) → took 1 step
// from (i-2) → took 2 steps

// 👉 So total ways =
// ways to reach (i-1) + ways to reach (i-2)