# Assignment 4

## mod 8

### exercise 1

#### input 1

```
java TestExceptions
```

#### output 1

```
Exception caught: java.lang.ArrayIndexOutOfBoundsException: 0
Quiting...
```

#### input 2

```
java TestExceptions one two three
```

#### output 2

```
args[0] is 'one'                                             
args[1] is 'two'                                             
args[2] is 'three'                                           
Exception caught: java.lang.ArrayIndexOutOfBoundsException: 3
Quiting...                                                   
```

### exercise 2

#### input

N/A

#### output

```
Customer [Simms, Jane] has a checking balance of 200.0 with a 500.00 overdraft protection.
Checking Acct [Jane Simms] : withdraw 150.00
Checking Acct [Jane Simms] : deposit 22.50
Checking Acct [Jane Simms] : withdraw 147.62
Checking Acct [Jane Simms] : withdraw 470.00
Exception: Insufficient funds for overdraft protection   Deficit: 470.0
Customer [Simms, Jane] has a checking balance of 0.0

Customer [Bryant, Owen] has a checking balance of 200.0
Checking Acct [Owen Bryant] : withdraw 100.00
Checking Acct [Owen Bryant] : deposit 25.00
Checking Acct [Owen Bryant] : withdraw 175.00
Exception: No overdraft protection   Deficit: 50.0
Customer [Bryant, Owen] has a checking balance of 125.0
```

## mod 9

### exercise 3

#### input

N/A

#### output

```
                        CUSTOMERS REPORT
                        ================

Customer: Simms, Jane
    Savings Account: current balance is ￥500.00
    Checking Account: current balance is ￥200.00

Customer: Bryant, Owen
    Checking Account: current balance is ￥200.00

Customer: Soley, Tim
    Savings Account: current balance is ￥1,500.00
    Checking Account: current balance is ￥200.00

Customer: Soley, Maria
    Checking Account: current balance is ￥200.00
    Savings Account: current balance is ￥150.00
```

#### optional

##### input

N/A

##### output

```
                        CUSTOMERS REPORT
                        ================

Customer: Simms, Jane
    Savings Account: current balance is ￥500.00
    Checking Account: current balance is ￥200.00

Customer: Bryant, Owen
    Checking Account: current balance is ￥200.00

Customer: Soley, Tim
    Savings Account: current balance is ￥1,500.00
    Checking Account: current balance is ￥200.00

Customer: Soley, Maria
    Checking Account: current balance is ￥200.00
    Savings Account: current balance is ￥150.00
```

### exercise 4

#### input

N/A

#### output

```
                        CUSTOMERS REPORT
                        ================

Customer: Bryant, Owen
    Checking Account: current balance is 200,00 €

Customer: Simms, Jane
    Savings Account: current balance is 500,00 €
    Checking Account: current balance is 200,00 €

Customer: Soley, Maria
    Checking Account: current balance is 200,00 €
    Savings Account: current balance is 150,00 €

Customer: Soley, Tim
    Savings Account: current balance is 1.500,00 €
    Checking Account: current balance is 200,00 €
```

### exercise 5

#### input

N/A

#### output

in the directory ./doc

### exercise 6

#### input

```
java -classpath "banking.jar;." TestBanking
```

**Explaining:  **

The operation we do is to pack the `bank library` into the `jar` file, and the `-classpath` is to specified where the jvm should search for the dependence. Meanwhile, the colon is a separator and the dot means current directory. So, this parameter is supposed to tell the jvm, the class file might in the `banking.jar` or current directory. 

However, actually there is a small problem: the colon is used on *nix, while the semicolon should be used on windows. In this case, if someone run the command in the description directly, he is mostly to get the error message: `错误: 找不到或无法加载主类 TestBanking`.

Also, the `;.` is necessary, because our `TestBanking` is not in the `banking.jar`, and jvm needs to search for the `TestBanking.class` in the current directory.

#### output

```
                        CUSTOMERS REPORT
                        ================

Customer: Bryant, Owen
    Checking Account: current balance is ￥200.00

Customer: Simms, Jane
    Savings Account: current balance is ￥500.00
    Checking Account: current balance is ￥200.00

Customer: Soley, Maria
    Checking Account: current balance is ￥200.00
    Savings Account: current balance is ￥150.00

Customer: Soley, Tim
    Savings Account: current balance is ￥1,500.00
    Checking Account: current balance is ￥200.00
```

