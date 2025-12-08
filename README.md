# DSA — Data Structures & Algorithms Practice

**Purpose:**

- A focused collection of data-structures and algorithms practice problems implemented primarily in Java and Python. Use this folder as a runnable reference and study repository for interview preparation.

**Recommended Runtime / Tools:**

- Java LTS: `21` (or your preferred LTS)
- Python: `3.8+` (if you use the Python solutions)
- IDE: IntelliJ IDEA or VS Code (recommended)

**Project Layout**

- `DSA/Arrays/` — Array problems and examples (Java + Python)
- `DSA/Strings/` — String manipulation problems
- `DSA/Trees/`, `DSA/Graphs/`, `DSA/Recursion/`, etc. — Problems by topic
- `DSA/Basics/` — Small exercises, sample `input.txt` / `output.txt`

Each file usually contains a single problem and a `main` that demonstrates example input → output for quick manual testing.

How to run (examples)

- Java (single-file, no package):

```bash
cd "DSA/Arrays"
javac RemoveAllAdjacentDups.java
java RemoveAllAdjacentDups
```

- Python:

```bash
python3 "DSA/Arrays/Arrays.py"
```

Notes on approaches

- The code uses efficient idioms where helpful. For example, some string problems use a fixed `char[]` + `top` index as a manual stack to avoid repeated shifting (this yields O(n) time), instead of repeatedly calling `StringBuilder.deleteCharAt()` which can be O(n) per deletion.

Conventions and style

- File-per-problem with descriptive names (e.g., `TwoSum.java`, `KadanesAlgorithm.java`).
- Prefer methods that return values (for easier unit testing) rather than printing directly.
- Keep helper methods `private` where possible; keep the main solution method `public` for quick invocation.

Adding a new problem

1. Create the new file in the appropriate topic folder.
2. Add a minimal `main` demonstrating the example input and expected output.
3. Add a single-line entry to `PROBLEMS.md` (title → path → difficulty → tags) if you keep an index.

Testing

- Manual: run the file with `javac` + `java` or `python3` as shown above.
- Optional: add JUnit tests under a `test/` folder and use Maven/Gradle or your IDE to run them.

Contribution

- Outsiders: DO NOT push directly to this repository. If you are not a repository maintainer, fork the repository, create a branch in your fork, and submit a pull request (PR). Maintainers will review and merge accepted PRs.
- Fork → create a feature branch → add the problem + example → open a PR.
- PR checklist: code compiles, includes an example `main` or unit test, follows naming conventions, and a short description in the PR.

If you are a maintainer and need direct push access, coordinate with the repo owner to be added as a collaborator; otherwise assume PR-based workflow only.
