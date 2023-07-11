// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// **На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
import java.util.*;

public class QueensPlacement {
    private static final int BOARD_SIZE = 8; // Размер шахматной доски

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE]; // Создаем шахматную доску

        if (placeQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("Решение не найдено.");
        }
    }

    // Рекурсивная функция для расстановки ферзей
    private static boolean placeQueens(int[][] board, int col) {
        if (col >= BOARD_SIZE) {
            return true; // Все ферзи успешно расставлены
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Расставляем ферзя на текущую позицию

                // Рекурсивно вызываем функцию для расстановки оставшихся ферзей
                if (placeQueens(board, col + 1)) {
                    return true;
                }

                // Если текущая расстановка не ведет к решению, отменяем ее
                board[row][col] = 0;
            }
        }

        return false; // Решение не найдено
    }

    // Проверка, безопасна ли текущая позиция для ферзя
    private static boolean isSafe(int[][] board, int row, int col) {
        // Проверяем вертикали и горизонтали
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }

        // Проверяем диагонали
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ((i + j == row + col || i - j == row - col) && board[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // Вывод шахматной доски с расставленными ферзями
    private static void printBoard(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}