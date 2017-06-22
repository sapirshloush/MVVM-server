package stripsLib;


public class Predicate {

    protected String type;
    protected String subject;
    protected String value;

    public Predicate(String type,String sub,String val)
    {
        this.type=type;
        this.subject=sub;
        this.value=val;
    }

    public boolean isSatesfies(Predicate p)
    {
        return (!this.type.equals(p.type) && this.subject.equals(p.subject) && !this.value.equals(p.value)) || this.equals(p);
    }

    @Override
    public boolean equals(Object p) {
        Predicate predicate=(Predicate)p;

        return this.value.equals(predicate.value) && this.subject.equals(predicate.subject) && this.type.equals(predicate.type);
    }

    public boolean isContradicts(Predicate p)
    {
        return this.subject.equals(p.subject) && !this.type.equals(p.type) && this.value.equals(p.value);
    }

    public boolean isSatisfied(Predicate kb)
    {
        return kb.isSatesfies(this);
    }

}
