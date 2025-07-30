### BinarySearch.

### Allocate Books.

Given an array of integers A of size N and an integer B. There are N books. The ith book has A[i] number of pages.
You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

Calculate and return that minimum possible number.

Example Input
Input 1:
A = [12, 34, 67, 90]
B = 2
Output 1:
113
Input 2:
A = [5, 17, 100, 11]
B = 4
Output 2:
100

Example Explanation
Explanation 1:
There are two students. Books can be distributed in following fashion.

[12] and [34, 67, 90]
Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages

[12, 34] and [67, 90]
Max number of pages is allocated to student 2 with 67 + 90 = 157 pages

[12, 34, 67] and [90]
Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
Of the 3 cases, Option 3 has the minimum pages = 113.

Binary Search is applicable in the places where there is search space. One min and one max is given and the answer is in the range then use binary search.

[12, ..., 203] [low, .... , high]

Now taking the middle = 107. Consider that 107 is the answer so the max page cannot be more than 107. Student 1 = 12+34, Student 2 = 67, Student 3 = 90. There are only 2 student so cannot allocate to 2 student with max page 107. So answer is more than 107.

The answer lies between [108, ..., 203] [low, ...., high]. The mid = 154. Student 1 = 12+34+67=113. Student 2 = 90. The max value 154 is possible and now the max is 154. The answer is in the left side.

The answer lies between [108, ... , 153] The res = 154. The mid = 131. The answer is possible so res = 131 and the answer lies in the left side.

The answer lies in range [108, ... , 130]. The mid is = 119. The res = 119.

The search space is [108, ..., 118]. The ans = 113. The answer is valid and the res is updated to 113.

The search space is [108, ..., 112]. The answer is not possible. The search space is [111, ..., 112] the mid 111 is not the answer then the pointer is in 112. The low moves ahead and the binary search complete and return res.