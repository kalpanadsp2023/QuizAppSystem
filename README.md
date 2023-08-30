Rewards Redemption System is a stand alone application designed to develope a system which helps in redemption of the rewards with a user account.
Assumptions:
Total 5 users are existing in the system with UserName in the format of User<n> i.e. User1, User2 etc and password in format of user<n> i.e. user1, user2, etc.
The application starts with the user to login to the system by providing Username & password.
In background a demon thread is working continuosly to credit the User account with rewards points based on random user and transaction amount.
Once the user successfully logins. They are now ready to check on with the redemption options available if the existing points are sufficient enough they are deducted from the user account 
and a coupon code is generated and given to the user for redemption.
This redemption process loops till the user wants to exit the system with displaying the redemption history made by the User.
