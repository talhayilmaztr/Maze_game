
import java.util.Random;
import java.util.Scanner;

public class Maze_game {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] maze = {
            {'#', '!', '.', '.', 'R', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.', '#', '.', 'H', '.', '.', '.', '.', '.', '!'},
            {'F', '.', '.', '.', '#', '.', '!', '.', '.', 'R', '.', '.', '#', '#', '.'},
            {'.', '.', '#', '.', '.', '#', '.', '.', '.', '.', 'F', '.', '.', '.', '.'},
            {'.', '!', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '!', '.', '.', 'H', '.', '.', 'F', '.', '.', 'R'},
            {'#', '#', '#', '#', '.', '.', '#', '.', '.', '.', 'T', '.', '.', '.', 'E'},
            {'.', '.', '#', '.', 'F', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '!', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', 'T', 'T', '.', '#', '#', '.', '.', '.', '.', 'T', '.', '.', '.', 'R'},
            {'.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', 'T', '.'},
            {'B', '.', '#', '.', '.', '!', '.', '!', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '.', 'F', '!', '.', '.', '.', 'H', '.', '.', 'R', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '.', '#', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '#'}};

        int end_row = 0;
        int end_col = 0;
        int start_row = 0;
        int start_col = 0;
        int[] player_row = new int[1];
        int[] player_column = new int[1];

