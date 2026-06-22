# Exercise 3: Stored Procedures

---

# Scenario 1

## Process Monthly Interest for Savings Accounts

### PL/SQL

```sql
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

### Explanation

- Update all savings accounts.
- Apply **1% monthly interest** to the current balance.
- Commit the transaction if successful.
- Roll back the transaction if an error occurs.
- Display an appropriate success or error message.

---

# Scenario 2

## Update Employee Bonus

### PL/SQL

```sql
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonuses updated successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

### Explanation

- Accept the department name as a parameter.
- Accept the bonus percentage as a parameter.
- Increase the salary of every employee in that department.
- Commit the changes if successful.
- Roll back the transaction if an error occurs.
- Display an appropriate success or error message.

---

# Scenario 3

## Transfer Funds Between Accounts

### PL/SQL

```sql
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    -- Check sufficient balance
    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Funds');
    END IF;

    -- Debit source account
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccount;

    -- Credit destination account
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccount;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

### Explanation

- Accept the source account, destination account, and transfer amount as parameters.
- Fetch the balance of the source account.
- Verify that sufficient funds are available.
- Deduct the amount from the source account.
- Add the amount to the destination account.
- Commit the transaction if successful.
- Roll back the transaction if any error occurs.
- Display an appropriate success or error message.

---

# Sample Output

```text
Scenario 1
------------
Monthly interest applied successfully.

----------------------------------------

Scenario 2
------------
Employee bonuses updated successfully.

----------------------------------------

Scenario 3
------------
Funds transferred successfully.

OR

Error: ORA-20001: Insufficient Funds
```

## Concepts Used

- Stored Procedures
- Parameters (`IN`)
- `UPDATE`
- `SELECT ... INTO`
- `COMMIT`
- `ROLLBACK`
- Exception Handling
- `DBMS_OUTPUT.PUT_LINE`
- `RAISE_APPLICATION_ERROR`
- `SQLERRM`