# **Object-Oriented Programming (OOPs) Guide 🚀**

> Complete OOPs concepts with definitions and examples for interview preparation

## 📚 **Table of Contents**

### **📁 Folder Structure**
- [Classes and Objects](#classes-and-objects)
- [Constructor](#constructor)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)
- [Encapsulation](#encapsulation)
- [Abstraction](#abstraction)
- [Interface](#interface)
- [Static](#static)
- [Final](#final)
- [Exception Handling](#exception-handling)
- [Collections](#collections)
- [Generics](#generics)
- [Multithreading](#multithreading)
- [File I/O](#file-io)

---

## **Classes and Objects**

### **Topic: Class**
**Definition:** Blueprint or template for creating objects.

**Example:**
```java
class Student {
    String name;
    int age;
    
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "John";
        s1.age = 20;
        s1.display(); // Name: John, Age: 20
    }
}
```

---

### **Topic: Object**
**Definition:** Instance of a class with actual values.

**Example:**
```java
class Car {
    String brand;
    int year;
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(); // Object 1
        car1.brand = "Toyota";
        car1.year = 2020;
        
        Car car2 = new Car(); // Object 2
        car2.brand = "Honda";
        car2.year = 2021;
    }
}
```

---

## **Constructor**

### **Topic: Constructor**
**Definition:** Special method called when object is created, used to initialize object.

**Example:**
```java
class Student {
    String name;
    int age;
    
    // Default Constructor
    Student() {
        name = "Unknown";
        age = 0;
    }
    
    // Parameterized Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Copy Constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(); // Default
        Student s2 = new Student("John", 20); // Parameterized
        Student s3 = new Student(s2); // Copy
    }
}
```

---

### **Topic: this Keyword**
**Definition:** Reference to current object.

**Example:**
```java
class Student {
    String name;
    
    Student(String name) {
        this.name = name; // this.name refers to instance variable
    }
    
    void display() {
        System.out.println(this.name);
    }
    
    Student getStudent() {
        return this; // Return current object
    }
}
```

---

## **Inheritance**

### **Topic: Inheritance**
**Definition:** Mechanism where one class acquires properties and methods of another class.

**Example:**
```java
// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // Inherited method
        dog.bark(); // Own method
    }
}
```

---

### **Topic: Types of Inheritance**
**Definition:** Different ways classes can inherit from each other.

**Example:**
```java
// Single Inheritance
class A { }
class B extends A { }

// Multilevel Inheritance
class A { }
class B extends A { }
class C extends B { }

// Hierarchical Inheritance
class A { }
class B extends A { }
class C extends A { }

// Note: Multiple inheritance not supported in Java (use interfaces)
```

---

### **Topic: super Keyword**
**Definition:** Reference to parent class object.

**Example:**
```java
class Parent {
    int x = 10;
    
    Parent() {
        System.out.println("Parent Constructor");
    }
    
    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    int x = 20;
    
    Child() {
        super(); // Call parent constructor
        System.out.println("Child Constructor");
    }
    
    void display() {
        System.out.println(super.x); // Access parent variable
        super.display(); // Call parent method
        System.out.println(this.x); // Access child variable
    }
}
```

---

## **Polymorphism**

### **Topic: Method Overloading (Compile-time Polymorphism)**
**Definition:** Multiple methods with same name but different parameters.

**Example:**
```java
class Calculator {
    // Same method name, different parameters
    int add(int a, int b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));        // 15
        System.out.println(calc.add(5, 10, 15));    // 30
        System.out.println(calc.add(5.5, 10.5));    // 16.0
    }
}
```

---

### **Topic: Method Overriding (Runtime Polymorphism)**
**Definition:** Child class provides specific implementation of parent class method.

**Example:**
```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        
        a1.sound(); // Dog barks
        a2.sound(); // Cat meows
    }
}
```

---

## **Encapsulation**

### **Topic: Encapsulation**
**Definition:** Wrapping data and methods together, hiding internal details using access modifiers.

**Example:**
```java
class Student {
    // Private variables (data hiding)
    private String name;
    private int age;
    
    // Public getter
    public String getName() {
        return name;
    }
    
    // Public setter with validation
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("John");
        s.setAge(20);
        System.out.println(s.getName() + " - " + s.getAge());
    }
}
```

---

### **Topic: Access Modifiers**
**Definition:** Keywords controlling access to classes, methods, and variables.

**Example:**
```java
class Demo {
    public int a = 10;      // Accessible everywhere
    private int b = 20;     // Only within class
    protected int c = 30;   // Within package and subclasses
    int d = 40;             // Default: Within package
    
    public void display() {
        System.out.println(a + b + c + d); // All accessible here
    }
}

// Access Modifiers Table:
// | Modifier  | Class | Package | Subclass | World |
// |-----------|-------|---------|----------|-------|
// | public    | Yes   | Yes     | Yes      | Yes   |
// | protected | Yes   | Yes     | Yes      | No    |
// | default   | Yes   | Yes     | No       | No    |
// | private   | Yes   | No      | No       | No    |
```

---

## **Abstraction**

### **Topic: Abstract Class**
**Definition:** Class that cannot be instantiated, may contain abstract and concrete methods.

**Example:**
```java
abstract class Shape {
    // Abstract method (no body)
    abstract void draw();
    
    // Concrete method
    void display() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        
        s1.draw();    // Drawing Circle
        s2.draw();    // Drawing Rectangle
        s1.display(); // This is a shape
    }
}
```

---

## **Interface**

### **Topic: Interface**
**Definition:** Blueprint of class containing only abstract methods (Java 7) and default/static methods (Java 8+).

**Example:**
```java
interface Animal {
    // Abstract method (public abstract by default)
    void sound();
    
    // Default method (Java 8+)
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
    
    // Static method (Java 8+)
    static void info() {
        System.out.println("This is Animal interface");
    }
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();  // Dog barks
        dog.sleep();  // Animal is sleeping
        Animal.info(); // This is Animal interface
    }
}
```

---

### **Topic: Multiple Inheritance using Interface**
**Definition:** Class implementing multiple interfaces.

**Example:**
```java
interface Printable {
    void print();
}

interface Showable {
    void show();
}

class Document implements Printable, Showable {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
    
    @Override
    public void show() {
        System.out.println("Showing document");
    }
}

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();
        doc.print();
        doc.show();
    }
}
```

---

## **Static**

### **Topic: Static Variable**
**Definition:** Variable shared by all instances of class.

**Example:**
```java
class Student {
    String name;
    static String college = "ABC College"; // Shared by all
    
    Student(String name) {
        this.name = name;
    }
    
    void display() {
        System.out.println(name + " - " + college);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John");
        Student s2 = new Student("Jane");
        
        s1.display(); // John - ABC College
        s2.display(); // Jane - ABC College
        
        Student.college = "XYZ College"; // Change for all
        
        s1.display(); // John - XYZ College
        s2.display(); // Jane - XYZ College
    }
}
```

---

### **Topic: Static Method**
**Definition:** Method belonging to class, not instance. Can access only static members.

**Example:**
```java
class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
    
    static int multiply(int a, int b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        // Call without creating object
        System.out.println(Calculator.add(5, 10));      // 15
        System.out.println(Calculator.multiply(5, 10)); // 50
    }
}
```

---

### **Topic: Static Block**
**Definition:** Block executed once when class is loaded.

**Example:**
```java
class Demo {
    static int a;
    static String b;
    
    // Static block
    static {
        System.out.println("Static block executed");
        a = 10;
        b = "Hello";
    }
    
    Demo() {
        System.out.println("Constructor executed");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method");
        Demo d1 = new Demo();
        Demo d2 = new Demo();
    }
}
// Output:
// Static block executed
// Main method
// Constructor executed
// Constructor executed
```

---

## **Final**

### **Topic: Final Keyword**
**Definition:** Keyword to make variable constant, method non-overridable, or class non-inheritable.

**Example:**
```java
// Final variable (constant)
final int MAX_VALUE = 100;
// MAX_VALUE = 200; // Error: cannot reassign

// Final method (cannot be overridden)
class Parent {
    final void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    // void display() { } // Error: cannot override
}

// Final class (cannot be inherited)
final class FinalClass {
    void show() {
        System.out.println("Final class");
    }
}

// class SubClass extends FinalClass { } // Error: cannot inherit
```

---

## **Exception Handling**

### **Topic: Try-Catch**
**Definition:** Handle runtime errors to prevent program crash.

**Example:**
```java
public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Finally block always executes");
        }
    }
}
```

---

### **Topic: Multiple Catch Blocks**
**Definition:** Handle different exceptions separately.

**Example:**
```java
public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 50; // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        } catch (Exception e) {
            System.out.println("General exception");
        }
    }
}
```

---

### **Topic: Throw and Throws**
**Definition:** throw - manually throw exception, throws - declare exception.

**Example:**
```java
class AgeValidator {
    // throws declares exception
    static void validate(int age) throws Exception {
        if (age < 18) {
            // throw creates exception
            throw new Exception("Age must be 18+");
        }
        System.out.println("Valid age");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            AgeValidator.validate(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## **Collections**

### **Topic: ArrayList**
**Definition:** Dynamic array that can grow/shrink.

**Example:**
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(10);
        list.add(20);
        list.add(30);
        
        System.out.println(list.get(0)); // 10
        list.remove(1); // Remove index 1
        System.out.println(list.size()); // 2
        
        for (int num : list) {
            System.out.println(num);
        }
    }
}
```

---

### **Topic: HashMap**
**Definition:** Key-value pairs with O(1) lookup.

**Example:**
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("John", 25);
        map.put("Jane", 30);
        map.put("Bob", 35);
        
        System.out.println(map.get("John")); // 25
        System.out.println(map.containsKey("Jane")); // true
        
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
```

---

## **Generics**

### **Topic: Generics**
**Definition:** Type parameters for classes, interfaces, and methods.

**Example:**
```java
// Generic class
class Box<T> {
    private T value;
    
    public void set(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(10);
        System.out.println(intBox.get()); // 10
        
        Box<String> strBox = new Box<>();
        strBox.set("Hello");
        System.out.println(strBox.get()); // Hello
    }
}
```

---

## **Multithreading**

### **Topic: Thread Creation**
**Definition:** Create threads by extending Thread class or implementing Runnable.

**Example:**
```java
// Method 1: Extending Thread
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

// Method 2: Implementing Runnable
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
    }
}
```

---

### **Topic: Synchronization**
**Definition:** Control access to shared resource by multiple threads.

**Example:**
```java
class Counter {
    private int count = 0;
    
    // Synchronized method
    public synchronized void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("Count: " + counter.getCount()); // 2000
    }
}
```

---

## **File I/O**

### **Topic: File Reading**
**Definition:** Read data from file.

**Example:**
```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### **Topic: File Writing**
**Definition:** Write data to file.

**Example:**
```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Hello World");
            bw.newLine();
            bw.write("Java File I/O");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## **OOPs Principles Summary**

### **4 Pillars of OOPs**

1. **Encapsulation**: Data hiding using access modifiers
2. **Inheritance**: Code reusability through parent-child relationship
3. **Polymorphism**: One interface, multiple implementations
4. **Abstraction**: Hiding implementation details

---

**Happy Coding! 🚀**
