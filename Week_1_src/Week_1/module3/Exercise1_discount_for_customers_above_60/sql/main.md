# Exercise 1: Control Structures

---

# Scenario 1

## Apply a 1% Discount to Loan Interest Rates for Customers Above 60

### PL/SQL

```sql
BEGIN
    FOR rec IN (
        SELECT c.CustomerID,
               c.DOB,
               l.LoanID,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;

    COMMIT;
END;
/
```

### Explanation

- Fetch all customers along with their loans.
- Calculate customer age using `MONTHS_BETWEEN`.
- If age is greater than **60**:
    - Reduce the loan interest rate by **1%**.
- Save the changes using `COMMIT`.

---

# Scenario 2

## Promote Customers to VIP

### PL/SQL

```sql
BEGIN
    FOR rec IN (
        SELECT CustomerID,
               Balance
        FROM Customers
    )
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/
```

### Explanation

- Loop through every customer.
- Check the account balance.
- If the balance exceeds **10000**:
    - Set `IsVIP` to `'TRUE'`.
- Commit the changes.

---

# Scenario 3

## Print Loan Reminder Messages

### PL/SQL

```sql
SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.Name ||
            ', your Loan ID ' || rec.LoanID ||
            ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
```

### Explanation

- Fetch all loans that are due within the next **30 days**.
- Loop through each loan record.
- Print a reminder message for every customer using `DBMS_OUTPUT.PUT_LINE`.

### Sample Output

```text
Reminder: Dear John Smith, your Loan ID 101 is due on 15-JUL-2026
Reminder: Dear Alice Brown, your Loan ID 103 is due on 20-JUL-2026
Reminder: Dear David Lee, your Loan ID 110 is due on 05-JUL-2026
```