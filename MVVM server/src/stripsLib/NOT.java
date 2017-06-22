package stripsLib;


public class NOT extends Predicate {

    private Predicate predi; // new NOT(Predicate predi)


    public NOT(Predicate p) // if p == new NOT(Predicate)
    {
        super(p.type,p.subject,p.value);
        if(p instanceof NOT)
            this.predi = ((NOT)p).predi;

        else
            this.predi=p;

    }

    @Override
    public boolean isSatesfies(Predicate p)
    {
        return !this.predi.isSatesfies(p);
    }
    @Override
    public boolean isContradicts(Predicate p)
    {
        return !this.predi.isContradicts(p);
    }

}



