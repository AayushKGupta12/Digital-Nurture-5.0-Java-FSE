# Exercise 7: Packages

---

# Database Schema

## Customers Table

```sql
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);
```

## Accounts Table

```sql
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
```

## Transactions Table

```sql
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
```

## Loans Table

```sql
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
```

## Employees Table

```sql
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);
```

---

# Sample Data

```sql
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'),1000,SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'),1500,SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1,1,'Savings',1000,SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2,2,'Checking',1500,SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1,1,SYSDATE,200,'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2,2,SYSDATE,300,'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1,1,5000,5,SYSDATE,ADD_MONTHS(SYSDATE,60));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1,'Alice Johnson','Manager',70000,'HR',TO_DATE('2015-06-15','YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2,'Bob Brown','Developer',60000,'IT',TO_DATE('2017-03-20','YYYY-MM-DD'));
```

---

# Scenario 1

## CustomerManagement Package

### Package Specification

```sql
CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_Balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_CustomerID NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/
```

### Package Body

```sql
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers
        VALUES (
            p_CustomerID,
            p_Name,
            p_DOB,
            p_Balance,
            SYSDATE
        );
    END;

    PROCEDURE UpdateCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_Balance NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name,
            Balance = p_Balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;
    END;

    FUNCTION GetCustomerBalance(
        p_CustomerID NUMBER
    )
    RETURN NUMBER
    IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;

        RETURN v_Balance;
    END;

END CustomerManagement;
/
```

### Explanation

- Add a new customer.
- Update customer information.
- Retrieve the current customer balance.

---

# Scenario 2

## EmployeeManagement Package

### Package Specification

```sql
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_EmployeeID NUMBER,
        p_Salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_EmployeeID NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/
```

### Package Body

```sql
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Employees
        VALUES (
            p_EmployeeID,
            p_Name,
            p_Position,
            p_Salary,
            p_Department,
            SYSDATE
        );
    END;

    PROCEDURE UpdateEmployee(
        p_EmployeeID NUMBER,
        p_Salary NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET Salary = p_Salary
        WHERE EmployeeID = p_EmployeeID;
    END;

    FUNCTION CalculateAnnualSalary(
        p_EmployeeID NUMBER
    )
    RETURN NUMBER
    IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_Salary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;

        RETURN v_Salary * 12;
    END;

END EmployeeManagement;
/
```

### Explanation

- Hire a new employee.
- Update employee salary.
- Calculate annual salary by multiplying monthly salary by **12**.

---

# Scenario 3

## AccountOperations Package

### Package Specification

```sql
CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_AccountType VARCHAR2,
        p_Balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_AccountID NUMBER
    );

    FUNCTION GetTotalBalance(
        p_CustomerID NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/
```

### Package Body

```sql
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID NUMBER,
        p_CustomerID NUMBER,
        p_AccountType VARCHAR2,
        p_Balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts
        VALUES (
            p_AccountID,
            p_CustomerID,
            p_AccountType,
            p_Balance,
            SYSDATE
        );
    END;

    PROCEDURE CloseAccount(
        p_AccountID NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
    END;

    FUNCTION GetTotalBalance(
        p_CustomerID NUMBER
    )
    RETURN NUMBER
    IS
        v_Total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_Total
        FROM Accounts
        WHERE CustomerID = p_CustomerID;

        RETURN NVL(v_Total,0);
    END;

END AccountOperations;
/
```

### Explanation

- Open a new account.
- Close an existing account.
- Calculate the total balance across all accounts belonging to a customer.

---

# Sample Output

```text
Scenario 1
------------
Customer added successfully.
Customer details updated successfully.
Customer Balance = 1500

----------------------------------------

Scenario 2
------------
Employee hired successfully.
Employee details updated successfully.
Annual Salary = 840000

----------------------------------------

Scenario 3
------------
Account opened successfully.
Account closed successfully.
Total Balance = 2500
```

## Concepts Used

- Packages
- Package Specification
- Package Body
- Procedures
- Functions
- `INSERT`
- `UPDATE`
- `DELETE`
- `SELECT ... INTO`
- `SUM()`
- `NVL()`
- Modular Programming