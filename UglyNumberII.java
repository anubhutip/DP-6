
/*
TC O(nlogn)
class Solution {
    public int nthUglyNumber(int n) {
        //might go out of range
        HashSet<Long> set=new HashSet<>();

        int[] arr=new int[]{2,3,5};
        PriorityQueue<Long> pq=new PriorityQueue<>();
        pq.add(1l);
        set.add(1l);
        int count=1;
        long currugly=1l;
        while(count<=n){
            currugly=pq.poll();
            count++;
            for(int prime:arr){
                long newugly=currugly*prime;
                if(!set.contains(newugly)){
                    pq.add(newugly);
                    set.add(newugly);
                }
            }
        }
        return (int)currugly;

    }
}*/

//TC: O(n)
//SC: O(n)
class UglyNumberII {
    public int nthUglyNumber(int n) {
        int p2=0;
        int p3=0;
        int p5=0;
        int n2=2;
        int n3=3;
        int n5=5;
        int[] arr=new int[n];
        arr[0]=1;
        for(int i=1;i<n;i++){
            int min= Math.min(n2,Math.min(n3,n5));
            arr[i]=min;
            if(n2==min){
                p2++;
                n2=2*arr[p2];
            }
            if(n3==min){
                p3++;;
                n3=3*arr[p3];
            }
            if(n5==min){
                p5++;;
                n5=5*arr[p5];
            }

        }
        return arr[n-1];
    }
}