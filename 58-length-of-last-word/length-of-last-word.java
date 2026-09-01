class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s+");

        String word=arr[arr.length-1];
        return word.length();

    }
}