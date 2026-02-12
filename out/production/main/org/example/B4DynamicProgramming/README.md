DP Terms.

Tabulation.  
Memoization.
State.
Transition.
Overlapping subproblem.
Forward DP.
Backward DP.

DP Problem Framework. 
Recognize the form.
DP (state parameter) = Transition (Question Asked).
Transition Modeling - When recognize the form it will help in recognizing the transitiona nd state.
Save and return.
Code.

Form or Pattern.
Object Iteration. 
Ending DP.
MultiArray DP.
Interval DP.
Game DP.

Adv DP Form or Pattern.
Digit Db.
Bitmask DP.
Tree DP.

Classical DP.  
Non CLassical DP.  
Competitive DP.


### Fundamental of Recursion - Modeling Backtracking and DP.

```Java
Fact(x)
if(x==0) return 1;
else return x*Fact(x-1);
```

```java
Fib(x)
if(x==0 || x==1) return 1;
else return Fib(x-1)+ Fib(x-2);
```

Fact(4) - Fact(3) This is an individual interaction. 

The subproblem is correct and it will return correct value. Only to take care of the retirn of fact(4). Focus on one parameter and it will return correct value.

Think recursion as one onteraction. From this value of the paarmeter how to retrieve from smaller value if we have the smaller function correctly implemented.

**Level, Choice, Check, Move.**

Number of ways to reach N stair. He can jump 1, 2, 3 steps.



