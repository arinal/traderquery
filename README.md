# Trader Query Test
A minimalist application for calling RESTful services asynchronously with Java.

## Application's architect overview
All of the classes are bundled in single package, most of the logic is contained inside `com.traderquery.Main`
class. It has 2 methods, namely `main` and `solveProblems`.

Inside `main` function, we can see how to set rest client and then call both all traders and all transactions simultaneously using RxJava. Function
`solveProblems` is invoked only when both REST call responses are received by our application.

All the infrastructures magic have already done when `solveProblems` is called, because all the logic inside this function is only
plain and standard Java 8 code.

## Try it!
Assuming you have installed JDK8+ and JAVA_HOME has been set, just run:

* `git clone https://github.com/arinal/traderquery.git && cd traderquery`
* `./gradlew run`

If everything is correct, you will see this output in your screen:
```
find all singapaporean traders sorted by name
Id: 195fbb57ffe7449796d23466085ce6d8, name: May, City: Singapore
Id: 75f87fa90004d185432caa1dfb208bbf, name: Brittany, City: Singapore
..

transaction with highest transaction value
Date: Thu May 30 20:25:50 WIB 2013, Value: 0.9817253648270564, Trader: f9dc77cece7fa16f6edd2d1d64853e4b

all transactions in 2016 sorted descendingly by date
Date: Wed Jul 27 00:01:44 WIB 2016, Value: 0.9057669559853739, Trader: ba0e0cde1bf72c28d435c89a66afc61a
Date: Sat Jul 23 19:50:18 WIB 2016, Value: 0.8400671857631128, Trader: 75f87fa90004d185432caa1dfb208bbf
..

average beijing traders' transaction
0.402193042651789256875
```
