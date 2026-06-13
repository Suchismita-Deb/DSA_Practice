arr[] = {5,2,1}  

When the array size is 3 then rthere are total of 8 subsets. 2^N subset.

Brute Force - Generate all the subset. Power set - Using bit manipulation - 2^N X N.

Recursive.

[0,1,2] - index.
[pick, non-pick, pick]  
When at 0th index not decided pick or non pick.

```scss

subsetSumsHelper(0, 0)
├─ Pick 5 → subsetSumsHelper(1, 5)                     →①
│  ├─ Pick 2 → subsetSumsHelper(2, 7)                  →②
│  │  ├─ Pick 1 → subsetSumsHelper(3, 8)  → Leaf: 8    →③
│  │  └─ Skip 1 → subsetSumsHelper(3, 7)  → Leaf: 7    →④
│  └─ Skip 2 → subsetSumsHelper(2, 5)                  →⑤
│     ├─ Pick 1 → subsetSumsHelper(3, 6)  → Leaf: 6    →⑥
│     └─ Skip 1 → subsetSumsHelper(3, 5)  → Leaf: 5    →⑦
└─ Skip 5 → subsetSumsHelper(1, 0)                     →⑧
├─ Pick 2 → subsetSumsHelper(2, 2)                  →⑨
│  ├─ Pick 1 → subsetSumsHelper(3, 3)  → Leaf: 3    →⑩
│  └─ Skip 1 → subsetSumsHelper(3, 2)  → Leaf: 2    →⑪
└─ Skip 2 → subsetSumsHelper(2, 0)                  →⑫
├─ Pick 1 → subsetSumsHelper(3, 1)  → Leaf: 1    →⑬
└─ Skip 1 → subsetSumsHelper(3, 0)  → Leaf: 0    →⑭

```