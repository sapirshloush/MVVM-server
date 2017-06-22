package searchLib;

public class Action<T> {

	private State<T> currentState;
	private State<T> nextState;
	
	public Action(State<T> currentstate,State<T> nextstate) {
		this.currentState=currentstate;
		this.nextState=nextstate;
	}
	
	@Override
	public String toString() {
		
		return "From:\n" + currentState.toString() + "\n\nTo:\n" + nextState.toString() + "\n\n";
	}

	public State<T> getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State<T> currentState) {
		this.currentState = currentState;
	}

	public State<T> getNextState() {
		return nextState;
	}

	public void setNextState(State<T> nextState) {
		this.nextState = nextState;
	}
	
}
