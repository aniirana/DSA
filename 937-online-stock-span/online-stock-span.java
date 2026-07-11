class StockSpanner {

     Stack<Integer> st;
    ArrayList<Integer> prices;
    int day;

    public StockSpanner() {
        st=new Stack<>();
        prices = new ArrayList<>();
        day=0;
    }
    
    public int next(int price) {
        prices.add(price);
        while(!st.isEmpty() && prices.get(st.peek())<=price){
            st.pop();
        }
        int span=0;
        if(st.isEmpty()){
            span=day+1;
        }
        else{
            span = day-st.peek();
            
            
        }

        st.push(day);
        day+=1;
        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */