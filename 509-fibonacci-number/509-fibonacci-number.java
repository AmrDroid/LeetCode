class Solution {
    public int fib(int n) {
//         int a=0;
//         int b=1;
//         int c=0;
        
//         for(int i=2;i<=n;i++)
//         {
//          c = a + b;
//          a = b;
//          b = c;
//         }
//         return c;
    
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n)/ Math.sqrt(5));
    }
}