# Simple Atm
**Simple Atm** is a Java application aimed to keeping track of one's account and bank balance. 


## *An app to keep track of bank account transaction*


- The application can add or deposit money in cents
- Anyone with a bank account who needs to keep track of their account can use it.
- This project is of interest for me because in my country people use mostly cash and thus they lose track of their 
 bank accounts.So this will help them keep track of their accounts. Also, the bank can use it to help their customers 
 and also themselves keep track of a customer. 

An example of text with **bold** and *italic* fonts.  Note that the IntelliJ markdown previewer doesn't seem to render 
the bold and italic fonts correctly but they will appear correctly on GitHub.

##***User Story***

- As a user, I want to be able to save the username and respective password for a account for security purpose and to access that account later.

- As a user I want to be able to save the total balance in my account.

- As a user, I want to be able to deposit and withdraw money from my account and save the amount after depositing or withdrawing money.

- As a user, I want to be able to load a specific account based on the username and password that I have saved.

- As a user, I want to load the amount of money in my account.

- As a user, I want to load the amount that is in my account after I had made a deposit to the account or I have withdrawn from an account.


##***Phase 4: Task 2***

Events logged:

Fri Nov 26 15:34:44 PST 2021
Account added with username abc to the list of accounts

Fri Nov 26 15:34:44 PST 2021
Account added with username jim to the list of accounts

Fri Nov 26 15:34:44 PST 2021
Account added with username sdf to the list of accounts

Fri Nov 26 15:34:44 PST 2021
Current balance of account with username abc: 80

Fri Nov 26 15:34:44 PST 2021
Current balance of account with username jim: 0

Fri Nov 26 15:34:44 PST 2021
Current balance of account with username sdf: 0

Fri Nov 26 15:34:49 PST 2021
Logged into account with username abc from the list of accounts

Fri Nov 26 15:34:52 PST 2021
Amount deposited in account with username abc: 20

Fri Nov 26 15:34:53 PST 2021
Current balance of account with username abc: 100

Fri Nov 26 15:34:57 PST 2021
Amount withdrawn from account with username abc: 50

Fri Nov 26 15:34:58 PST 2021
Current balance of account with username abc: 50

Fri Nov 26 15:35:05 PST 2021
Invalid amount entered

Fri Nov 26 15:35:10 PST 2021
Tried to withdraw more than balance in account

Fri Nov 26 15:35:15 PST 2021
Account information saved

Fri Nov 26 15:35:15 PST 2021
Account information saved

Fri Nov 26 15:35:15 PST 2021
Account information saved


##***Phase 4: Task 3***

There are associations and dependencies present. Also we can see singleton design pattern in the EventLog class.
The different methods have been broken into classes for the observer to understand better.
As for refactoring, I could have made a whole menu with the buttons for DepositMenu and WithdrawMenu and work with it.