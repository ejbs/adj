public class ListElement
{
    String value;
    ListElement next;
    
    public boolean addLast(String s) {
        if(value.equals(s))
            return true;
        if(next != null) {
            return next.addLast(s);
        }
        else {
            value = s;
            return false;
        }
    }
    public boolean remove(String s) {
        if(value.equals(s)) {
            this.value = null;
            return true;
        }
        if(next != null)
            return pRemove(s, this);
        else return false;
    }
    private boolean pRemove(String s, ListELement lastElement) {
        if(value.equals(s)) {
            lastElement.next = null;
            return true;
        }
        if(next != null)
            return next.pRemove(s, this);
        else return false;
    }
    public boolean contains(String s) {
        if(value.equals(s))
            return true;
        if(next != null)
            return next.contains(s);
        else return false;
    }
}
