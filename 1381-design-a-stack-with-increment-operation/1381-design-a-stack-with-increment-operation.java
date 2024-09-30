class CustomStack {
    private Stack<Integer> stk;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.stk=new Stack<>();
        this.maxSize=maxSize;
        
    }
    
    public void push(int x) {
        if(stk.size()<maxSize){
            stk.push(x);
        }
        
    }
    
    public int pop() {
        if(!stk.isEmpty()){
        return stk.pop();
            
        }
        
        return -1;
        
    }
    
    public void increment(int k, int val) {
        int limit=Math.min(k,stk.size());
        for(int i=0;i<limit;i++){
            stk.set(i,stk.get(i)+val);
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */