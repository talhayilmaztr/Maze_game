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

        int[] counter = new int[1];


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
        boolean isGameRunning = true;
        while (isGameRunning) {
            printMaze(maze);
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
    
    
    
}