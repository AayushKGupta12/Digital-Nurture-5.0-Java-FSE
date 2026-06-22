# Exercise 5: Triggers

---

# Scenario 1

## Update Customer Last Modified Date

### PL/SQL

```sql
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE
ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
```

### Explanation

- Trigger executes **before** a customer record is updated.
- Automatically sets the `LastModified` column to the current system date.
- Ensures every modification is timestamped without manual intervention.

---

# Scenario 2

## Maintain an Audit Log for Transactions

### PL/SQL

```sql
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT
ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID,
        AccountID,
        Amount,
        TransactionType,
        LogDate
    )
    VALUES (
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE
    );
END;
/
```

### Explanation

- Trigger executes **after** a new transaction is inserted.
- Automatically stores transaction details in the `AuditLog` table.
- Records the transaction date using `SYSDATE`.
- Helps maintain an audit trail for future reference.

---

# Scenario 3

## Check Deposit and Withdrawal Rules

### PL/SQL

```sql
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT
ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    -- Deposit amount must be positive
    IF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(
                -20001,
                'Deposit amount must be greater than zero.'
            );
        END IF;
    END IF;

    -- Withdrawal should not exceed balance
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > v_Balance THEN
            RAISE_APPLICATION_ERROR(
                -20002,
                'Insufficient account balance.'
            );
        END IF;
    END IF;

END;
/
```

### Explanation

- Trigger executes **before** inserting a transaction.
- Retrieves the current account balance.
- Validates business rules:
    - Deposit amount must be greater than **0**.
    - Withdrawal amount must not exceed the available balance.
- Prevents invalid transactions using `RAISE_APPLICATION_ERROR`.

---

# Sample Output

```text
Scenario 1
------------
Customer record updated.
LastModified = 22-JUN-2026

----------------------------------------

Scenario 2
------------
Transaction inserted successfully.
Audit log created.

----------------------------------------

Scenario 3
------------
Deposit successful.

OR

Withdrawal successful.

OR

Error: ORA-20002: Insufficient account balance.

OR

Error: ORA-20001: Deposit amount must be greater than zero.
```

## Concepts Used

- Triggers
- `BEFORE UPDATE`
- `AFTER INSERT`
- `BEFORE INSERT`
- `FOR EACH ROW`
- `:NEW`
- `SELECT ... INTO`
- `SYSDATE`
- `RAISE_APPLICATION_ERROR`
- Business Rule Validation
- Audit Logging