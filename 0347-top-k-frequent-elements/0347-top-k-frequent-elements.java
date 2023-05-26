import java.util.*;
import java.lang.*;
 
class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
     
        Map<Integer, Integer> hm = new HashMap<>();
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        int[] res = new int[k];
        
        int ind = 0;

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int key : hm.keySet()) {
            
            int frequency = hm.get(key);
            
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            
            bucket[frequency].add(key);
            
        }

		// here we are running loop from behind, 
		//bcz we have to return elements with high frequency first
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for (int i = 0; i < bucket[pos].size() && ind < k; i++) {
                    res[ind++] = bucket[pos].get(i);
                }
            }
        }
        return res;
    }
 /*
public    int[] topKFrequent(int []nums, int k) {
    
    Map<Integer,Integer> map=new HashMap();
        
        for(int i : nums)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
    
           Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue(k, new Comparator<Map.Entry<Integer, Integer>>(){
           
               @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b)
            {
                return Integer.compare(a.getValue(),b.getValue());
            }
                
        });

        
        
        int arr[]=new int[k];
    

           for(Map.Entry<Integer, Integer> entry : map.entrySet())
          {
            if(heap.size()<k)
                heap.offer(entry);
            else if(heap.peek().getValue()<entry.getValue())
            {
                heap.poll();
                heap.offer(entry);
            }
                
        }
        int i=0;
          for(Map.Entry<Integer, Integer> entry : heap)
        {
            arr[i++]=entry.getKey();
        }
        
        
        
        return arr;
       
    }
    
    */

    
    /*
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> m = new HashMap();
        
        for(int i : nums)
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }
        
        m = sortByValue(m);
        
        int res[]=new int[k];
        
        int i=0;
        for(int n : m.keySet())
        {
            if(i<k)
                res[i++]=n;
        }
     
        return res;
    }
    
    
     public static HashMap<Integer, Integer>
    sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list
            = new LinkedList<Map.Entry<Integer, Integer> >(
                hm.entrySet());
 
        // Sort the list using lambda expression
        Collections.sort(
            list,
            (i1,
             i2) -> i2.getValue().compareTo(i1.getValue()));
 
        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp
            = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
    */
  
}