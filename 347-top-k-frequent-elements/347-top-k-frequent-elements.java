import java.util.*;
import java.lang.*;
 
class Solution {
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
    
    
  
}