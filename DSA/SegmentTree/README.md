# **Segment Tree**

## **Definition**
A Segment Tree is a binary tree data structure used for storing intervals or segments. It allows querying which segments contain a given point efficiently.

## **Key Concepts**

### **What is Segment Tree?**
- Binary tree where each node represents an interval/segment
- Leaf nodes represent single elements
- Internal nodes represent union of child segments
- Supports range queries and updates efficiently

### **Structure**
```
Array: [1, 3, 5, 7, 9, 11]

Segment Tree:
              36 [0-5]
            /          \
        9 [0-2]        27 [3-5]
       /      \        /      \
    4 [0-1]  5[2]  16[3-4]  11[5]
    /    \          /    \
  1[0]  3[1]      7[3]  9[4]
```

### **Why Segment Tree?**
**Problem**: Given array, perform:
1. Range sum queries: Sum of elements in range [L, R]
2. Point updates: Update element at index i

**Naive Approach**:
- Range Query: O(n) - iterate through range
- Update: O(1) - direct update

**Segment Tree Approach**:
- Range Query: O(log n)
- Update: O(log n)
- Build: O(n)

---

## **Operations**

### **1. Build Tree**
**Definition**: Construct segment tree from array.

**Algorithm**:
1. If leaf node (start == end), store array element
2. Recursively build left and right subtrees
3. Store sum of children in current node

**Time Complexity**: O(n)
**Space Complexity**: O(4n) ≈ O(n)

**Code**:
```java
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
```

---

### **2. Range Query**
**Definition**: Find sum of elements in range [L, R].

**Algorithm**:
1. **No Overlap**: Query range doesn't intersect node range → return 0
2. **Complete Overlap**: Node range completely inside query range → return node value
3. **Partial Overlap**: Recursively query left and right children

**Time Complexity**: O(log n)
**Space Complexity**: O(log n) - recursion stack

**Code**:
```java
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
    int leftSum = query(2*node+1, start, mid, left, right);
    int rightSum = query(2*node+2, mid+1, end, left, right);
    
    return leftSum + rightSum;
}
```

---

### **3. Point Update**
**Definition**: Update value at specific index.

**Algorithm**:
1. If leaf node, update value
2. Recursively update appropriate child
3. Update current node as sum of children

**Time Complexity**: O(log n)
**Space Complexity**: O(log n) - recursion stack

**Code**:
```java
private void update(int node, int start, int end, int index, int value) {
    if (start == end) {
        tree[node] = value;
        return;
    }
    
    int mid = start + (end - start) / 2;
    
    if (index <= mid) {
        update(2*node+1, start, mid, index, value);
    } else {
        update(2*node+2, mid+1, end, index, value);
    }
    
    tree[node] = tree[2*node+1] + tree[2*node+2];
}
```

---

## **Complexity Analysis**

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Build | O(n) | O(4n) ≈ O(n) |
| Query | O(log n) | O(log n) |
| Update | O(log n) | O(log n) |

---

## **Types of Segment Trees**

### **1. Sum Segment Tree**
- Stores sum of range
- Query: Range sum
- Update: Point update

### **2. Min/Max Segment Tree**
- Stores minimum/maximum in range
- Query: Range min/max
- Update: Point update

### **3. Lazy Propagation Segment Tree**
- Handles range updates efficiently
- Uses lazy propagation to defer updates
- Query: O(log n)
- Range Update: O(log n)

---

## **When to Use Segment Tree?**

✅ **Use When**:
- Multiple range queries needed
- Array updates are frequent
- Need O(log n) query and update
- Range sum, min, max, GCD queries

❌ **Don't Use When**:
- Only single query needed (use prefix sum)
- No updates (use prefix sum)
- Memory is constraint (4n space)

---

## **Common Problems**

1. **Range Sum Query**: Sum of elements in range
2. **Range Minimum Query**: Minimum element in range
3. **Range Maximum Query**: Maximum element in range
4. **Range GCD Query**: GCD of elements in range
5. **Count of elements in range**: Count elements satisfying condition

---

## **Example Usage**

```java
public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 9, 11};
    SegmentTree st = new SegmentTree(arr);
    
    // Range sum query [1, 3]
    System.out.println(st.query(1, 3)); // 3 + 5 + 7 = 15
    
    // Update index 1 to 10
    st.update(1, 10);
    
    // Range sum query [1, 3] after update
    System.out.println(st.query(1, 3)); // 10 + 5 + 7 = 22
    
    // Range sum query [0, 5]
    System.out.println(st.query(0, 5)); // 1+10+5+7+9+11 = 43
}
```

---

## **Advantages**
- Efficient range queries: O(log n)
- Efficient point updates: O(log n)
- Versatile: Can store sum, min, max, GCD, etc.
- Easy to implement

## **Disadvantages**
- High space complexity: O(4n)
- Complex implementation for beginners
- Not cache-friendly
- Overkill for simple problems

---

## **Interview Tips**
1. Understand when to use Segment Tree vs other data structures
2. Know how to modify for different operations (min, max, GCD)
3. Understand lazy propagation for range updates
4. Practice building tree from scratch
5. Know space complexity: 4n for array representation

---

**Time to Master**: Medium
**Difficulty**: Hard
**Important For**: Competitive Programming, Range Query Problems
