public class  borrowedBook  {
    static int count = 0;
    int num;
    String user[] = new String[49];
    String names[] = new String[49];
    int ids[] = new int[49];
    String types[] = new String[49];

    public borrowedBook(){
        this.user[count] = "";
        this.names[count] = "";
        this.ids[count] = 0;
        this.types[count] = "";
        this.num = this.count++;
        System.out.println(this.num+" "+this.count);
    }
    public borrowedBook(String username,String name,int id,String type){
        this.user[count] = username;
        this.names[count] = name;
        this.ids[count] = id;
        this.types[count] = type;
        this.num = this.count;
        this.count++;
    }

    public int[] getIds() {
        return ids;
    }
    public String[] getNames() {
        return names;
    }
    public String[] getTypes() {
        return types;
    }
    public String[] getUser() {
        return user;
    }
    public int getCount() {
        return count;
    }

}


