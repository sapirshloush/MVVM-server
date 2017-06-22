package searchLib;

import java.util.ArrayList;

public interface Searcher<T> {
	public ArrayList<Action<T>> search(Searchable<T> s);
	public int getNumberOfNodesEvaluated();
	
}
