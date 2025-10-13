class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            // Compare sorted versions of current and previous word
            if (!isAnagram(words[i], words[i - 1])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) 
            return false;
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        return Arrays.equals(arrA, arrB);
    }
}