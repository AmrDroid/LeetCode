class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
              
        Car[] arr = new Car[speed.length];
        
        for (int i = 0; i < speed.length; i++){
            arr[i] = new Car(speed[i], position[i]);
        }
        
        Arrays.sort(arr, ((a,b)->b.p-a.p)); // Sort by position, largest position comes first.

        int cur = 0, ans = 1;
        
        
       Stack<Float>  stack = new Stack();
        
        for(Car c : arr)
        {

            stack.push(((float)(target-c.p)/c.s));
           
            int n= stack.size();
            if(n>=2 && stack.get(n-1)<=stack.get(n-2))
               stack.pop();
            

            
        }
        return stack.size();
        
        }

    private class Car{
        int s;
        int p;
        Car(int s, int p){
            this.s = s;
            this.p = p;
        }
    }
}