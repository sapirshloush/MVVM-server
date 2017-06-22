package model;

import java.util.LinkedList;

import stripsLib.Action;
import stripsLib.Plannable;
import stripsLib.Planner;

public class SolverModel {

	
	private static Planner planner;
	private static Plannable plannable;
	
	public static LinkedList<Action> createPlan(Plannable plannable,Planner planner)
	{
		
		return planner.buildPlan(plannable);
	}
	
	
	
	

	
}
