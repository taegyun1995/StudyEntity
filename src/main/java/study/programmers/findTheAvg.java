class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        
        for(int arrs : arr) {
            sum += arrs;
        }
        
        return sum / arr.length;
    }
}
