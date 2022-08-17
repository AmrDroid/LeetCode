class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String [] encode= new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set<String> set=new HashSet();
        for(String word : words)
        {
            String code="";
            for(int i=0;i<word.length();i++)
            {
                int ind=word.charAt(i);
             System.out.println(ind);
                code+= encode[ind-97];                
            }
            set.add(code);
        }
        
        return set.size();
    }
}