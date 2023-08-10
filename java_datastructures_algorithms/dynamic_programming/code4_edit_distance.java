class Solution {
	// problem statement and judging: https://leetcode.com/problems/edit-distance
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();

        if(n1==0)
            return n2;
        if(n2==0)
            return n1;

        int dp[][]=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if( i==0 )
					dp[i][j] = j;
                else if( j==0 )
					dp[i][j]=i;
                else if( word1.charAt(i-1) == word2.charAt(j-1) )
					dp[i][j] = dp[i-1][j-1];
                else
					dp[i][j] = Math.min( dp[i-1][j-1], Math.min( dp[i-1][j],dp[i][j-1] ) ) + 1;
            }
        }
        return dp[n1][n2];
    }
}