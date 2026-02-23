import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        
        // If impossible due to length constraint
        if (n < (1 << k) + k - 1) return false;
        
        Set<Integer> seen = new HashSet<>();
        int num = 0;
        
        for (int i = 0; i < n; i++) {
            // Left shift and add current bit
            num = ((num << 1) & ((1 << k) - 1)) | (s.charAt(i) - '0');
            
            if (i >= k - 1) {
                seen.add(num);
                if (seen.size() == (1 << k)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}