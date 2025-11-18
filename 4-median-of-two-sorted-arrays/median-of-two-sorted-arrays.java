class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int n=n1+n2;

        int[] arr=new int[n];


        int i=0;

        for (int a = 0; a < n1; a++) {
            arr[i++] = nums1[a];
        }


        for (int b = 0; b < n2; b++) {
            arr[i++] = nums2[b];
        }


        Arrays.sort(arr);

        

        if(n%2==1){
            return arr[n/2];
        }
        else{
            return (arr[n/2]+arr[n/2 - 1]) / 2.0;
        }

        


        

        
    }
}