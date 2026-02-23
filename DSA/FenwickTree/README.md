# **Fenwick Tree (Binary Indexed Tree)**

## **Definition**
A Fenwick Tree (Binary Indexed Tree or BIT) is a data structure that efficiently supports prefix sum queries and point updates on an array.

## **Key Concepts**

### **What is Fenwick Tree?**
- Also known as Binary Indexed Tree (BIT)
- Stores partial sums of array elements
- Uses binary representation of indices
- More space-efficient than Segment Tree
- Simpler implementation than Segment Tree

### **Structure**
```
Array:  [1, 3, 5, 7, 9, 11]
Index:   0  1  2  3  4  5

Fenwick Tree (1-indexed):
tree[1] = arr[0]                    = 1
tree[2] = arr[0] + arr[1]           = 4
tree[3] = arr[2]                    = 5
tree[4] = arr[0]+arr[1]+arr[2]+arr[3] = 16
tree[5] = arr[4]                    = 9
tree[6] = arr[4] + arr[5]           = 20
```

### **Why Fenwick Tree?**
**Problem**: Given array, perform:
1. Prefix sum queries: Sum from index 0 to i
2. Point updates: Update element at index i

**Comparison**:

| Approach | Query | Update | Space |
|----------|-------|--------|-------|
| Naive | O(n) | O(1) | O(n) |
| Prefix Sum | O(1) | O(n) | O(n) |
| Segment Tree | O(log n) | O(log n) | O(4n) |
| **Fenwick Tree** | **O(log n)** | **O(log n)** | **O(n)** |

---

## **Core Concept: Last Set Bit**

### **Understanding LSB (Least Significant Bit)**
```
Number: 12 (binary: 1100)
LSB = 12 & (-12) = 4 (binary: 0100)

Number: 10 (binary: 1010)
LSB = 10 & (-10) = 2 (binary: 0010)

Number: 7 (binary: 0111)
LSB = 7 & (-7) = 1 (binary: 0001)
```

**Formula**: `index & (-index)` gives last set bit

**Why it works**:
- `-index` is 2's complement of index
- AND operation isolates rightmost set bit

---

## **Operations**

### **1. Update Operation**
**Definition**: Add delta to element at index.

**Algorithm**:
1. Convert to 1-indexed
2. Add delta to current index
3. Move to next index by adding LSB
4. Repeat until index > n

**Time Complexity**: O(log n)
**Space Complexity**: O(1)

**Code**:
```java
public void update(int index, int delta) {
    index++; // Convert to 1-indexed
    
    while (index <= n) {
        tree[index] += delta;
        index += index & (-index); // Add last set bit
    }
}
```

**Example**:
```
Update index 2 with delta 5:
index = 3 (1-indexed)
3 → 3 + (3 & -3) = 3 + 1 = 4
4 → 4 + (4 & -4) = 4 + 4 = 8
8 > 6 (stop)
```

---

### **2. Query Operation (Prefix Sum)**
**Definition**: Get sum from index 0 to given index.

**Algorithm**:
1. Convert to 1-indexed
2. Add current tree value to sum
3. Move to parent by subtracting LSB
4. Repeat until index becomes 0

**Time Complexity**: O(log n)
**Space Complexity**: O(1)

**Code**:
```java
public int query(int index) {
    index++; // Convert to 1-indexed
    int sum = 0;
    
    while (index > 0) {
        sum += tree[index];
        index -= index & (-index); // Remove last set bit
    }
    
    return sum;
}
```

**Example**:
```
Query prefix sum till index 5:
index = 6 (1-indexed)
sum = 0
6 → sum += tree[6], 6 - (6 & -6) = 6 - 2 = 4
4 → sum += tree[4], 4 - (4 & -4) = 4 - 4 = 0
return sum
```

---

### **3. Range Query**
**Definition**: Get sum from left to right index.

**Algorithm**:
- Use prefix sum property
- rangeSum(L, R) = prefixSum(R) - prefixSum(L-1)

**Time Complexity**: O(log n)
**Space Complexity**: O(1)

**Code**:
```java
public int rangeQuery(int left, int right) {
    if (left == 0) {
        return query(right);
    }
    return query(right) - query(left - 1);
}
```

---

## **Complexity Analysis**

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Build | O(n log n) | O(n) |
| Update | O(log n) | O(1) |
| Query (Prefix) | O(log n) | O(1) |
| Query (Range) | O(log n) | O(1) |

---

## **How Fenwick Tree Works**

### **Index Responsibility**
Each index in Fenwick Tree is responsible for a range:

