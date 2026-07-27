class Solution {
    class Pair{
        String word;
        int level;
        Pair(String s,int l){
            this.word=s;
            this.level=l;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();

        for(String s: wordList){
            set.add(s);

        }

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<Pair> q=new LinkedList<>();

        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair wrd=q.poll();
            String wd=wrd.word;
            int lev=wrd.level;

            if(wd.equals(endWord)){
                return lev;
            }

            char[] arr=wd.toCharArray();

            for(int i=0;i<arr.length;i++){
                char orig=arr[i];

                for(char ch='a';ch<='z';ch++){
                    if(ch==orig) continue;
                    
                    arr[i]=ch;
                    String newWord=new String(arr);

                    if(set.contains(newWord)){
                        q.offer(new Pair(newWord,lev+1));
                        set.remove(newWord);
                    }
                }

                arr[i]=orig;
            }


            
        }
        return 0;
    }
}