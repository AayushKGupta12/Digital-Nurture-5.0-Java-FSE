# Exercise 2: Error Handling

---

# Scenario 1

## Safe Transfer of Funds Between Accounts

### PL/SQL

```sql
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    -- Get current balance
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    -- Check for sufficient balance
    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Funds');
    END IF;

    -- Debit sender
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccount;

    -- Credit receiver
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccount;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

### Explanation

- Fetch the sender's account balance.
- Check if sufficient funds are available.
- Deduct the amount from the sender's account.
- Add the amount to the receiver's account.
- Commit the transaction if successful.
- If any error occurs:
    - Roll back the transaction.
    - Display the error message using `SQLERRM`.

---

# Scenario 2

## Update Employee Salary

### PL/SQL

```sql
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmpID IN NUMBER,
    p_Percentage IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmpID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

### Explanation

- Increase the employee's salary by the given percentage.
- Check whether any row was updated.
- If no employee exists with the given ID:
    - Raise a `NO_DATA_FOUND` exception.
- Roll back the transaction if another error occurs.
- Display the appropriate error message.

---

# Scenario 3

## Add a New Customer

### PL/SQL

```sql
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_CustomerID IN NUMBER,
    p_Name IN VARCHAR2,
    p_Balance IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers(CustomerID, Name, Balance)
    VALUES (p_CustomerID, p_Name, p_Balance);

    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

### Explanation

- Insert a new customer into the `Customers` table.
- Commit the transaction if successful.
- If a duplicate `CustomerID` already exists:
    - Handle the `DUP_VAL_ON_INDEX` exception.
    - Display an appropriate error message.
- Roll back the transaction if any other error occurs.

---

# Sample Output

```text
Scenario 1
------------
Funds transferred successfully.

OR

Error: ORA-20001: Insufficient Funds

----------------------------------------

Scenario 2
------------
Salary updated successfully.

OR

Error: Employee ID not found.

----------------------------------------

Scenario 3
------------
Customer added successfully.

OR

Error: Customer ID already exists.
```

## Concepts Used

- Stored Procedures
- Exception Handling
- `BEGIN ... END`
- `EXCEPTION` Block
- `ROLLBACK`
- `COMMIT`
- `SQLERRM`
- `RAISE_APPLICATION_ERROR`
- `NO_DATA_FOUND`
- `DUP_VAL_ON_INDEX`
- `SQL%ROWCOUNT`