```
Index 1 (0001): Responsible for [1, 1]
Index 2 (0010): Responsible for [1, 2]
Index 3 (0011): Responsible for [3, 3]
Index 4 (0100): Responsible for [1, 4]
Index 5 (0101): Responsible for [5, 5]
Index 6 (0110): Responsible for [5, 6]
Index 7 (0111): Responsible for [7, 7]
Index 8 (1000): Responsible for [1, 8]
```

**Pattern**: Index i is responsible for 2^k elements where k = number of trailing zeros in binary representation.

---

## **Visual Representation**

```
Array indices:  1   2   3   4   5   6   7   8
                |   |   |   |   |   |   |   |
tree[1] --------+   |   |   |   |   |   |   |
tree[2] ------------+   |   |   |   |   |   |
tree[3] ----------------+   |   |   |   |   |
tree[4] --------------------+   |   |   |   |
tree[5] ------------------------+   |   |   |
tree[6] ----------------------------+   |   |
tree[7] --------------------------------+   |
tree[8] ------------------------------------+

Each tree[i] stores sum of specific range based on LSB
```

---

## **When to Use Fenwick Tree?**

✅ **Use When**:
- Need prefix sum queries
- Frequent point updates
- Space efficiency important
- Simpler implementation preferred
- 1D array operations

❌ **Don't Use When**:
- Need range updates (use Segment Tree with lazy propagation)
- Need min/max queries (use Segment Tree)
- Need 2D operations (complex in Fenwick)
- Only single query (use prefix sum array)

---

## **Fenwick Tree vs Segment Tree**

| Feature | Fenwick Tree | Segment Tree |
|---------|-------------|--------------|
| Space | O(n) | O(4n) |
| Implementation | Simpler | Complex |
| Operations | Sum only | Sum, Min, Max, GCD |
| Range Update | Difficult | Easy (lazy prop) |
| Cache Friendly | More | Less |
| Code Length | Shorter | Longer |

---

## **Common Problems**

1. **Range Sum Query**: Sum of elements in range
2. **Count Inversions**: Count pairs where arr[i] > arr[j] and i < j
3. **Count Smaller Elements**: Count elements smaller than current
4. **2D Range Sum**: Sum in 2D matrix (2D Fenwick Tree)
5. **Frequency Count**: Count occurrences in range

---

## **Example Usage**

```java
public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 9, 11};
    FenwickTree ft = new FenwickTree(arr);
    
    // Prefix sum [0-3]
    System.out.println(ft.query(3)); // 1+3+5+7 = 16
    
    // Range sum [1-3]
    System.out.println(ft.rangeQuery(1, 3)); // 3+5+7 = 15
    
    // Update: add 5 to index 1
    ft.update(1, 5);
    
    // Range sum [1-3] after update
    System.out.println(ft.rangeQuery(1, 3)); // 8+5+7 = 20
    
    // Prefix sum [0-5]
    System.out.println(ft.query(5)); // 1+8+5+7+9+11 = 41
}
```

---

## **Advanced: 2D Fenwick Tree**

For 2D range sum queries:

```java
public class FenwickTree2D {
    private int[][] tree;
    private int n, m;
    
    public FenwickTree2D(int rows, int cols) {
        n = rows;
        m = cols;
        tree = new int[n + 1][m + 1];
    }
    
    public void update(int x, int y, int delta) {
        for (int i = x + 1; i <= n; i += i & (-i)) {
            for (int j = y + 1; j <= m; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }
    
    public int query(int x, int y) {
        int sum = 0;
        for (int i = x + 1; i > 0; i -= i & (-i)) {
            for (int j = y + 1; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
```

---

## **Advantages**
- Space efficient: O(n)
- Simple implementation
- Fast operations: O(log n)
- Cache friendly
- Easy to code in contests

## **Disadvantages**
- Only supports sum operations (not min/max)
- Range updates are complex
- 1-indexed (can be confusing)
- Less intuitive than Segment Tree

---

## **Interview Tips**
1. Remember LSB formula: `index & (-index)`
2. Always convert to 1-indexed
3. Know when to use over Segment Tree
4. Understand update and query traversal
5. Practice 2D Fenwick Tree
6. Know space advantage: O(n) vs O(4n)

---

## **Common Mistakes**
1. Forgetting to convert to 1-indexed
2. Using wrong LSB formula
3. Not handling 0-indexed arrays properly
4. Confusing update and query operations
5. Using for min/max queries (use Segment Tree)

---

**Time to Master**: Medium
**Difficulty**: Medium-Hard
**Important For**: Competitive Programming, Range Query Problems
**Best For**: Prefix sum queries with updates
