package RoeeSearchable;

import java.util.Arrays;

public class EightPuzzleBoard
{
	private int[][] board;
	
	public EightPuzzleBoard(int[][] board) {
		this.board = board;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}	

	@Override
	public boolean equals(Object o)
	{
		EightPuzzleBoard e = (EightPuzzleBoard)o;
		for(int i = 0 ; i < board.length ; i++)
			for(int j = 0 ; j < board[i].length ; j++)
				if(board[i][j] != e.board[i][j]) return false;

		return true;
	}
	
	@Override
	public int hashCode()
	{
		return board.toString().hashCode();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
