public abstract class Folder {
    private int kb;
    public Folder(int val) {
        kb = val;
    }
    public abstract int getKiloBytes();
}