# Final Testing Project Report — Calculator Web Application

**Repository:** `NobiskumDeus/Project-checkpoint-calculator`  
**Testing stack:** Java, Maven, JUnit 4 legacy tests, JUnit 5, JaCoCo, GitHub Actions

## 1. Repository overview

The project is a small Java Maven calculator web application. The central `CalculatorService` class exposes a greeting endpoint and arithmetic operations for addition, subtraction, multiplication, and integer division. Each arithmetic method creates a `CalculatorResponse`, which stores the input operands, calculated result, and a timestamp. The application is packaged as a WAR. The course work adds JUnit 5 tests, JaCoCo coverage reporting, and a GitHub Actions workflow that builds and tests the project on pushes and pull requests to `main`.

## 2. Testing techniques applied

The suite combines black-box and white-box techniques. Black-box tests assert observable results without depending on implementation details: for example, adding 8 and 26 returns 34, subtracting 8 from 12 returns 4, multiplying 11 by 8 returns 88, and dividing 20 by 5 returns 4. The `ping` test checks the stable greeting rather than the changing timestamp.

Equivalence partitioning is represented by positive, negative, and zero operands, negative results, exact division, and division with a fractional remainder. Boundary tests exercise zero and Java integer limits. They also document Java's defined `int` overflow behavior. That behavior is tested for consistency, but the tests alone do not establish that overflow wraparound is the ideal user-facing requirement. Division by zero is an exceptional input class and is expected to throw `ArithmeticException` for Java integer division.

White-box path tests follow each arithmetic method's normal straight-line path and the exceptional division-by-zero path. The response tests verify values through getters after object construction. This makes tests more descriptive and less repetitive by using clear method names and `@DisplayName` descriptions.

## 3. CFG and DU discussion

The arithmetic methods have a simple control-flow graph: entry, parameter values, one arithmetic expression, response construction, return. There are no explicit conditional statements or loops in these methods. Division has an additional exceptional exit when the denominator is zero. The CFG is documented in `docs/CFG_DU_ANALYSIS.md`. Because the source has no explicit decision nodes, JaCoCo may display branch coverage as not applicable or zero; branch coverage should not be misinterpreted as a full assessment of exceptional behavior.

The data-flow analysis focuses on `CalculatorResponse`. Its constructor defines `_x`, `_y`, `_result`, and `_time`; `getX()`, `getY()`, `getResult()`, and `getTime()` use those values. JUnit tests construct a response and read all four values through their getters. The arithmetic methods also pass their computed values to the response constructor, and tests assert those results for representative input partitions.

## 4. Coverage results and interpretation

The final Week 7 GitHub Actions run completed successfully with 29 tests (29 passed, 0 failures, 0 errors, 0 skipped) and generated the following JaCoCo CSV totals.

| JaCoCo metric | Week 7 result | Interpretation |
|---|---:|---|
| Instructions | **100% (81/81 covered)** | All instructions in the two analyzed application classes were exercised. |
| Lines | **100% (16/16 covered)** | All executable source lines in the two analyzed classes were reached. |
| Methods | **100% (11/11 covered)** | All reported methods were exercised. |
| Branches | **N/A (0 branches)** | JaCoCo reports no explicit branch outcomes in these two classes. |
| Classes | **100% (2/2 covered)** | Both application classes were analyzed and exercised. |

**Detailed results:** `CalculatorService` — 51/51 instructions, 6/6 lines, and 6/6 methods covered. `CalculatorResponse` — 30/30 instructions, 10/10 lines, and 5/5 methods covered. Both classes have 0 branches, so branch coverage is not applicable.\n\n**Required screenshots:** Add `docs/jacoco-summary.png` (the JaCoCo table) and `docs/jacoco-detail.png` (a class-detail view) after capturing them from the final run. The percentages above come from the actual CI-generated `jacoco.csv`; screenshots remain a separate submission requirement.

Uncovered elements should be evaluated individually. A getter may be simple, but testing it can verify the constructor-to-accessor DU pair and protect against future changes. A changing timestamp should be checked for non-null/non-empty behavior rather than compared to a hard-coded time. Web-container routing and JSON serialization remain outside this unit suite, so their absence is a scope limitation rather than evidence that the core arithmetic methods are untested. The final report should name any uncovered methods shown by the actual detailed JaCoCo view and state whether each warrants additional tests.

## 5. CI pipeline and software quality

The GitHub Actions workflow checks out the code, configures Temurin JDK 17, and runs `mvn -B clean package` for pushes and pull requests targeting `main`. Maven runs the configured tests and JaCoCo report generation. The workflow also attempts to upload the HTML coverage report as an artifact. A successful run provides repeatable evidence that the checked-in project builds and its configured tests pass in a clean CI environment.

The suite improves confidence in arithmetic behavior, boundary behavior, the division-by-zero exception, and response field use. The current application remains small and its service methods have few control-flow decisions, so line and method coverage should be interpreted alongside the input partitions and exception tests. Coverage measures execution, not whether every assertion is meaningful or whether the requirements themselves are complete.

## 6. Next steps

Further work should add integration tests for HTTP routes, query-parameter handling, JSON serialization, and response status codes. Requirements should explicitly state how overflow and division by zero should be handled at the API boundary. Tests could then assert those requirements rather than merely documenting Java's default behavior. The CI workflow should remain required for future changes, and the JaCoCo summary/detail screenshots should be refreshed after each meaningful test-suite change.

**CI evidence:** Add `docs/week7-ci-success.png` after a successful Week 7 GitHub Actions run. The screenshot should show the workflow name, green success status, branch/commit, and run time.
