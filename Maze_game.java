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
}
