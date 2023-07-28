class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
          
        int index = 0;
        List<String> output = new ArrayList<String>();

        
        while(index < words.length){
            int word_no = 0;
            int charUsed = 0;
            int prevIndex = index;
            while(index < words.length && words[index].length() + word_no + charUsed <= maxWidth){
                charUsed += words[index].length();
                word_no++;
                index++;
            }

            if(index == words.length){
                String out = "";
                for(int i = prevIndex ; i < index ; i++){
                    if(i!=prevIndex){
                        out += " ";
                    }
                    out += words[i];
                }
                for(int j = 0; j < maxWidth - (charUsed + word_no - 1); j++){
                    out += " ";
                }
                output.add(out);
            }
            else{
                int remSpace = maxWidth - charUsed;
                int space_uniform;
                int space_extra;
                
                if(word_no > 1 ){
                    
                    space_uniform = remSpace / (word_no - 1);
                    space_extra = remSpace % (word_no - 1);
                }
                else{
                    space_uniform = remSpace;
                    space_extra = 0;
                }

                
                String space_string = "";
                for(int i = 0; i < space_uniform ; i++){
                    space_string += " ";
                }
                String out = "";
                for(int i = prevIndex ; i < index ; i++){
                    if(i!=prevIndex){
                        if(i-prevIndex - 1 < space_extra){
                            out += " ";
                        }
                        out += space_string;
                    }
                    out += words[i];
                }

                if(word_no - 1 == 0){
                    out += space_string;
                }
                output.add(out);

            }

        

        }


        return output;
    }
}