public interface ListOfInts {
    public void addLast(int i);
    public int get(int i);
    public int size();
    public void set(int i, int value);
    default public void plusEquals(ListOfInts x) {
        if (x.size() != this.size()) {
            return;
        }
        for (int i = 0; i < size(); i++) {
            this.set(i, this.get(i) + x.get(i));
        }
    }
}
