package model;

import java.util.LinkedList;
import java.util.Observable;

import stripsLib.Action;
import stripsLib.Plannable;
import stripsLib.Planner;

public class SolverModel extends Observable implements Model{

	
	private Planner planner;
	private Plannable plannable;
	
	public  LinkedList<Action> createPlan(Plannable plannable,Planner planner)
	{
		
		return planner.buildPlan(plannable);
	}
	
	
	
	

	
}
