package RoeeSearchable;

public class EightPuzzleGame {
	private int[][] board;
	
	public EightPuzzleGame(int[][] board) {
		this.setBoard(board);
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	public int[][] getGoalBoard() {
		int[][] goal =
				{{1,3,6},
				{4,2,0},
				{7,5,8}};

		return goal;
	}
}
