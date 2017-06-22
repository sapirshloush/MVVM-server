package stripsLib;


public class Action extends Predicate
{
   private Predicate preConditions;
   private Predicate effects;


    public Action(String type,String subject,String value,Predicate con, Predicate effects)
    {
        super(type, subject, value);
        this.preConditions =con;
        this.effects=effects;
    }

    public void updateKb(Predicate kb)
    {
        if (kb instanceof Multipart) {
            Multipart predicate = (Multipart) kb;
            for (Predicate pre : predicate.getSubgoals())
                if (this.effects.isContradicts(pre))
                    predicate.getSubgoals().remove(pre);
            predicate.getSubgoals().add(this.effects);
        }

        else
        {
            if(this.effects.isContradicts(kb))
                kb= new Multipart(this.effects);
            else
                kb=new Multipart(this.effects,kb);
        }
    }

    public Predicate getEffects() {
        return effects;
    }

    public Predicate getPreConditions() {
        return preConditions;
    }
}
