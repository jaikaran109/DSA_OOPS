public class FenwickTree {
    private int[] tree;
    private int n;
    
    // Constructor
    public FenwickTree(int size) {
        n = size;
        tree = new int[n + 1]; // 1-indexed
    }
    
    // Constructor with array
    public FenwickTree(int[] arr) {
        n = arr.length;
        tree = new int[n + 1];
        
        // Build tree
        for (int i = 0; i < n; i++) {
            update(i, arr[i]);
        }
    }
    
    // Update value at index (add delta)
    public void update(int index, int delta) {
        index++; // Convert to 1-indexed
        
        while (index <= n) {
            tree[index] += delta;
            index += index & (-index); // Add last set bit
        }
    }
    
    // Get prefix sum from 0 to index
    public int query(int index) {
        index++; // Convert to 1-indexed
        int sum = 0;
        
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index); // Remove last set bit
        }
        
        return sum;
    }
    
    // Get range sum from left to right
    public int rangeQuery(int left, int right) {
        if (left == 0) {
            return query(right);
        }
        return query(right) - query(left - 1);
    }
    
    // Point update (set value at index)
    public void pointUpdate(int index, int value, int[] arr) {
        int delta = value - arr[index];
        arr[index] = value;
        update(index, delta);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        FenwickTree ft = new FenwickTree(arr);
        
        // Prefix sum query
        System.out.println("Sum [0-3]: " + ft.query(3)); // 1+3+5+7 = 16
        
        // Range sum query
        System.out.println("Sum [1-3]: " + ft.rangeQuery(1, 3)); // 3+5+7 = 15
        
        // Update: add 5 to index 1
        ft.update(1, 5);
        System.out.println("Sum [1-3] after update: " + ft.rangeQuery(1, 3)); // 8+5+7 = 20
    }
}
