package RoeeSearchable;

import java.util.List;
import searchLib.*;

public class Run {

	public static void main(String[] args) {
		int[][] board = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,0,8}
		};

		EightPuzzleGame game = new EightPuzzleGame(board);
		EightPuzzleAdapter adapter = new EightPuzzleAdapter(game);



		Searcher searcher = new BFS<EightPuzzleBoard>();
		List<Action<EightPuzzleBoard>> solution = searcher.search(adapter);

		if(solution != null)
		{
			for(int i = solution.size()-1 ; i >= 0 ; i--)
			{
				System.out.println(solution.get(i));
			}
		}

		System.out.println("");
	}

}
