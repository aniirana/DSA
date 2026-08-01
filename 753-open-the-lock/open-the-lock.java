class Solution {
    int min=Integer.MAX_VALUE;
    public int openLock(String[] deadends, String target) {
        HashSet<String> vis=new HashSet<>();
        HashSet<String> lock=new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            lock.add(deadends[i]);
        }

        Queue<String> q=new LinkedList<>();
        q.add("0000");
        vis.add("0000");

        bfs(q,vis,lock,target);
        return min==Integer.MAX_VALUE?-1:min;
        
    }

    public void bfs(Queue<String> q,HashSet<String> vis,HashSet<String> lock,String target){
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();

            while(size-- >0){
                String curr=q.poll();

                if(curr.equals(target)) 
                    min= Math.min(steps,min); 

                if(lock.contains(curr)){
                    continue;
                }          


                //bfs      
                char[] arr = curr.toCharArray();
                for(int i=0;i<4;i++){
                    char orig=arr[i];

                    if(arr[i]=='9'){
                        arr[i]='0';
                    }

                    else{
                        arr[i]++;
                    }

                    String next=new String(arr);
                    if(!vis.contains(next) && !lock.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                    arr[i]=orig;


                    if(arr[i]=='0'){
                        arr[i]='9';
                    }else{
                        arr[i]--;
                    }

                    next=new String(arr);

                    if(!vis.contains(next) && !lock.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                    arr[i]=orig;

                } 
            }

            steps++;
        }
    }
}