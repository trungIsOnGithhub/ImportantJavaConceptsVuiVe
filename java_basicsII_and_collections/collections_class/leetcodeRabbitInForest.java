class Solution {
    public int numRabbits(int[] answers) {
        int result = 0;
        int[] rabbit = new int[1001];
        for (int ans : answers) {
            rabbit[ans] += 1;
        }

        for (int i=1; i<=1000; ++i) {
            int vui = i+1;
            int nv = rabbit[i]/vui;
            // System.out.println(nv);
            int dv = rabbit[i]%vui;
            result += vui * nv;
            if(dv > 0) result += vui;
        }

        return result + rabbit[0];
    }
}

public class leetcodeRabbitInForest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(
            solution.numRabbits(new int[] {0,0,1,1,1,4,0,0});
        );
    }
}