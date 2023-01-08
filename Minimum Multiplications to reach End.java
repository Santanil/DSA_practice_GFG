
https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

TC: O( 10^5 *N)
SC: O(10^5)

class Pair{
    int value;
    int steps;
    Pair(int value,int steps){
        this.value=value;
        this.steps=steps;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        if(start==end)
            return 0;
        int mod = 100000;
        Queue<Pair> q=new LinkedList<>();
        int[] stepsArr=new int[100000];
        for(int i=0;i<100000;i++)
            stepsArr[i]=(int)(1e9);
        
        q.add(new Pair(start,0));
        stepsArr[start]=0;
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int val=p.value;
            int s=p.steps;
            
            for(int x: arr){
                int res=(int)((x*val)%mod);
                if((s+1)<stepsArr[res]){
                    stepsArr[res]=s+1;
                    if(res==end)
                        return s+1;
                    q.add(new Pair(res,s+1));
                }
            }
        }
        return -1;
    }
}
