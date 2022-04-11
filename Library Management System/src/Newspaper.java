public class Newspaper {
    private String npName,npPublisher;
    private int npCount;

    //methods
    public void count(){}
    //constructors
    Newspaper(){
        npName="";
        npPublisher="";
        npCount=0;
    }
    Newspaper(String npName,String npPublisher,int npCount){
        this.npName=npName;
        this.npPublisher=npPublisher;
        this.npCount=npCount;
    }
    //getters

    public String getNpName() {
        return npName;
    }

    public String getNpPublisher() {
        return npPublisher;
    }

    public int getNpCount() {
        return npCount;
    }
    //setters

    public void setNpName(String npName) {
        this.npName = npName;
    }

    public void setNpPublisher(String npPublisher) {
        this.npPublisher = npPublisher;
    }

    public void setNpCount(int npCount) {
        this.npCount = npCount;
    }
}

