package searchLib;

public class State<T>
{
	private int cost;
	private State<T> parent;
	private T state;
	

	//DC'tor
	public State()
	{
		this.cost=0;
		this.parent=null;
	}

	public State(T state)
	{
		this.cost = 0;
		this.parent = null;
		this.state = state;
	}

	//C'tor 
	public State(int cost,State<T> parent)
	{
		this.cost=cost;
		this.parent=parent;
	}

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public State<T> getParent() {
		return parent;
	}
	public void setParent(State<T> parent) {
		this.parent = parent;
	}
	public T getState() {
		return state;
	}

//	public boolean equals(State<T> s)
//	{
//		return this.state.equals(s.state);
//	}

	@Override
	public boolean equals(Object o)
	{
		if(o == null) return false;

		State<T> s = (State<T>)o;
		return this.state.equals(s.state);
	}

	public int hashCode()
	{
		return state.hashCode();
	}


	public String toString()
	{
		return state.toString();
	}

}
