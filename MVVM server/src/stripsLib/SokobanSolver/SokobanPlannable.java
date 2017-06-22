package stripsLib.SokobanSolver;


import stripsLib.Action;
import stripsLib.Plannable;
import stripsLib.Predicate;

import java.util.List;

import model.data.Level;



public class SokobanPlannable implements Plannable
{
    private Level level;


    @Override
    public Predicate getGoal() {
        return null;
    }

    @Override
    public Predicate getStart() {
        return null;
    }

    @Override
    public List<Action> getActions(Predicate p) {
        return null;
    }
}
