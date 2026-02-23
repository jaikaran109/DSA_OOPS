# **Data Structures & Algorithms (DSA) Guide 🚀**

> Complete DSA concepts with definitions and examples for interview preparation

## 📚 **Table of Contents**

### **📁 Folder Structure**
- [Arrays](#arrays)
- [Linked List](#linked-list)
- [Stack](#stack)
- [Queue](#queue)
- [Hashing](#hashing)
- [Recursion](#recursion)
- [Binary Search](#binary-search)
- [Sorting](#sorting)
- [Two Pointer](#two-pointer)
- [Sliding Window](#sliding-window)
- [Trees](#trees)
- [Graphs](#graphs)
- [Dynamic Programming](#dynamic-programming)
- [Bit Manipulation](#bit-manipulation)
- [Greedy](#greedy)
- [Heap](#heap)
- [Segment Tree](#segment-tree)
- [Fenwick Tree](#fenwick-tree)

---

## **Arrays**

### **Topic: Array**
**Definition:** Linear data structure storing elements of same type in contiguous memory locations.

**Example:**
```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(arr[0]); // 1
System.out.println(arr.length); // 5
```

---

### **Topic: Two Sum**
**Definition:** Find two numbers that add up to target.

**Example:**
```java
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
// Time: O(n), Space: O(n)
```

---

### **Topic: Kadane's Algorithm**
**Definition:** Find maximum sum subarray in O(n) time.

**Example:**
```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}
// Time: O(n), Space: O(1)
```

---

## **Linked List**

### **Topic: Singly Linked List**
**Definition:** Linear data structure where each node contains data and pointer to next node.

**Example:**
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

// Insert at beginning
public ListNode insertAtBeginning(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    newNode.next = head;
    return newNode;
}
```

---

### **Topic: Reverse Linked List**
**Definition:** Reverse the direction of pointers in linked list.

**Example:**
```java
public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    
    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}
// Time: O(n), Space: O(1)
```

---

### **Topic: Detect Cycle (Floyd's Algorithm)**
**Definition:** Detect if linked list has cycle using slow and fast pointers.

**Example:**
```java
public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
// Time: O(n), Space: O(1)
```

---

## **Stack**

### **Topic: Stack**
**Definition:** LIFO (Last In First Out) data structure.

**Example:**
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println(stack.pop());  // 3
System.out.println(stack.peek()); // 2
```

---

### **Topic: Valid Parentheses**
**Definition:** Check if brackets are balanced.

**Example:**
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
        }
    }
    return stack.isEmpty();
}
// Time: O(n), Space: O(n)
```

---

## **Queue**

### **Topic: Queue**
**Definition:** FIFO (First In First Out) data structure.

**Example:**
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(1);
queue.offer(2);
queue.offer(3);
System.out.println(queue.poll());  // 1
System.out.println(queue.peek());  // 2
```

---

## **Hashing**

### **Topic: HashMap**
**Definition:** Key-value pairs with O(1) average lookup.

**Example:**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 100);
map.put("banana", 50);
System.out.println(map.get("apple")); // 100
System.out.println(map.containsKey("banana")); // true
```

---

### **Topic: Frequency Count**
**Definition:** Count occurrences of elements.

**Example:**
```java
public void countFrequency(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int key : map.keySet()) {
        System.out.println(key + ": " + map.get(key));
    }
}
// Time: O(n), Space: O(n)
```

---

## **Recursion**

### **Topic: Recursion**
**Definition:** Function calling itself to solve smaller subproblems.

**Example:**
```java
// Factorial
public int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

// Fibonacci
public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

---

### **Topic: Backtracking**
**Definition:** Try all possibilities and backtrack on failure.

**Example:**
```java
// Generate all subsets
public void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    
    for (int i = index; i < nums.length; i++) {
        current.add(nums[i]);
        generateSubsets(nums, i + 1, current, result);
        current.remove(current.size() - 1); // Backtrack
    }
}
```

---

## **Binary Search**

### **Topic: Binary Search**
**Definition:** Search in sorted array by dividing search space in half.

**Example:**
```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
// Time: O(log n), Space: O(1)
```

---

## **Sorting**

### **Topic: Quick Sort**
**Definition:** Divide and conquer sorting using pivot.

**Example:**
```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
}
// Time: O(n log n) average, Space: O(log n)
```

---

## **Two Pointer**

### **Topic: Two Pointer**
**Definition:** Use two pointers to solve array problems efficiently.

**Example:**
```java
// Remove duplicates from sorted array
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}
// Time: O(n), Space: O(1)
```

---

## **Sliding Window**

### **Topic: Sliding Window**
**Definition:** Maintain window of elements and slide to find optimal solution.

**Example:**
```java
// Maximum sum subarray of size k
public int maxSumSubarray(int[] arr, int k) {
    int maxSum = 0, windowSum = 0;
    
    // First window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
// Time: O(n), Space: O(1)
```

---

## **Trees**

### **Topic: Binary Tree**
**Definition:** Tree where each node has at most two children.

**Example:**
```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

// Inorder Traversal (Left, Root, Right)
public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

---

### **Topic: Level Order Traversal (BFS)**
**Definition:** Visit nodes level by level using queue.

**Example:**
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(level);
    }
    return result;
}
// Time: O(n), Space: O(n)
```

---

## **Graphs**

### **Topic: Graph Representation**
**Definition:** Represent graph using adjacency list or matrix.

**Example:**
```java
// Adjacency List
Map<Integer, List<Integer>> graph = new HashMap<>();
graph.put(0, Arrays.asList(1, 2));
graph.put(1, Arrays.asList(0, 3));
graph.put(2, Arrays.asList(0, 3));
graph.put(3, Arrays.asList(1, 2));
```

---

### **Topic: BFS (Breadth First Search)**
**Definition:** Explore graph level by level using queue.

**Example:**
```java
public void bfs(Map<Integer, List<Integer>> graph, int start) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    
    queue.offer(start);
    visited.add(start);
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");
        
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
}
// Time: O(V + E), Space: O(V)
```

---

### **Topic: DFS (Depth First Search)**
**Definition:** Explore graph deeply using recursion or stack.

**Example:**
```java
public void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
    visited.add(node);
    System.out.print(node + " ");
    
    for (int neighbor : graph.get(node)) {
        if (!visited.contains(neighbor)) {
            dfs(graph, neighbor, visited);
        }
    }
}
// Time: O(V + E), Space: O(V)
```

---

## **Dynamic Programming**

### **Topic: Dynamic Programming**
**Definition:** Solve problems by breaking into overlapping subproblems and storing results.

**Example:**
```java
// Fibonacci with DP
public int fibonacci(int n) {
    if (n <= 1) return n;
    
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
// Time: O(n), Space: O(n)
```

---

### **Topic: 0/1 Knapsack**
**Definition:** Select items to maximize value without exceeding weight capacity.

**Example:**
```java
public int knapsack(int[] weights, int[] values, int capacity) {
    int n = weights.length;
    int[][] dp = new int[n + 1][capacity + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= capacity; w++) {
            if (weights[i - 1] <= w) {
                dp[i][w] = Math.max(
                    values[i - 1] + dp[i - 1][w - weights[i - 1]],
                    dp[i - 1][w]
                );
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }
    return dp[n][capacity];
}
// Time: O(n * capacity), Space: O(n * capacity)
```

---

## **Bit Manipulation**

### **Topic: Bit Operations**
**Definition:** Manipulate individual bits for efficient operations.

**Example:**
```java
// Check if number is power of 2
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}

// Count set bits
public int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}

// XOR of all elements (find single number)
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num;
    }
    return result;
}
```

---

## **Greedy**

### **Topic: Greedy Algorithm**
**Definition:** Make locally optimal choice at each step.

**Example:**
```java
// Activity Selection
public int maxActivities(int[] start, int[] end) {
    int n = start.length;
    int[][] activities = new int[n][2];
    
    for (int i = 0; i < n; i++) {
        activities[i][0] = start[i];
        activities[i][1] = end[i];
    }
    
    Arrays.sort(activities, (a, b) -> a[1] - b[1]);
    
    int count = 1;
    int lastEnd = activities[0][1];
    
    for (int i = 1; i < n; i++) {
        if (activities[i][0] >= lastEnd) {
            count++;
            lastEnd = activities[i][1];
        }
    }
    return count;
}
// Time: O(n log n), Space: O(n)
```

---

## **Heap**

### **Topic: Priority Queue (Heap)**
**Definition:** Data structure where elements are ordered by priority.

**Example:**
```java
// Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.offer(5);
minHeap.offer(2);
minHeap.offer(8);
System.out.println(minHeap.poll()); // 2

// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
maxHeap.offer(5);
maxHeap.offer(2);
maxHeap.offer(8);
System.out.println(maxHeap.poll()); // 8
```

---

### **Topic: Kth Largest Element**
**Definition:** Find kth largest element using min heap.

**Example:**
```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    return minHeap.peek();
}
// Time: O(n log k), Space: O(k)
```

---

## **Segment Tree**

### **Topic: Segment Tree**
**Definition:** Tree for range queries and updates in O(log n).

**Example:**
```java
class SegmentTree {
    int[] tree;
    int n;
    
    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
    
    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2*node+1, start, mid);
        build(arr, 2*node+2, mid+1, end);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    
    int query(int left, int right) {
        return query(0, 0, n-1, left, right);
    }
    
    int query(int node, int start, int end, int left, int right) {
        if (right < start || left > end) return 0;
        if (left <= start && end <= right) return tree[node];
        
        int mid = (start + end) / 2;
        return query(2*node+1, start, mid, left, right) +
               query(2*node+2, mid+1, end, left, right);
    }
}
// Build: O(n), Query: O(log n), Update: O(log n)
```

---

## **Fenwick Tree**

### **Topic: Fenwick Tree (Binary Indexed Tree)**
**Definition:** Efficient data structure for prefix sum queries and updates.

**Example:**
```java
class FenwickTree {
    int[] tree;
    int n;
    
    FenwickTree(int size) {
        n = size;
        tree = new int[n + 1];
    }
    
    void update(int index, int delta) {
        index++;
        while (index <= n) {
            tree[index] += delta;
            index += index & (-index);
        }
    }
    
    int query(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
    
    int rangeQuery(int left, int right) {
        return query(right) - (left == 0 ? 0 : query(left - 1));
    }
}
// Update: O(log n), Query: O(log n)
```

---

## **Time Complexity Cheat Sheet**

| Data Structure | Access | Search | Insert | Delete |
|---------------|--------|--------|--------|--------|
| Array | O(1) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1) | O(1) |
| Stack | O(n) | O(n) | O(1) | O(1) |
| Queue | O(n) | O(n) | O(1) | O(1) |
| Hash Table | - | O(1) | O(1) | O(1) |
| Binary Tree | O(n) | O(n) | O(n) | O(n) |
| BST | O(log n) | O(log n) | O(log n) | O(log n) |
| Heap | - | O(n) | O(log n) | O(log n) |

---

**Happy Coding! 🚀**
