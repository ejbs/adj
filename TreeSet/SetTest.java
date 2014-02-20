public class SetTest {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> s = new TreeSet<Integer>();
        assert s.depth() == 0;
        assert s.contains(1) == false;
        assert s.contains(5) == false;
        s.insert(5);
        assert s.depth() == 1;
        assert s.numberOfLeaves() == 1;
        assert s.contains(5) == true;
        s.insert(1);
        assert s.contains(1) == true;
        s.insert(-1);
        assert s.contains(-1) == true;
        assert s.numberOfLeaves() == 1;
        assert s.numberOfElements() == 3;
        assert s.depth() == 3;
        s.insert(6);
        assert s.numberOfLeaves() == 2;
        assert s.contains(6);
        s.insert(2);
        assert s.numberOfLeaves() == 3;
        assert s.contains(2);
        assert s.depth() == 3;
        s.insert(20);
        assert s.numberOfLeaves() == 3;
        assert s.contains(20);
        s.insert(50);
        s.insert(60);
        assert s.depth() == 5;
        assert s.numberOfLeaves() == 3;
        assert s.toString().equals("[-1,1,2,5,6,20,50,60]");


        TreeSet<Integer> t = new TreeSet<Integer>();
        for(int i = -50; i < 51; i++) {
            t.insert(i);
            assert t.contains(i);
        }
    }
}
