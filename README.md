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

- As a user(bank) I want to be able to add money to my account. 

Suppose one day a person deposited some money in my bank . Now, I want that amount to be added to that person's account 
otherwise I might be cased with fraud for stealing money. A person will randomly add money to his account so I need to be 
able to keep track of how much that have included. 

 So, I included a class  **Account** which will keep track of one's transaction. And added the **deposit** feature which will add amount
 deposited to balance. 

Also, it can be used by common users to add money to their own accounts and, they can keep track of how much money they 
are adding to their account. 

- As a user I want to be able to take money out of my account.

As a user I definitely want to allow people to  withdraw or takeout money from their account. And also I need to keep 
track of how much money they have withdrawn to provide them with that amount. If someone has sufficient balance, I need 
allow them to withdraw their required money, so they can use it. If I don't allow people to withdraw money I might get 
into trouble. However, I also need to check if someone has enough balance to withdraw the amount they are trying to 
withdraw, otherwise they might withdraw more than allowed and get me into trouble.

So, i included a **withdraw** method in class **Account** which will deduct money in cents if sufficient balance is 
present or present an error when sufficient money is not present. 

Also, people can use it to keep track of how much money they have withdrawn and if they have gone over their balance.

- As a user, I want to be able to see the balance.

I want to see obviously how much money someone has in their bank account to have an idea of the amount. Depending on how
more money one keeps in the account I might provide them more facilities. Also, I need to be able to see their balance 
to see if they have enough balance.

For this, I included a process in my *main* class to call the getter to get me my balance and print the balance for me to 
see.

- As a user, I want to provide a unique username and password for safety and also to distinguish users. If I don't 
include a username people might not be able to access their account and also I might not be able to keep track of their
accounts. 

For common users it's also a process to ensure safety as they have a secret and unique username and password.

So, I included the **setUsername** and **setPassword** method in **Account** class to include these features in an 
account.


