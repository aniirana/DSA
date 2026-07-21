class NumArray {
    int n;
    int[] st;
    public NumArray(int[] nums) {
        n=nums.length;
        st=new int[4*n];
        build(nums,0,0,n-1);
    }

    public void build(int[] nums,int i,int l,int r){
        if(l==r){
            st[i]=nums[l];
            return;
        }
        int mid=l+(r-l)/2; 
        build(nums,2*i+1,l,mid);
        build(nums,2*i+2,mid+1,r);

        st[i]=st[2*i+1]+st[2*i+2];
    }
    
    public void update(int index, int val) {
        updatesegtree(index,val,0,0,n-1);
    }

    public void updatesegtree(int idx,int val,int i,int l,int r){

        if(l==r){
            st[i]=val;
            return; 
        }
        int mid=l+(r-l)/2;

        if(idx<=mid){
            updatesegtree(idx,val,2*i+1,l,mid);
        }else{
            updatesegtree(idx,val,2*i+2,mid+1,r);
        }

        st[i]=st[2*i+1]+st[2*i+2];
    }
    
    public int sumRange(int left, int right) {
        return sum( left, right,0,0,n-1);
    }

    public int sum(int s,int e,int i,int l,int r){
        if(l>e || r<s){
            return 0;
        }
        else if(l>=s && r<=e){
            return st[i];
        }

        int mid=l+(r-l)/2;

        return sum(s,e,2*i+1,l,mid)+sum(s,e,2*i+2,mid+1,r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */