public class SegmentTree {
    private int[] tree;
    private int n;
    
    // Constructor
    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
    
    // Build segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        build(arr, leftChild, start, mid);
        build(arr, rightChild, mid + 1, end);
        
        tree[node] = tree[leftChild] + tree[rightChild];
    }
    
    // Range sum query
    public int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
    
    private int query(int node, int start, int end, int left, int right) {
        // No overlap
        if (right < start || left > end) {
            return 0;
        }
        
        // Complete overlap
        if (left <= start && end <= right) {
            return tree[node];
        }
        
        // Partial overlap
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        int leftSum = query(leftChild, start, mid, left, right);
        int rightSum = query(rightChild, mid + 1, end, left, right);
        
        return leftSum + rightSum;
    }
    
    // Point update
    public void update(int index, int value) {
        update(0, 0, n - 1, index, value);
    }
    
    private void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
            return;
        }
        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        if (index <= mid) {
            update(leftChild, start, mid, index, value);
        } else {
            update(rightChild, mid + 1, end, index, value);
        }
        
        tree[node] = tree[leftChild] + tree[rightChild];
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);
        
        // Range sum query
        System.out.println("Sum of range [1, 3]: " + st.query(1, 3)); // 15
        
        // Update
        st.update(1, 10);
        System.out.println("Sum after update [1, 3]: " + st.query(1, 3)); // 22
    }
}
