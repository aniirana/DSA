class Solution {
    public int totalFruit(int[] fruits) {
        // brute force 
    //    int ans=0;
    //    for(int i=0;i<fruits.length;i++){
    //         HashSet<Integer> set=new HashSet<>();

    //         for(int j=i;j<fruits.length;j++){
    //             set.add(fruits[j]);
    //             if(set.size()>2){
    //                 break;
    //             }
    //             ans=Math.max(ans,j-i+1);

    //         }
        
    //    }
    //    return ans;

    HashMap<Integer,Integer> map=new HashMap<>();
    int left=0;
    int max=0;
    int n=fruits.length;

    for(int right=0;right<n;right++){
        map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

        while(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);

            if(map.get(fruits[left])==0){
                map.remove(fruits[left]);
            }
            left++;
        }
        max=Math.max(max,right-left+1);
    }

    return max;


    }
}