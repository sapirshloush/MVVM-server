package searchLib;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher<T> {
	
	protected PriorityQueue<State<T>> openList;
	protected int evaluatedNodes;
	
	
	public CommonSearcher()
	{
		evaluatedNodes =0;
		openList=new PriorityQueue<>((s1, s2) -> (int)(s1.getCost()-s2.getCost()));
	}

	public PriorityQueue<State<T>> getOpenList()
	{
		return openList;
	}

	public void setOpenList(PriorityQueue<State<T>> openList)
	{
		this.openList = openList;
	}


	public void setEvaluatedNodes(int evaluatedNodes)
	{
		this.evaluatedNodes = evaluatedNodes;
	}
	
	public State<T> popFromOpenlist()
	{
		evaluatedNodes++;
		return openList.poll();
	}
	
	public void addToOpenList(State<T> state)
	{
		openList.add(state);
	}
	
	public ArrayList<Action<T>> backTrace(State<T> end,State<T> start)
	{
		ArrayList<Action<T>> moveToVictory = new ArrayList<>();
		State<T> temp = end;
		while(!temp.equals(start))
		{
			Action<T> action = new Action<>(temp.getParent(),temp);
			moveToVictory.add(action);
			temp=temp.getParent();
		}
		return moveToVictory;
	}

	@Override
	public int getNumberOfNodesEvaluated()
	{
		return evaluatedNodes;
	}
}
