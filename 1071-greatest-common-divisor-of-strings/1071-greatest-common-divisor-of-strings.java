class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
     
        int n1 = str1.length();
        int n2 = str2.length();
        int n3 = gcd(n1, n2);
        
        
    
       //if on adding resultant string are not equals
       if (!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        //returning the gcd in string
         return str1.substring(0, n3);
    }   
    
    //calculating the gcd
        public static int gcd(int n1, int n2){
            while(n1%n2!=0){
                int rem = n1%n2;
                n1 = n2;
                n2 = rem;
            }
            return n2;
        }
}