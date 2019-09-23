# Assignment 2

## mod05

### exercise1

#### input

N/A

#### output

```
<0, 3, 2, 7, 4, 13, 6, 19>
matrix[0] is <>
matrix[1] is <0>
matrix[2] is <0, 2>
matrix[3] is <0, 3, 6>
matrix[4] is <0, 4, 8, 12>
```

### exercise2

#### input

N/A

#### output

```
Customer [1] is Simms, Jane
Customer [2] is Bryant, Owen
Customer [3] is Soley, Tim
Customer [4] is Soley, Maria
```

## mod06

### alternate1

#### input

N/A

#### output

```
Checking Acct [Jane Simms] : withdraw 150.00 succeeds? true
Checking Acct [Jane Simms] : deposit 22.50 succeeds? true
Checking Acct [Jane Simms] : withdraw 147.62 succeeds? true
Customer [Simms, Jane] has a checking balance of 0.0 and a savings balance of 424.88

Checking Acct [Owen Bryant] : withdraw 100.00 succeeds? true
Checking Acct [Owen Bryant] : deposit 25.00 succeeds? true
Checking Acct [Owen Bryant] : withdraw 175.00 succeeds? false
Customer [Bryant, Owen] has a checking balance of 125.0
```

### exercise1

#### input

N/A

#### output

```
Creating the customer Jane Smith.
Creating her Savings Account with a 500.00 balance and 3% interest.
Creating the customer Owen Bryant.
Creating his Checking Account with a 500.00 balance and no overdraft protection.
Creating the customer Tim Soley.
Creating his Checking Account with a 500.00 balance and 500.00 in overdraft protection.
Creating the customer Maria Soley.
Maria shares her Checking Account with her husband Tim.

Retrieving the customer Jane Smith with her savings account.
Withdraw 150.00: true
Deposit 22.50: true
Withdraw 47.62: true
Withdraw 400.00: false
Customer [Simms, Jane] has a balance of 324.88

Retrieving the customer Owen Bryant with his checking account with no overdraft protection.
Withdraw 150.00: true
Deposit 22.50: true
Withdraw 47.62: true
Withdraw 400.00: false
Customer [Bryant, Owen] has a balance of 324.88

Retrieving the customer Tim Soley with his checking account that has overdraft protection.
Withdraw 150.00: true
Deposit 22.50: true
Withdraw 47.62: true
Withdraw 400.00: true
Customer [Soley, Tim] has a balance of 0.0

Retrieving the customer Maria Soley with her joint checking account with husband Tim.
Deposit 150.00: true
Withdraw 750.00: false
Customer [Soley, Maria] has a balance of 150.0
```

### exercise2

#### input

N/A

#### output

```
			CUSTOMERS REPORT
			================

Customer: Simms, Jane
	Savings Account current balance is ￥500.00
	Checking Account current balance is ￥200.00


Customer: Bryant, Owen
	Checking Account current balance is ￥200.00


Customer: Soley, Tim
	Savings Account current balance is ￥1,500.00
	Checking Account current balance is ￥200.00


Customer: Soley, Maria
	Checking Account current balance is ￥200.00
	Savings Account current balance is ￥150.00
```

