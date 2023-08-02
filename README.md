# Simple-CLI-Banking-Application
This is a simple command line interface (CLI) banking application that uses arrays to store usernames, passwords, and account balances. Users can log in, view their balance, transfer funds to other users, and withdraw funds from their account.

Here is a brief overview of the code:

The program begins by presenting the user with a menu of options: login, create an account, or close the program.

If the user selects "login," they are prompted to enter their username and password. If the credentials are valid, the user is greeted by name and presented with a new menu of options: view balance, transfer funds, withdraw funds, or logout.

If the user selects "create an account," they are prompted to enter a new username, password, and initial balance. The program then adds this new account to its list of users.

If the user selects "view balance," they are shown their current balance.

If the user selects "transfer funds," they are prompted to enter the username of the person they wish to transfer funds to, as well as the amount they wish to transfer. The program then updates the account balances accordingly.

If the user selects "withdraw funds," they are prompted to enter the amount they wish to withdraw. If the amount is within the allowed range (between $100 and $20,000), the program deducts the amount from the user's account balance.

If the user selects "logout," they are logged out of the system and returned to the original menu.

The program uses several arrays to store user data, including usernames, passwords, and account balances. It also includes methods for each of the program's main functions, as well as some helper methods for error checking and clearing the console.

usernames, passwords, and amount_in_account are three arrays that store usernames, passwords, and account balances respectively.

choose() method prints a menu and prompts the user to select an option. Based on the selected option, the method calls other methods such as login(), create(), and close().

login() method prompts the user to enter a username and checks if the username exists in the usernames array. If the username exists, it calls the login_password() method to check if the entered password matches the password stored in the passwords array.

login_password() method checks if the entered password matches the password stored in the passwords array. If the password matches, it calls the menu() method to display the banking options.

menu() method prints a menu and prompts the user to select an option. Based on the selected option, the method calls other methods such as transfer(), withdraw(), and choose().

transfer() method prompts the user to enter the name of the user they want to transfer money to and checks if the entered username exists in the usernames array. If the username exists, it calls the transfer_1() method to prompt the user to enter the transfer amount and transfer the funds.

transfer_1() method prompts the user to enter the transfer amount and checks if the entered amount is valid. If the amount is valid, it transfers the funds from the user's account to the recipient's account.

withdraw() method prompts the user to enter the amount they want to withdraw and checks if the entered amount is valid. If the amount is valid, it withdraws the funds from the user's account.
