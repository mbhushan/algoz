import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<board.length; i++) {

            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();

            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int r = 3*(i/3) + j/3;
                int c = 3*(i%3) + j%3;

                if (board[r][c] != '.' && !cube.add(board[r][c])) {
                    return false;
                }
            }
        }

        return true;
    }
}
