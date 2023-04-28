# Profiling 

## JavaCup

I configured yourkit on my pc and connect it to the IDE. 
![config yourkit and connect](https://user-images.githubusercontent.com/45316558/235088191-7a18f261-9f58-4847-906e-dea192e7bb62.png)

After that I've run the program using profiler and I hit heap size limit. So the program was killed. Therefore, I changed the for loop in temp function a litter bit.

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

----------------

As you can see the temp function is the main memory and cpu bottleneck in the program.

## summation

