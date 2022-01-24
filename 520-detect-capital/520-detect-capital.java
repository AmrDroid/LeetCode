class Solution {
    public boolean detectCapitalUse(String word) {

        
        return word.matches("[a-z]+|[A-Z][a-z]*|[A-Z]+");
        
//         boolean flag=true;
//         for(Character c : word.toCharArray())
//             if(!Character.isUpperCase(c))
//               flag=  false;
//         if(flag)
//             return true;
                
        
//         flag=true;
//         for(Character c : word.toCharArray())
//             if(Character.isUpperCase(c))
//                 flag= false;
//         if(flag)
//             return true;
                
        
//         flag=true;
//         if(!Character.isUpperCase(word.charAt(0)))
//             flag=false;
//         for(int i=1;i<word.length();i++)
//             if(Character.isUpperCase(word.charAt(i)))
//                flag= false;
//      return flag;         
    }
}