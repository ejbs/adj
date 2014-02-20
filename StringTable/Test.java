public class Test {
    public static void main(String[] args) throws Exception {
        StringTable st = new StringTable(100);
        assert st.remove("hello") == false;
        assert st.contains("hello") == false;
        assert st.add("hello") == false;
        assert st.contains("hello") == true;
        assert st.remove("hello") == true; 
        assert st.add("hello") == false;
        assert st.add("Hello") == false;
        assert st.contains("WORLD") == false; 
        assert st.add("WORLD") == false;
        assert st.contains("Hello") == true;
        assert st.contains("WORLD") == true;
        assert st.remove("Hello") == true;
        assert st.remove("hello") == true;
        assert st.remove("wörld") == false;
        assert st.remove("WORLD") == true;
        assert st.contains("WORLD") == false;

        for(int i = 0; i < 5000; i++) {
            st.add(Integer.toString(i));
        }
        for(int i = 0; i < 5000; i++) {
            assert st.contains(Integer.toString(i));
        }
    }
}
