package stripsLib;


import java.util.List;

public interface Plannable
{
    Predicate getGoal();
    Predicate getStart();
    List<Action> getActions(Predicate p);

}
