# Exercise 4: Functions

---

# Scenario 1

## Calculate Customer Age

### PL/SQL

```sql
CREATE OR REPLACE FUNCTION CalculateAge(
    p_DOB IN DATE
)
RETURN NUMBER
IS
    v_Age NUMBER;
BEGIN
    v_Age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);

    RETURN v_Age;
END;
/
```

### Explanation

- Accept the customer's **Date of Birth** as input.
- Calculate the age using the `MONTHS_BETWEEN` function.
- Convert the result into years using `FLOOR`.
- Return the calculated age.

---

# Scenario 2

## Calculate Monthly Loan Installment

### PL/SQL

```sql
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_Years IN NUMBER
)
RETURN NUMBER
IS
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyInstallment :=
        (p_LoanAmount + (p_LoanAmount * p_InterestRate * p_Years / 100))
        / (p_Years * 12);

    RETURN v_MonthlyInstallment;
END;
/
```

### Explanation

- Accept:
    - Loan Amount
    - Interest Rate
    - Loan Duration (Years)
- Calculate the total loan amount including interest.
- Divide the total amount by the total number of monthly installments.
- Return the monthly installment.

---

# Scenario 3

## Check Sufficient Account Balance

### PL/SQL

```sql
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
)
RETURN BOOLEAN
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
```

### Explanation

- Accept the account ID and transaction amount.
- Fetch the account balance.
- Compare the balance with the required amount.
- Return:
    - `TRUE` if sufficient balance is available.
    - `FALSE` otherwise.
- If the account does not exist, return `FALSE`.

---

# Sample Output

```text
Scenario 1
------------
Age = 45 Years

----------------------------------------

Scenario 2
------------
Monthly Installment = 9,250.00

----------------------------------------

Scenario 3
------------
TRUE

OR

FALSE
```

## Concepts Used

- Functions
- `RETURN`
- Parameters (`IN`)
- `MONTHS_BETWEEN`
- `FLOOR`
- `SELECT ... INTO`
- `BOOLEAN`
- `IF...ELSE`
- Exception Handling
- `NO_DATA_FOUND`