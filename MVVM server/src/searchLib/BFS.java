package searchLib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BFS<T> extends CommonSearcher<T>
{

	public ArrayList<Action<T>> search(Searchable<T> s)
	{
		addToOpenList(s.getInitialState());
		HashSet<State<T>> closedSet = new HashSet<>();

		while (openList.size() > 0)
		{
			State<T> n = popFromOpenlist();
			closedSet.add(n);

			if (n.equals(s.getGoalState()))
				return backTrace(n, s.getInitialState());

			List<State<T>> successors = s.getAllPossibleStates(n);
			for (State<T> state : successors)
			{
				state.setParent(n);

				if (!closedSet.contains(state) && !openList.contains(state)) {
					addToOpenList(state);
				}

				else {
					State<T> temp = null;
					for (State<T> f : openList)
					{
						if (f.equals(state))
						{
							temp = f;
							break;
						}

					}
					if (temp != null && state.getCost() < temp.getCost())
					{
						openList.remove(temp);
						openList.add(state);
					}
				}
			}
		}

		return null;
		
	}

}
