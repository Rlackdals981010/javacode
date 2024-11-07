class Solution {
    
    public int solution(String[] board) {
        int oCount = 0, xCount = 0;

        for (String row : board) {
            for (char cell : row.toCharArray()) {
                if (cell == 'O') oCount++;
                if (cell == 'X') xCount++;
            }
        }

        if (!(oCount == xCount || oCount == xCount + 1)) return 0;

        boolean oWin = checkWinner(board, 'O');
        boolean xWin = checkWinner(board, 'X');

        if (oWin && xWin) return 0;

        if (oWin && oCount != xCount + 1) return 0;

        if (xWin && oCount != xCount) return 0;

        return 1;
    }


    private boolean checkWinner(String[] board, char player) {
        String winPattern = "" + player + player + player;

 
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(winPattern)) return true; 
            if ((board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player)) return true; 
        }


        if ((board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) ||
            (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player)) {
            return true;
        }

        return false;
    }
}
