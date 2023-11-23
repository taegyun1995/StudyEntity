class Solution {
    public double findAvg(int[] arr) {
        double sum = 0;
        
        for(int arrs : arr) {
            sum += arrs;
        }
        
        return sum / arr.length;
    }
}
