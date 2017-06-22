package stripsLib;


import java.util.List;

public class Multipart extends Predicate {

    private List<Predicate> subgoals;

    public Multipart(Predicate... predicates) {
        super(null,null,null);

        for(Predicate p : predicates)
            this.subgoals.add(p);
    }

    @Override
    public boolean isSatesfies(Predicate p)
    {
        return this.subgoals.contains(p);
    }

    @Override
    public boolean isContradicts(Predicate p)
    {
        for(Predicate predicate : subgoals) {
            if(predicate.isContradicts(p))
                return true;
        }
        return false;
    }

    @Override
    public boolean isSatisfied(Predicate kb)
    {
        for(Predicate predicate : subgoals)
        {
            if(!kb.isSatesfies(predicate))
                return false;
        }
        return true;
    }

    public List<Predicate> getSubgoals() {
        return subgoals;
    }
}
