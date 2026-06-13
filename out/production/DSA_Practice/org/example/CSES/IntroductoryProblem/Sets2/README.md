<img alt="" src="https://github.com/Suchismita-Deb/CodingNotes/blob/main/coding/cses/IntroductoryProblem/2Set.png"/>

Sum of n numbers - n(n+1)/2

When the total sum is odd there is no way to divide in 2 sets and when the total sum even then print YES and print the numbers.

n=7 then sum=7*8/2 = 28. Sets sum should be 14.

1 2 3 4 5 6 7

When counting from the end will get the value and when the target is ≥i then get the value.

When moving from the front then will get all the small value and there there will be some value which is not fulfilled by the larger values. The backward move will not misuse any small value.

Property of consecutive numbers - Every integer upto the total sum can be represented by the subset sum. Meaning the sum is 28 means from 1 to 28 any number can be represented by the numbers in the range of 1 to 7.

When the target is 14 meaning there always exists an answer and get the higher value to be greedy and not misuse any smaller number.

Example - n=5 then sum = 5*6/3 = 15. Every integer 1 to 15 can be formed by the subsets of the integers.

Solution1.

The solution is giving TLE any umber more than 10^6.

The printing in System.out.println() will create TLE.

Solution1.

StringBuilder collecting all input and then printing no more IO call. Time is same O(N) but the runtime increased.

Use of PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out)); to increase the speed.

Solution2.

In this approach we are moving from n to 1 to get the numbers. We can use the pairing technique to make the sets.

Sum will be even in the cases n%4==0 or n%4==3. n%4==1 or 2 not possible.

n%4==0 then put the pairs like (1,n),(2,n-1) in alternate sets.

n%4==3 then put (1,2) in one set and (3) in another. Then the counting starts from 4 and the value will go to set 1 or 2.

i=4 (4-3)%4 = 1 goes to set 1.

i=5 (5-3)%4 = 2 goes to set 2.

i=6 (6-3)%4 = 3 goes to set 2.

i=7 (7-3)%4=0 goes to set 1.

(i-3)%4==1 or 0 then set 1.

(i-3)%4==2 or 3 then set 2.

It will ensure that every block of 4 consecutive numbers after 3 is splits evenly between the sets.

To get more power solve - **constructive combinatorics** and **number partition problems.**

TwoSetOptimized.
