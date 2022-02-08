# Checkers

A Checkers game made using Java and Eclipse.

## Background

This project was created to test my experience in Java. Looking back at it now I can see many aspects where I can make improvements in my code and UI. Additionally, my code organization has improved greatly since working on this project. 

## Features
```
Music: The user has the option to play music when the application is launched.
Classic mode: Standard checkers rule set where if you have the option to take a piece you must take it.
Free mode: Checkers where the user has the option to decide what move they have and aren't forced to take a piece. 
```

## Analysis
In a basic sense our program just plays checkers, but in actuality it involves many complex functions and around 600-700 lines of code. The first thing the program does is create a JOptionPanes that asks if the player wants ; the music on, the sound effects on, and the mode gamemode they want to play on. When the player clicks on these options there is a boolean that is activated that will tell these extras to turn on or off. After the JOptionPanes, the checkerboard opens up and the player is able to play the game. The game starts on a red turn and once a red piece is pressed yellow squares appear showing the open spots that the piece can move to. Once the red player clicks on a yellow square the piece moves and it becomes a blues turn. When blue makes its move it switches to red turn. If red is able to eat a piece it shows up as a purple arrow. Depending on whether the game is in classic mode the player will be forced to move on the arrow. If not then the player is able to move any piece, but the arrows will still show up as a hint. The game continues on and when a piece reaches the other end it becomes a king and can move forward and backwards. Once all of the pieces of the other team is eaten the player with remaining pieces wins the game.

## Program strengths
In our project, the thing that works well would have to be the forced moves for the reason being that it knows when to give a forced move and when not to depending on which game mode you are playing in (American or Classic). Another strength that we have in our code is the fact that we have the capability to turn music and sfx on or off. Also our code has the ability to show the jumps that the player can make on their move and serves as a suggestion to an unaware player. 

## Program weaknesses
Our program had a few weaknesses and some of them are very unlikely to occur in an actual play session. One weakness of our code is that the arrows still show up for forced moves even in american mode, even though there are no forced moves. Although this weakness could also be seen as a strength as it reminds you of the moves that you have to move and eat the other player(which is helpful for people who do not see the forced moves). Another weakness that our code has (that can also be seen as a strength) is the fact that whenever a player captures the opponent's piece, if another piece can be captured, that piece will only show the one going to the left.

## Trials and tribulations
One major trial I had was losing my Fidget Spinner. This move was demoralizing and made me sad ;(. Losing my Fidget Spinner made me lose all hope to work on the project. Another trial that we had was working the GUI, after Tarrence finished the GUI while I was gone, we had issues with finding the row and column that the pieces were on, forcing me to redo the GUI to be able to find the row and column and use this information to code for moving the pieces. The last issue that we had with our code was implementing the king into the game. The king took many days to implement and we had to add many long if statements to make the king work.

## Contributing

Please contact me on LinkedIn to collaborate: https://www.linkedin.com/in/albin-shrestha
