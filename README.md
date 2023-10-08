# Lab-5
## Функціональність програми
У цій лабораторній роботі вам потрібно реалізувати надійну і стійку до помилок програму, яка імітує спрощену банківську систему. 
Ця система буде включати створення рахунків, фінансові операції і функції зведення рахунків. 
Ваше завдання полягає в тому, щоб переконатися, що програма може елегантно обробляти різні типи помилок, не ламаючись. 
Реалізуйте спеціалізовані класи винятків для обробки спеціалізованих сценаріїв помилок.
### Етапи
- Реалізуйте клас BankAccount з членами класу accountNumber, accountName і balance.
- Реалізуйте методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary().
- Створіть спеціалізовані класи винятків:
1. InsufficientFundsException
2. NegativeAmountException
3. AccountNotFoundException
- Реалізуйте клас Bank, який зберігає колекцію об'єктів BankAccount.
- У класі Bank, реалізуйте методи:
1. createAccount(String accountName, double initialDeposit)
2. findAccount(int accountNumber)
3. transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
- Обробляйте винятки відповідно в кожному методі.
- Створіть тестові класи, де ви моделюєте різні сценарії для тестування обробки виняткових ситуацій.
## Опис роботи
-Створено клас BankAccount з accountNumber, accountName і balance.
- Створено методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary() щоб виконувувати дії над балансом.
- Створено спеціальзовані класи винятки такі як:
1. InsufficientFundsException - недостатньо коштів щоб провести операцію.
2. NegativeAmountException - операція не підтримує від'ємні значення.
3. AccountNotFoundException - акаунт не був знайдений.
- Створено клас Bank який зберігає в собі об'єкти BankAccount.
- Створено також в Bank такі методи:
1. createAccount(String accountName, double initialDeposit) - створення акаунта.
2. findAccount(int accountNumber) - знаходження акаунта.
3. transferMoney(int fromAccountNumber, int toAccountNumber, double amount) - переказ коштів.
## Тестування
Було створено два класа TestBankAccount і TestBank
1. TestBankAccount має в собі такі тести:
- DepositShouldIncreaseAccountBalance - провіряє, чи збільшився баланс після депозиту.
- DepositShouldThrowNegativeAmountException - перевіряє, чи видається вийняток NegativeAmountException, якщо спробувати здійснити депозит з від'ємною сумою.
- WithdrawShouldDecreaseAccountBalance - перевіряє, чи зменшився депозит після зняття.
- WithdrawShouldThrowNegativeAmountException - перевіряє, чи видається вийняток NegativeAmountException, якщо спробувати здійснити зняття з від'ємною сумою.
- Withdraw_AmountBiggerThanBalance_ShouldThrowInsufficientFundsException - перевіряє, чи видається вийняток NegativeAmountException, якщо спробувати зняти суму, яка перевищує поточний баланс рахунку.
2. TestBank має в собі такі тести:
- FindAccountShouldReturnAccount - перевіряє, чи метод findAccount банку повертає коректний рахунок, коли введений номер рахунку, який існує в банку.
- TransferMoneyShouldThrowNegativeAmountException - перевіряє, чи видається виняток NegativeAmountException, якщо спробувати здійснити операцію переказу з від'ємною сумою.
- TransferMoneyShouldThrowInsufficientFundsException - перевіряє, чи видається виняток InsufficientFundsException, якщо спробувати здійснити операцію переказу з сумою, яка перевищує доступні кошти на рахунку.
- TransferMoneyShouldThrowAccountNotFoundException -  перевіряє, чи видається виняток AccountNotFoundException, якщо спробувати здійснити операцію переказу з номерами рахунків, які не існують в банку.
## Висновок
Було зроблено банківську систему яка вміє обробляти різни типи помилок.
