# Contributing Guidelines — DSA

Thank you for your interest in contributing. This file explains how to contribute safely and consistently.

1. Contribution policy

- Outsiders: Do not push directly to this repository's branches. If you are not a repository maintainer, fork the repository and submit contributions via pull requests (PRs) from your fork. Maintainers will review and merge accepted PRs.
- Maintainers: Only designated maintainers should push to protected branches. If you need push access, ask the repository owner.

2. How to submit a contribution (recommended workflow)

- Fork the repository.
- Create a branch in your fork with a short descriptive name, e.g., `feature/add-two-sum-java` or `fix/remove-adj-dup-bug`.
- Add your code in the appropriate `DSA/<topic>/` folder. Keep one problem per file and include a small `main` demonstrating input→output for manual testing.
- Run any local tests you have and ensure your code compiles.
- Update `DSA/PROBLEMS.md` with a one-line entry for your problem (title → path → language). If you add multiple problems, include them in the index.
- Open a PR from your fork/branch into this repository's `main` branch. In the PR description include: what you changed, one example input→output, and any notes (complexity, requirements).

3. PR checklist

- The change compiles (Java: `javac`, Python: `python3` as applicable).
- New files include an example `main` or a basic test demonstrating usage.
- Follow naming and folder conventions (`DSA/<topic>/YourProblem.java`).
- Small, focused PRs are preferred.

4. Code style & tests

- Prefer clarity and readability. Keep helper methods `private` where appropriate.
- For Java, prefer simple `public` methods that return solution values (easy to test).
- If adding tests, include them under a `test/` folder and mention how to run them in the PR.

5. Commit messages

- Use clear, concise commit messages (imperative tense): e.g., `Add TwoSum solution (Java)` or `Fix RemoveAllAdjacentDups edge case`.

6. Licensing

- By contributing you agree to license your contributions under the project's license. If you plan to publish this repo, ensure a `LICENSE` file is present at repository root.

7. Security & sensitive data

- Do not include secrets, API keys, or personal data in commits.

8. Need help?

- Open an issue describing what you'd like to add and a maintainer will respond.

Thank you for keeping contributions clean and reviewable — fork, branch, PR.