        char bonus[] = new char[20];
        int[] counter = new int[1];
        int bonus_index_counter[] = new int[1];


        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][0] == 'B') {
                    start_row = i;
                    start_col = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'E') {
                    end_row = i;
                    end_col = j;
                    break;
                }
            }
        }
        player_row[0] = start_row;
        player_column[0] = start_col;
        System.out.println("Maze Game:");

        boolean isGameRunning = true;
        while (isGameRunning) {
            printMaze(maze);
            collectBonus(maze, bonus_index_counter, bonus, player_row, player_column);
            mine(maze, bonus, counter, player_row, player_column);
            wall(maze, bonus, counter, player_row, player_column);


            System.out.println("Your step count: " + counter[0]);
            System.out.println("Your current position: " + player_row[0] + "." + player_column[0]);
            System.out.println("Enter one of the characters W, A, S, D to move ");
            String move = input.next();
            switch (move) {
                case "w":
                    up(counter, maze, player_row, player_column);
                    break;
                case "s":
                    down(counter, maze, player_row, player_column);
                    break;
                case "a":
                    left(counter, maze, player_row, player_column);
                    break;
                case "d":
                    right(counter, maze, player_row, player_column);
                    break;

            }

        }
    }

    public static void printMaze(char maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void up(int counter[], char maze[][], int player_row[], int player_column[]) {
        if (player_row[0] > 0) {
            player_row[0]--;
            System.out.println("Moved up and your current position is: " + player_row[0] + "." + player_column[0]);
            counter[0]++;
        } else {
            System.out.println("Cannot move up!");
        }
    }

    public static void down(int counter[], char maze[][], int player_row[], int player_column[]) {
        if (player_row[0] < 14) {
            player_row[0]++;
            System.out.println("Moved down and your current position is: " + player_row[0] + "." + player_column[0]);
            counter[0]++;
        } else {
            System.out.println("Cannot move down!");
        }
    }

    public static void right(int counter[], char maze[][], int player_row[], int player_column[]) {
        if (player_column[0] < 14) {
            player_column[0]++;
            System.out.println("Moved right and your current position is: " + player_row[0] + "." + player_column[0]);
            counter[0]++;
        } else {
            System.out.println("Cannot move right!");
        }
    }

    public static void left(int counter[], char maze[][], int player_row[], int player_column[]) {
        if (player_column[0] > 0) {
            player_column[0]--;
            System.out.println("Moved left and your current position is: " + player_row[0] + "." + player_column[0]);
            counter[0]++;
        } else {
            System.out.println("Cannot move left!");
        }
    }
    public static void mine(char maze[][], char bonus[], int counter[], int player_row[], int player_column[]) {

        if (maze[player_row[0]][player_column[0]] == '!') {
            FBonus(bonus, maze, counter, player_row, player_column);
        }
    }
    public static void wall(char maze[][], char bonus[], int counter[], int player_row[], int player_column[]) {

        if (maze[player_row[0]][player_column[0]] == '#') {
            Rbonus(maze, bonus, counter, player_row, player_column);
        }
}
    public static void FBonus(char bonus[], char maze[][], int counter[], int player_row[], int player_column[]) {
        boolean foundFbonus = false;
        for (int i = 0; i < bonus.length; i++) {
            if (bonus[i] == 'F') {
                System.out.println("You have found the F bonus, please defuse the mine..");
                foundFbonus = true;
                bonus[i] = ' ';
                break;
            }
        }
        while (foundFbonus) {
            char F = input.next().charAt(0);
            if (F == 'F') {
                maze[player_row[0]][player_column[0]] = '.';
                System.out.println("The mine has been defused..");
                break;
            } else {
                System.out.println("Please enter F.");
            }
        }
        if (!foundFbonus) {
            System.out.println("F Bonus not found, the bomb exploded, your step count increased by 5..");
            maze[player_row[0]][player_column[0]] = '.';
            counter[0] += 5;
        }
    }
    
    public static void Rbonus(char maze[][], char bonus[], int counter[], int player_row[], int player_column[]) {
        boolean bonusFound = false;

        System.out.println("You encountered a wall!!");
        for (int i = 0; i < bonus.length; i++) {
            if (bonus[i] == 'R') {
                bonusFound = true;

            }
        }
        if (bonusFound == true) {
            System.out.println("You have an R bonus, use it to remove the wall (R) ..");
            char R = input.next().charAt(0);
            if (R == 'R') {
                for (int b = 0; b < bonus.length; b++) {
                    if (bonus[b] == 'R') {
                        bonus[b] = ' ';
                        break;
                    }
                }
                if (player_row[0] < 14 && maze[player_row[0] + 1][player_column[0]] == '#') {
                    maze[player_row[0] + 1][player_column[0]] = '.';
                    player_row[0]++;
                    System.out.println("Bonus usage successful");
                } else if (player_row[0] > 0 && maze[player_row[0] - 1][player_column[0]] == '#') {
                    maze[player_row[0] - 1][player_column[0]] = '.';
                    player_row[0]--;
                    System.out.println("Bonus usage successful");
                } else if (player_column[0] < 14 && maze[player_row[0]][player_column[0] + 1] == '#') {
                    maze[player_row[0]][player_column[0] + 1] = '.';
                    player_column[0]++;
                    System.out.println("Bonus usage successful");
                } else if (player_column[0] > 0 && maze[player_row[0]][player_column[0] - 1] == '#') {
                    maze[player_row[0]][player_column[0] - 1] = '.';
                    player_column[0]--;
                    System.out.println("Bonus usage successful");
                }
            }
        }
        if (bonusFound == false) {
            System.out.println("You don't have an R bonus, you can't go this way..");
            counter[0]++;
        }
}
    public static void Hbonus(int counter[], char bonus[], char maze[][]) {
        boolean bonusFound = false;
        for (int i = 0; i < 20; i++) {
            if (bonus[i] == 'H') {
                bonusFound = true;
                bonus[i] = ' ';
            }
        }
        if (bonusFound == true) {
            if (counter[0] >= 2) {
                System.out.println("Bonus usage successful");
                counter[0] -= 2;
            } else {
                System.out.println("Bonus usage successful");
                counter[0] = 0;
            }
        }
        if (bonusFound == false) {
            System.out.println("Bonus not found!!");
        }
}
public static void Tbonus(char bonus[], int counter[], char maze[][], int player_row[], int player_column[]) {

    boolean foundTbonus = false;
        for (int i = 0; i < bonus.length; i++) {
    if (bonus[i] == 'T') {
        foundTbonus = true;

            System.out.println("Enter the x and y coordinates of the location you want to teleport to..");
            bonus[i] = ' ';
            break;
        }
    }
    if (!foundTbonus) {
        System.out.println("You don't have a T bonus");
    }
    while (foundTbonus) {
        System.out.print("x:");
        int x = input.nextInt();
        System.out.print("y:");
        int y = input.nextInt();
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length) {

            if (maze[x][y] != '!' && maze[x][y] != '#') {
                player_column[0] = y;
                player_row[0] = x;
                counter[0]++;
                foundTbonus = false;
            } else {
                System.out.println("You arrived at '" + maze[x][y] + "'. Please enter again.");
            }
        } else {
            System.out.println("Labirynth border exceeded. Please enter again.");
        }
    }
}
    public static void useBonus(char bonus[], char maze[][], int counter[], int player_row[], int player_column[]) {

        System.out.println("Enter the bonus you want to use: (H, T, F, R)");
        char letter = input.next().charAt(0);
        switch (letter) {
            case 'T':
                Tbonus(bonus, counter, maze, player_row, player_column);
                break;
            case 'R':
                if (maze[player_row[0]][player_column[0]] != '#') {
                    System.out.println("The R bonus can only be used when encountering a wall..");
                }
                break;
            case 'F':
                if (maze[player_row[0]][player_column[0]] != '!') {
                    System.out.println("The F bonus can only be used when encountering a mine.");
                }
                break;
            case 'H':
                Hbonus(counter, bonus, maze);
                break;
            default:
                System.out.println("Please enter a valid bonus type! (H, T, F, R)");
                break;
        }
    }

    public static void collectBonus(char maze[][], int bonus_index_counter[], char bonus[], int player_row[], int player_column[]) {
        int count = bonus_index_counter[0];

        if (maze[player_row[0]][player_column[0]] == 'R') {
            bonus[count] = maze[player_row[0]][player_column[0]];
            bonus_index_counter[0]++;
            System.out.println("R bonus added to your bonus list.");
            maze[player_row[0]][player_column[0]] = '.';
        } else if (maze[player_row[0]][player_column[0]] == 'F') {
            bonus[count] = maze[player_row[0]][player_column[0]];
            bonus_index_counter[0]++;
            System.out.println("F bonus added to your bonus list.");
            maze[player_row[0]][player_column[0]] = '.';
        } else if (maze[player_row[0]][player_column[0]] == 'T') {
            bonus[count] = maze[player_row[0]][player_column[0]];
            bonus_index_counter[0]++;
            System.out.println("T bonus added to your bonus list.");
            maze[player_row[0]][player_column[0]] = '.';
        } else if (maze[player_row[0]][player_column[0]] == 'H') {
            bonus[count] = maze[player_row[0]][player_column[0]];
            bonus_index_counter[0]++;
            System.out.println("H bonus added to your bonus list.");
            maze[player_row[0]][player_column[0]] = '.';
        }
    }
    public static void distributeBonus(char maze[][], char randomBonus[], int player_row[], int player_column[]) {
        Random random = new Random();
        int bonusCount = 0;
        int index = 0, bonusX, bonusY;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                switch (maze[i][j]) {
                    case 'F':
                        bonusCount++;
                        randomBonus[index] = maze[i][j];
                        maze[i][j] = '.';
                        index++;
                        break;
                    case 'R':
                        bonusCount++;
                        randomBonus[index] = maze[i][j];
                        maze[i][j] = '.';
                        index++;
                        break;
                    case 'T':
                        bonusCount++;
                        randomBonus[index] = maze[i][j];
                        maze[i][j] = '.';
                        index++;
                        break;
                    case 'H':
                        bonusCount++;
                        randomBonus[index] = maze[i][j];
                        maze[i][j] = '.';
                        index++;
                        break;
                }
            }
        }
        int x = index;
        while (bonusCount > 0 && x > 0) {
            bonusX = random.nextInt(14);
            bonusY = random.nextInt(14);
            if ((maze[bonusX][bonusY] == '.')) {
                maze[bonusX][bonusY] = randomBonus[x - 1];
                x--;
            }
        }
}
public static void distributeMines(char maze[][]) {
    Random random = new Random();
    int mineCount = 0;
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
            if (maze[i][j] == '!') {
                mineCount++;
                maze[i][j] = '.';
            }
        }
    }
    while (mineCount > 0) {
        int mineX = random.nextInt(maze.length);
        int mineY = random.nextInt(maze[0].length);
        if (maze[mineX][mineY] == '.') {
            maze[mineX][mineY] = '!';
            mineCount--;
        }
    }
}

}
