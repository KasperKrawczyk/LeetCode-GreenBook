public class FindTicTacToeWinner {
    int n = 3;

    public String tictactoe(int[][] moves) {
        int[] rows = new int[n];
        int[] cols = new int[n];

        int leftDiag = 0;
        int rightDiag = 0;

        int curPlayer = 1;

        for(int i = 0; i < moves.length; i++){
            int[] curMove = moves[i];
            int row = curMove[0];
            int col = curMove[1];

            rows[row] += curPlayer;
            cols[col] += curPlayer;

            leftDiag = row == col ? leftDiag + curPlayer : leftDiag;
            rightDiag = row + col == n - 1 ? rightDiag + curPlayer : rightDiag;

            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                    Math.abs(leftDiag) == n || Math.abs(rightDiag) == n){
                return curPlayer == 1 ? "A" : "B";
            }

            curPlayer *= -1;
        }


        return moves.length < (n * n) ? "Pending" : "Draw";
    }
}
