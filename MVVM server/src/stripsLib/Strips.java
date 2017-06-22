package stripsLib;

import java.util.*;


public class Strips implements Planner
{
    @Override
    public LinkedList<Action> buildPlan(Plannable p)
    {
        Stack<Predicate> stack = new Stack<>();
        Predicate knowledgeBase = p.getStart();
        LinkedList<Action> plan = new LinkedList<>(); // This will act as an ordinary queue (FIFO).

        while(!stack.isEmpty())
        {
            Predicate item = stack.pop();

            if(!item.isSatisfied(knowledgeBase)) {
                Predicate predicate = (Predicate) item;


                if (predicate instanceof Multipart)
                {
                    Multipart predi = (Multipart) predicate;
                    for (Predicate pr : predi.getSubgoals())
                        stack.push(pr);
                }
                else
                {
                    List<Action> actions = p.getActions(predicate);
                    for(Action action : actions)
                    {
                        stack.push(action);
                        stack.push(action.getPreConditions());
                    }
                }

                if (item instanceof Action) {
                    Action a = (Action) item;
                    a.updateKb(knowledgeBase);
                    plan.addFirst(a);
                }

            }

        }

        return plan;
    }
}