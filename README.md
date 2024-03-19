This Java program written to simulate a maze game. The player navigates through a maze by controlling a character. The maze contains obstacles and bonuses. The player attempts to reach the exit of the maze without colliding with obstacles or mines, while collecting bonuses to facilitate completion with the minimum number of steps.

The game operates as follows:

The player uses the printMaze function to view the maze.
Movement functions (W, A, S, D) allow the player to move up, down, left, or right.
The collectBonus function is used when the player moves to a position with a bonus. Different types of bonuses are available, each with unique effects to aid the player in completing the maze efficiently.
Special functions (mine and wall) handle collisions with obstacles (walls or mines).
If the player reaches the exit, the game is successfully completed.
Movement Functions (W, A, S, D):

The row value of the player's position is checked. If the row value is within the bounds of the maze, the player can move upward.
If the position the player intends to move to is not marked with '#' in the maze structure, the player's position is updated upwards (by decrementing the row index) and the step counter is increased.
If the position the player intends to move to is marked with '#', indicating a wall, the Rbonus function is called.
If the player's current row is 0, indicating the top boundary of the maze, the player cannot move upward, and the user is notified.
collectBonus Function:

A count variable is initialized, and the bonus_index_counter is assigned as its first element.
The player's position is checked for bonuses at every step.
If a bonus is found at the player's position, it is added to the bonus array, and the bonus_index_counter is incremented.
The user is informed of the acquired bonus.
The corresponding position in the maze is updated with '.' to remove the bonus.
Wall and Mine Obstacles:
The player's position is continuously tracked. If the player's current position contains an obstacle (wall or mine) upon movement, functions are called to determine if the obstacle can be removed.

useBonus Function:

The user is prompted to select a bonus to use.
A switch-case structure handles different bonus types:
'T': Teleportation bonus function is called.
'R': R bonus can only be used when the player encounters a wall. If the player is adjacent to a wall, R bonus is automatically used.
'F': F bonus can be used when the player encounters a mine. If the player steps on a mine, F bonus is automatically used.
'H': H bonus function is called.
The respective bonus function is executed based on user input.
R Bonus:

A boolean variable bonusFound is initially set to false.
If the player has an 'R' bonus in their bonus list, the variable is set to true, and the 'R' bonus is removed from the list.
If the player has an 'R' bonus:
The direction specified by the user is checked for a wall. If a wall is found, it is replaced with '.', and the player is moved in that direction.
If the player does not have an 'R' bonus, the user is notified that they cannot move in that direction, and the step counter is still updated.
H Bonus:

A boolean variable bonusFound is initially set to false.
If the player has an 'H' bonus in their bonus list, the variable is set to true, and the 'H' bonus is removed from the list.
If the player has an 'H' bonus:
The value of the step counter is checked. If the counter value is 2 or more, the bonus is used, and the counter is reduced by 2.
If the counter value is less than 2, the bonus is used, and the counter is set to 0 to prevent negative step count.
If the 'H' bonus is not found, the user is notified.
F Bonus:

A boolean variable foundFbonus is initially set to false.
If the player has an 'F' bonus in their bonus list, the variable is set to true, the 'F' bonus is removed, and the user is notified.
While foundFbonus is true, the user is prompted for input.
If the input is 'F', the mine at the current position is deactivated, and the user is notified.
If the input is incorrect, the user is prompted again.
If the 'F' bonus is not found, the user is notified, and the step count is increased by 5.
T Bonus:

A boolean variable tBonus is initially set to false.
If the player has a 'T' bonus in their bonus list, the variable is set to true.
If the 'T' bonus is found:
The user is prompted for coordinates to teleport to.
If the input coordinates are valid, the player's position is updated accordingly, and tBonus is set to false.
If the input coordinates are invalid (e.g., contain a wall or are out of bounds), appropriate error messages are displayed.
If the 'T' bonus is not found, the user is notified.
distributeBonus Function:

Random numbers are generated to distribute bonuses randomly.
For each cell in the maze, bonuses are searched for.
Found bonuses are added to the randomBonus array, and the bonus count is incremented.
The cell in the maze is updated with '.' to remove the bonus.
After all bonuses are collected, a random position (x and y) is selected.
If the selected position allows placing a bonus (cell contains '.'), a random bonus is assigned to that cell.
Bonus distribution continues until all bonuses are distributed and the number of empty cells matches the number of bonuses.
distributeMines Function:

Random numbers are generated to distribute mines randomly.
Each cell in the maze is checked. If the cell contains a mine ('!'):
The mine count is incremented.
The mine cell is removed from the maze (updated with '.').
After all mines are collected, a random position (x and y) is selected.
If the selected position is empty ('.'), a mine is placed in that cell.
Mine distribution continues until all mines are placed in empty cells.

Game control:

Game Status: The isGameRunning variable is initially set to true, indicating that the game is in progress. It serves as a control to determine whether the game should continue.

Player Position: The player's position is defined by row and column indices (player_row and player_column), utilizing a maze matrix.

Step Counter: A counter array named counter keeps track of the number of steps taken by the player.

Display Maze: The current state of the maze is printed to the screen using the printMaze function, providing the player with a visual representation of the maze.

Bonus and Mine Handling: If there is a bonus at the player's current position, it is collected using the collectBonus function. Similarly, the presence of a mine at the player's position is checked using the mine function.

Obstacle Detection: The existence of a wall at the player's position is verified using the wall function.

Player Information: Information regarding the current step count, position, and available moves is displayed to the player.

User Input Processing: User input (w, s, a, d, +, exit) is processed using a switch structure. Depending on the input, corresponding functions for movement and bonus usage are invoked.

Bonus and Mine Placement: Every 5 steps (counter[0] % 5 == 0), bonuses and mines are randomly distributed throughout the maze using the distributeBonus and distributeMines functions.

Game Completion: If the player successfully reaches the exit point of the maze, the game is considered completed, and the loop ends.

!!! The shortcomings in the game will be addressed over time. !!!