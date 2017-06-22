package RoeeSearchable;

import searchLib.*;

import java.util.ArrayList;
import java.util.List;

public class EightPuzzleAdapter implements Searchable<EightPuzzleBoard> {

	private EightPuzzleGame game;
	
	public EightPuzzleAdapter(EightPuzzleGame game) {
		this.game = game;
	}
	
	@Override
	public State<EightPuzzleBoard> getInitialState() {
		EightPuzzleBoard e = new EightPuzzleBoard(game.getBoard());
		State<EightPuzzleBoard> initialState = new State<EightPuzzleBoard>(e);
		return initialState;
	}

	@Override
	public State<EightPuzzleBoard> getGoalState() {
		EightPuzzleBoard e = new EightPuzzleBoard(game.getGoalBoard());
		State<EightPuzzleBoard> goalState = new State<EightPuzzleBoard>(e);		
		return goalState;
	}
	
	private Position getEmptySquarePosition(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	private int[][] generateNewBoard(int[][] board, Position oldEmptyPos, Position newEmptyPos) {
		int[][] newBoard = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		newBoard[newEmptyPos.row][newEmptyPos.col] = 0;
		newBoard[oldEmptyPos.row][oldEmptyPos.col] = board[newEmptyPos.row][newEmptyPos.col];
		
		return newBoard;
	}
	
	
	@Override
	public List<State<EightPuzzleBoard>> getAllPossibleStates(State<EightPuzzleBoard> s) {		
		int[][] board = s.getState().getBoard();
		Position emptyPos = getEmptySquarePosition(board);
		
		List<State<EightPuzzleBoard>> list = new ArrayList<State<EightPuzzleBoard>>();
		
		if (emptyPos.col > 0) {
			int[][] newBoard = generateNewBoard(board, emptyPos,
					new Position(emptyPos.row, emptyPos.col - 1));
			State<EightPuzzleBoard> possibleState = new State<>(new EightPuzzleBoard(newBoard));
			possibleState.setCost(s.getCost() + 1);
			list.add(possibleState);
		}
		if (emptyPos.col < board.length - 1) {
			int[][] newBoard = generateNewBoard(board, emptyPos,
					new Position(emptyPos.row, emptyPos.col + 1));

			State<EightPuzzleBoard> possibleState = new State<EightPuzzleBoard>(new EightPuzzleBoard(newBoard));
			possibleState.setCost(s.getCost() + 1);
			list.add(possibleState);
		}
		if (emptyPos.row > 0) {
			int[][] newBoard = generateNewBoard(board, emptyPos,
					new Position(emptyPos.row - 1, emptyPos.col));

			State<EightPuzzleBoard> possibleState = new State<EightPuzzleBoard>(new EightPuzzleBoard(newBoard));
			possibleState.setCost(s.getCost() + 1);
			list.add(possibleState);
		}
		if (emptyPos.row < board.length - 1) {
			int[][] newBoard = generateNewBoard(board, emptyPos,
					new Position(emptyPos.row + 1, emptyPos.col));

			State<EightPuzzleBoard> possibleState = new State<EightPuzzleBoard>(new EightPuzzleBoard(newBoard));
			possibleState.setCost(s.getCost() + 1);
			list.add(possibleState);
		}
		
		return list;
	}

	@Override
	public List<State<EightPuzzleBoard>> getAllStates()
	{
		List<State<EightPuzzleBoard>> allStates = new ArrayList<>();

		return null;
	}

}
