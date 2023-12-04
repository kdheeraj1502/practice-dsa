package Maersk;

import java.util.HashSet;
import java.util.Set;

public class RobotCleaning {
    public static void main(String[] args) {
        String[] A1 = {"....X..", "X......", ".....", "......."};
        System.out.println(solution(A1)); // Output: 6

        // Other test cases...
    }



    public static int solution(String[] R) {
        int N = R.length;
        int M = R[0].length();

        boolean[][] visited = new boolean[N][M];
        int cleanSquares = 0;

        int[] dx = {0, 1, 0, -1}; // Directions: right, down, left, up
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0; // Starting position
        int direction = 0; // Initial direction: right

        while (true) {
            // Check if the current position is within bounds and the square is not visited
            if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]) {
                visited[x][y] = true;
                cleanSquares++;
            } else {
                // If out of bounds or already visited, stop the loop
                break;
            }

            // Attempt to move to the next square in the current direction
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            // Check if the new position is within bounds and the square is unoccupied
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && R[nextX].charAt(nextY) == '.') {
                // Move to the next square in the current direction
                x = nextX;
                y = nextY;
            } else {
                // Change direction (rotate 90 degrees clockwise)
                direction = (direction + 1) % 4;

                // Recalculate next position after changing direction
                x = x + dx[direction];
                y = y + dy[direction];
            }
        }

        return cleanSquares;
    }


}
