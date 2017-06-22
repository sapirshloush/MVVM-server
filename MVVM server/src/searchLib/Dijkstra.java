package searchLib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Dijkstra<T> extends CommonSearcher<T>
{
    @Override
    public ArrayList<Action<T>> search(Searchable<T> s)
    {
        State<T> initialState = Init_Single_Source(s);
        openList.addAll(s.getAllStates());
        HashSet<State<T>> S = new HashSet<>();
        S.add(initialState);

        while(!openList.isEmpty())
        {
            State<T> popState = popFromOpenlist();
            S.add(popState);
            List<State<T>> successors = s.getAllPossibleStates(popState);
            for(State<T> state : successors)
            {

            }
        }
        return null;
    }

    private State<T> Init_Single_Source(Searchable<T> s)
    {
        return s.getInitialState();
    }
}