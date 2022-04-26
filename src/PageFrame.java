public class PageFrame {
    public char frameID;
    public int pageLockTime;
    public int pageReference;
    public boolean used;

    public PageFrame(char ID) {
        frameID = ID;
        pageLockTime = 0;
        pageReference = 0;
        used = false;
    }
}
