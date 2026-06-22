# Exercise 6: Cursors

---

# Scenario 1

## Generate Monthly Statements for All Customers

### PL/SQL

```sql
SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID,
               c.Name,
               t.TransactionID,
               t.Amount,
               t.TransactionDate
        FROM Customers c
        JOIN Transactions t
        ON c.CustomerID = t.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || rec.Name ||
            ' | Transaction ID: ' || rec.TransactionID ||
            ' | Amount: ' || rec.Amount ||
            ' | Date: ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
```

### Explanation

- Create an explicit cursor named `GenerateMonthlyStatements`.
- Retrieve all customer transactions for the current month.
- Loop through each transaction.
- Print a monthly statement using `DBMS_OUTPUT.PUT_LINE`.

---

# Scenario 2

## Apply Annual Maintenance Fee to All Accounts

### PL/SQL

```sql
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID
        FROM Accounts;

BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - 500
        WHERE AccountID = rec.AccountID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual maintenance fee applied successfully.');
END;
/
```

### Explanation

- Create an explicit cursor to fetch all account IDs.
- Loop through each account.
- Deduct a maintenance fee of **500** from every account.
- Commit the transaction after updating all accounts.
- Display a success message.

---

# Scenario 3

## Update Loan Interest Rates

### PL/SQL

```sql
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID,
               InterestRate
        FROM Loans;

BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate + 0.5
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');
END;
/
```

### Explanation

- Create an explicit cursor to fetch all loans.
- Loop through each loan record.
- Increase the interest rate according to the new policy (here, **+0.5%**).
- Commit the transaction.
- Display a confirmation message.

---

# Sample Output

```text
Scenario 1
------------
Customer: John Smith | Transaction ID: 101 | Amount: 15000 | Date: 10-JUN-2026
Customer: Alice Brown | Transaction ID: 102 | Amount: 8500 | Date: 15-JUN-2026

----------------------------------------

Scenario 2
------------
Annual maintenance fee applied successfully.

----------------------------------------

Scenario 3
------------
Loan interest rates updated successfully.
```

## Concepts Used

- Explicit Cursors
- `CURSOR`
- `FOR ... IN CURSOR`
- `DECLARE`
- `BEGIN ... END`
- `UPDATE`
- `COMMIT`
- `DBMS_OUTPUT.PUT_LINE`
- `EXTRACT`
- `TO_CHAR`
- Transaction Processing