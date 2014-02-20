public class StringTable implements StringDictionary {
    private ListElement[] buckets;
    private int size;

    public StringTable(int size) {
        this.size = size;
        buckets = new ListElement[size];
        for(int i = 0; i < size; i++) {
            buckets[i] = new ListElement();
        }
    }

    private class ListElement
    {
        String value;
        ListElement next;

        public String toString() {
                String t = "[";
                ListElement tmp = this;
                if(size == 0)
                    return null;
                t += tmp.value;
                if(tmp.next != null) t += ", ";
                while(tmp.next != null) {
                    tmp = tmp.next;
                    t += tmp.value;
                    if(tmp.next != null) t += ", ";
                }
                return t+"]";
            }
        
        public boolean addLast(String s) {
            if(value == null) {
                value = s;
                return false;
            }
            if(next != null)
                return next.pAddLast(s);
            else {
                next = new ListElement();
                next.value = s;
                return false;
            }
           
        }
        private boolean pAddLast(String s) {
            
            if(value.equals(s))
                return true;
            if(next != null) {
                return next.addLast(s);
            }
            else {
                next = new ListElement();
                next.value = s;
                return false;
            }
        }
        public boolean remove(String s, int i) {
            if(value == null) return false;
            if(value.equals(s)) {
                this.value = null;
                if(this.next != null)
                    buckets[i] = this.next;
                else buckets[i] = new ListElement();
                return true;
            }
            if(next != null)
                return pRemove(s, this);
            else return false;
        }
        private boolean pRemove(String s, ListElement lastElement) {
            if(value.equals(s)) {
                lastElement.next = null;
                return true;
            }
            if(next != null)
                return next.pRemove(s, this);
            else return false;
        }
        public boolean contains(String s) {
            if(value == null) return false;
            if(value.equals(s)) return true;
            if(next == null) return false;
            else return next.pContains(s);
        }
        private boolean pContains(String s) {
            if(value.equals(s))
                return true;
            if(next != null)
                return next.contains(s);
            else return false;
        }

        
    }
    private int getBucket(String s) {
        // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        // eller med andra ord:
        // String s1 = "hello";
        // string s2 = "hello";
        // s2.hashCode() == s1.hashCode() => true
        return s.hashCode()%size;
    }

    
    public boolean add(String s) {
        return buckets[getBucket(s)].addLast(s);
    }

    public boolean remove(String s) {
        return buckets[getBucket(s)].remove(s, getBucket(s));
    }

    public boolean contains(String s) {
        return buckets[getBucket(s)].contains(s);
    }
    public String toString() {
        for(int i = 0; i < size; i++)
            System.out.println(buckets[i].toString());
        return "";
    }
}

