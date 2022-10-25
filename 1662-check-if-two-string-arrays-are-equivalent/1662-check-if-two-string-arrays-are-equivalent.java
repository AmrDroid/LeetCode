class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a="";
        for(String c:word1)
            a+=c;
        
                String b="";
        for(String c:word2)
            b+=c;

        System.out.println(a+"  "+b);
        return a.equals(b);
    }
}