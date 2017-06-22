package model;

import java.util.LinkedList;

import stripsLib.Action;
import stripsLib.Plannable;
import stripsLib.Planner;

public interface Model  {

	public  LinkedList<Action> createPlan(Plannable plannable,Planner planner);
}
