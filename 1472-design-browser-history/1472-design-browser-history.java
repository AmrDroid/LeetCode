class BrowserHistory {

  
    int cur = 0;
    ArrayList<String> arr = new ArrayList<String>();

    public BrowserHistory(String homepage) {
        arr.add(homepage);
        cur = arr.size()-1;
    }
    
    public void visit(String url) {
        cur++;
        if(cur<arr.size()){
            arr.set(cur,url);
            while(arr.size()>cur+1){
                arr.remove(cur+1);
            }
        }else{
            arr.add(url);
        }
    }
    
    public String back(int steps) {
        cur = Math.max(cur-steps,0);
        return arr.get(cur);
    }
    
    public String forward(int steps) {
        cur = Math.min(cur+steps,arr.size()-1);
        return arr.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */