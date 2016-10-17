package fgfgfg.contacts.data;

/**
 * Created by User on 2016/10/12.
 */
public class Person {


    public Person(String n, String t, String a,String m)
    {
        this.ID = 1;
        this.Name = n;
        this.Tel = t;
        this.Addr = a;
        this.Mail=m;
    }
    public Person(int ID, String n, String t, String a,String m)
    {
        this.ID = ID;
        this.Name = n;
        this.Tel = t;
        this.Addr = a;
        this.Mail=m;
    }
    public int ID;
    public String Name;
    public String Tel;
    public String Addr;
    public String Mail;

}