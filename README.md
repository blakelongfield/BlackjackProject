## Blackjack Project

#### Week 3 Skill Distillery Weekend Homework

### Overview
https://github.com/SkillDistillery/SD17/blob/master/java2/Blackjack/images/Blackjack.png?raw=true
// this will be fixed, I couldn't figure out how to get the image of the UML imported. 

This program's purpose is to simulate a game of blackjack for the user. Once the program has been started, the user will be asked whether they want to start a game or not. If the user chooses to play a game, they will be dealt two cards face up, and the house will be dealt one card face up and one hidden. The user will be given both the dealers and their own cards suit, rank, and the value of their hand. These values will be stored in a separate package, so they are imported in. The values of rank and suit are stored as enumerated types, so they are unable to be changed. 

The user will be asked whether they would like to hit (add a new card to their hand) until they would like to stay or their hand busts. The value of the users hand will be kept track of while adding more cards to their deck. If the user stays with a hand of value less than 21, the dealer will then reveal their hidden card and decide whether or not it is appropriate to hit or stay. The dealer will stay with a hand value of 17 or more and will hit on a hand value of 16 or less. Once the dealer has gone through its hand, the user will be shown who the winner is. 

This is all possible by keeping track of the value of the user and dealers hands throughout the program. Each time a card is added to a hand, the value of that hand is then run through a few if statements where it will decide whether the game should continue or someone has bust.  

### Technologies
1. Imports
2. If/else statements
3. The use of Abstraction, Polymorphism, Inheritance, and Encapsulation
4. For loops
5. Lists
6. The use of "getters and setters"
7. Constructors 
8. Enumerated types
9. Hashcodes

### Lessons Learned
I learned very early on, with so many different variables, the importance of naming your variables very specific so you know what you are referencing throughout the code.  