package fgfgfg.contacts.data;

import java.util.List;

/**
 * Created by User on 2016/10/12.
 */
public interface PersonDAO {
    public void add(Person p);
    public void delete(Person p);
    public List<Person> getList();
    public void update(Person p);
    public Person getPerson(int ID);

}
