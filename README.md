# Profiling 

## JavaCup

I configured yourkit on my pc and connect it to the IDE. 
![config yourkit and connect](https://user-images.githubusercontent.com/45316558/235088191-7a18f261-9f58-4847-906e-dea192e7bb62.png)

After that I ran the program using profiler and I hit heap size limit. So the program was killed. Therefore, I changed the for loop in temp function a litter bit.

here is the heap size limit execption I get:

![java heap size](https://user-images.githubusercontent.com/45316558/235088722-cb23d8b7-02b8-47b5-844a-9fd3727fafcb.png)


here is the new temp function:

``` java
  public static void temp() {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 3000; i++)
        {
            for (int j = 0; j < 20000; j++) {
                a.add(i + j);
            }
        }
    }
```

After this modification the program executed flawlessly.
Here is the cpu profile in yourkit.
![cpu status](https://user-images.githubusercontent.com/45316558/235089248-a93c7ad4-442f-4ab8-9627-f0d5215da400.png)

Here is the memory profile in yourkit.
![memory status](https://user-images.githubusercontent.com/45316558/235089350-31b03955-fa01-450f-859b-aa90ad329956.png)


Clearly from yourkit logs we know that `temp` method has the most resource usage.
----------------

As you can see the temp function is the main memory and cpu bottleneck in the program.

## summation

The sum function is a simple function that calculates the sum of numbers from 0 to a given number n. The implementation of the sum function in this example is provided in two different methods: `sum_bad` and `sum_good`.

The `sum_bad` method implements the sum function using a simple loop that iterates over all the numbers from 0 to n and adds them up one by one. This implementation has a time complexity of O(n) and is considered to be inefficient for large values of n.

The `sum_good` method, on the other hand, implements the sum function using the arithmetic progression formula. This implementation has a time complexity of O(1) and is much more efficient than the sum_bad implementation for large values of n.

The `complex_operation_1` and `complex_operation_2` methods use the sum_bad and sum_good methods, respectively, to perform some complex computation(computer the ratio between each consicutive sum). These methods use a loop that iterates over a large number of times (1000000) and performs some mathematical operations using the result of the sum function.

Inside the loop in complex_operations, the sum method is called with an increasing value of n + i, where i is the loop variable. The result of sum is then used in a mathematical operation to update the result variable. Specifically, if the loop index i is even, result is divided by the result of sum, otherwise, it is multiplied by the result of sum.

This code can be used to demonstrate the performance difference between the sum_bad and sum_good implementations of the sum function. Profiling the code with YourKit Java Profiler can help identify the performance bottlenecks in the code and optimize the implementation for improved performance.


some snapshots from yourkit using `complex_operation_1`:
![bad sum](https://user-images.githubusercontent.com/45316558/235099299-c1358ad4-8b0d-4d4b-aae8-0b3b01395408.png)

![sum bad 3](https://user-images.githubusercontent.com/45316558/235099318-005f4fda-aa13-479d-98fb-b73bc35a6a49.png)

![sum bad 2](https://user-images.githubusercontent.com/45316558/235099346-1211666f-bfbb-4b54-89d6-9f657b64a451.png)


But after I used sum_good instead of sum_bad we have the following result which is insignifcant memory or cpu usage.

![good sum](https://user-images.githubusercontent.com/45316558/235099657-3721a611-ca08-4f9c-9143-4cce40559a62.png)
