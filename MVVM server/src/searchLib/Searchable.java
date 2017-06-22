package searchLib;

import java.util.*;

public interface Searchable<T> {

	State<T> getInitialState();
	State<T> getGoalState();
	List<State<T>> getAllPossibleStates(State<T> state);
	List<State<T>> getAllStates();
}
