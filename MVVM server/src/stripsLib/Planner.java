package stripsLib;

import java.util.LinkedList;
import java.util.Queue;

public interface Planner
{
    LinkedList<Action> buildPlan(Plannable p);
}
