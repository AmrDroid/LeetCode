class Solution {
    public String modifyString(String s) {
        
        int n = s.length();
        StringBuilder sb=new StringBuilder();
            
        boolean choosen[]=new boolean[26];
        char arr[]=s.toCharArray();
        for(int i=0;i<n;i++)
        {
            Arrays.fill(choosen,false);
           
            if(arr[i]=='?')
            {
              if(i-1>=0)
              {
              System.out.println(arr[i-1]+"   "+(arr[i-1]-'a'));
                    choosen[arr[i-1]-'a']=true;
              }
              if(i+1 < n && arr[i+1] != '?')        
                  choosen[arr[i+1]-'a'] = true;                
              
                for(int j = 0; j < 26; ++j){
                    if(!choosen[j]){    
                        arr[i] = (char)('a'+j);
                        break;
                    }
                }  
            }
        }
        
        
       return sb.append(arr).toString();
    }
}