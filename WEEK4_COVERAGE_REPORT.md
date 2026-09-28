# Week 4 Project Checkpoint — JaCoCo Code Coverage Report

## Project
Java Maven Calculator Web App

## 1. Coverage Setup

For the Week 4 checkpoint, JaCoCo was added to the Maven `pom.xml` so that test execution produces a standard HTML coverage report.

The JaCoCo report is generated under:

`target/site/jacoco/index.html`

Run the following from the project root:

```bash
mvn clean test
```

After the build completes, open `target/site/jacoco/index.html`.

> **Important:** The percentage values below must be filled in from the generated JaCoCo report. They are intentionally not invented.

### JaCoCo Summary

| Metric | Coverage |
|---|---:|
| Instructions | **[FILL FROM JACOCO]** |
| Branches | **[FILL FROM JACOCO]** |
| Lines | **[FILL FROM JACOCO]** |
| Methods | **[FILL FROM JACOCO]** |
| Classes | **[FILL FROM JACOCO]** |

## 2. Covered and Uncovered Code

The main application class is `CalculatorService`. The existing test suite exercises the calculator's normal operations:

- `ping()`
- `Add()`
- `Sub()`
- `Mul()`
- `Div()`

The Week 2 work also includes a JUnit 5 test class with two tests. This gives the project additional coverage while preserving the original tests.

A useful edge case for the Week 4 analysis is division by zero. The `Div()` method performs:

```java
return new CalculatorResponse(x, y, x / y);
```

There is no explicit zero-denominator check in the application code. Therefore, a call such as `Div(10, 0)` results in an `ArithmeticException`.

This is an example of a path that deserves consideration even though the normal division test is already covered. Coverage tools measure executed code, but high coverage does not automatically mean that every important input condition has been tested.

### Example uncovered/under-tested scenario

**Scenario:** division where `y == 0`.

**Why it is not currently tested:** The existing division test uses equal non-zero values (`12 / 12`). The test suite verifies the normal division behavior but does not exercise invalid division input.

**Why this matters:** A production web service should have a defined behavior for a zero denominator. Depending on the intended API design, the application could reject the request, return an error response, or otherwise handle the invalid input explicitly.

## 3. Screenshot Requirement

Insert a screenshot of the JaCoCo summary table here.

**Screenshot:** `[INSERT target/site/jacoco/index.html summary screenshot]`

The screenshot should clearly show the overall instruction, branch, line, method, and class percentages.

## 4. Reflection — Improving Coverage

Coverage can be improved in future weeks by adding tests for both normal and edge-case inputs. For this calculator application, useful additions include:

1. Division by zero.
2. Addition/subtraction using negative numbers.
3. Multiplication involving zero.
4. Integer overflow behavior for very large values.
5. Boundary values such as `Integer.MAX_VALUE` and `Integer.MIN_VALUE`.
6. API-level tests for invalid request parameters if those behaviors are defined.

The most useful approach is not simply to maximize the percentage. Tests should target behavior that could realistically fail or cause unexpected results.

## 5. Is Every Uncovered Area Worth Testing?

Not necessarily. Code coverage is a measurement tool rather than a guarantee of software quality. A low-value getter, generated code, framework configuration, or code that cannot realistically be reached may not deserve the same testing effort as business logic.

However, uncovered application behavior should be reviewed intentionally. In this project, division by zero is more valuable to test than merely adding another test with ordinary positive integers because it represents an input condition that can cause a runtime exception.

## 6. Conclusion

The Week 4 checkpoint adds JaCoCo coverage reporting to the Maven project and builds on the JUnit testing work completed in Week 2. The existing tests cover the calculator's primary operations, while the coverage review identifies edge cases that can be addressed in future iterations.

The main lesson from this checkpoint is that coverage percentages are useful for finding testing gaps, but the goal should be meaningful tests of important behavior rather than achieving a particular percentage at any cost.

---

## Submission Checklist

- [x] Week 2 project used as the starting point
- [x] JaCoCo Maven configuration added
- [ ] Run `mvn clean test`
- [ ] Confirm `target/site/jacoco/index.html` is generated
- [ ] Record overall coverage percentages
- [ ] Take JaCoCo summary screenshot
- [ ] Add screenshot to this report
- [ ] Mention at least one uncovered/under-tested path
- [x] Explain why the path is not currently tested
- [x] Explain how coverage can improve in future weeks
- [x] Discuss whether all uncovered areas need tests
