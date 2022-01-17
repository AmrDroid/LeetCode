class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[]=s.split(" ");
        
        Map<Character ,String> map=new HashMap();
        
        if(arr.length!=pattern.length())
            return false;
        
        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsValue(arr[i]))
                map.put(pattern.charAt(i),arr[i]);
        }
    
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(map.get(pattern.charAt(i))+ "  "+arr[i]);
            
            if(!map.containsKey(pattern.charAt(i))  ||  !map.get(pattern.charAt(i)).equals(arr[i]))
                return false;
        }
 return true;
    }
}