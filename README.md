# Assignment 3 — Minimum Spanning Tree (Prim & Kruskal)

This project implements Prim's and Kruskal's algorithms in Java. It reads `ass_3_input.json` (project root) and writes results to `ass_3_output.json`.

How to compile and run (Windows PowerShell):

```powershell
cd C:/Users/usena/IdeaProjects/DAA_3
javac -d out src/assignment3/*.java
java -cp out assignment3.Main
```

You can pass custom input/output paths as arguments:

```powershell
java -cp out assignment3.Main path/to/input.json path/to/output.json
```

Notes:
- The parser is a small ad-hoc parser tailored to the provided JSON template (no external JSON libs used).
- Operation counts are approximated by counting key algorithmic actions (priority queue operations, disjoint-set operations).
