# Analytical Report: Minimum Spanning Tree Algorithm Implementation

#### **Student:** Asylan Usen  
#### **Course:** Design and Analysis of Algorithms  
#### **Assignment:** 3 - City Transportation Network Optimization  

## Overview

This project focuses on the **implementation and comparison of two Minimum Spanning Tree (MST) algorithms** — **Prim’s** and **Kruskal’s** — applied to model **city transportation networks**.

Both algorithms were implemented, and analyzed using two different graph configurations (a five-district and a four-district network).  
Performance metrics such as **operation count**, **execution time**, and **result correctness** were evaluated to determine which algorithm performs better under different graph densities.

---

## 1. Summary of Input Data and Algorithm Results

### 1.1 Input Data

**Graph 1: Five-District Network**
- Vertices: 5 (A, B, C, D, E)
- Edges: 7

**Graph 2: Four-District Network**
- Vertices: 4 (A, B, C, D)
- Edges: 5

### 1.2 Results

| Graph  | Algorithm   | MST Cost | Operations | Time (ms) |
|---------|-------------|-------|-------------|------------|
| Graph 1 | Prim's      | 16   | 42          | 0.69       |
| Graph 1 | Kruskal's   | 16   | 37          | 1.37       |
| Graph 2 | Prim's      | 6    | 29          | 0.06       |
| Graph 2 | Kruskal's   | 6    | 31          | 0.05       |

**Key Findings:**
- Both algorithms produced identical MST costs (correctness verified).
- **Graph 1:** Kruskal's used 12% fewer operations, but Prim's executed 50% faster.
- **Graph 2:** Similar performance for both algorithms.

---

## 2. Algorithm Comparison

### 2.1 Performance Analysis

| Aspect | Prim's Algorithm | Kruskal's Algorithm |
|--------|------------------|----------------------|
| **Approach** | Vertex-centric (grows from one vertex) | Edge-centric (processes all edges) |
| **Data Structure** | Priority Queue + Adjacency List | Edge List + Union-Find |
| **Time Complexity** | O((V + E) log V) | O(E log E) |
| **Space Complexity** | O(V + E) | O(V + E) |
| **Best For** | Dense graphs (E ≈ V²) | Sparse graphs (E ≈ V) |
| **Implementation** | Simpler (standard priority queue) | Requires Union-Find |

### 2.2 Efficiency Comparison

**Operation Count Formulas:**
- Prim's: `5V + 4E - 11`
- Kruskal's: `4V + E + 10`

**Graph 1 Analysis:**
- Kruskal's performed **12% fewer operations** (37 vs 42).
- Prim's had **faster execution** due to less sorting overhead.

**Graph 2 Analysis:**
- Comparable operation counts (within 7%).
- Similar execution times.

---

## 3. Conclusions

### 3.1 Algorithm Selection Guidelines

**Choose Prim's Algorithm when:**
- Graph is dense (many edges: E ≈ V²).
- Graph stored as adjacency list or matrix.
- Simpler implementation is preferred.
- Need faster execution for small graphs.

**Choose Kruskal's Algorithm when:**
- Graph is sparse (few edges: E ≈ V).
- Graph stored as edge list.
- Optimal operation count is required.
- Parallel processing capability is needed.


### 3.2 Final Verdict

For **city transportation networks**:
- **Small cities:** Either algorithm works well.
- **Sparse road networks:** Prefer **Kruskal's** (confirmed by 12% fewer operations in Graph 1).
- **Dense road networks:** Prefer **Prim's** (faster execution, better complexity).
- **General-purpose:** Prim's offers simpler implementation with predictable performance.

> Both algorithms are correct and efficient for small graphs.  
> The choice becomes significant for large-scale networks (1000+ vertices).

---

## 4. References


1. Prim, R. C. (1957). *Shortest connection networks and some generalizations*. Bell System Technical Journal, 36(6), 1389–1401.
2. Kruskal, J. B. (1956). *On the shortest spanning subtree of a graph*. Proceedings of the AMS, 7(1), 48–50.
3. Also it was useful to read from https://lms.astanait.edu.kz/pluginfile.php/67477/mod_resource/content/0/Lecture_6-Disjoint_sets_MST.pdf
---

## Also, proper commit storyline

<img src="https://github.com/Asylann/DAA_3/blob/main/CommitStoryline.png" alt="git log Screenshot"/>

## Thanks for your attention !!!
