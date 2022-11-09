package objectmapper;

import java.util.Date;

/**
 * @author Nanda Kumar
 * @since 01/06/2022
 */
public class EmployeeObject {

    private String name;
    private Date loaddate;
    private boolean set;
    private String add;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLoaddate() {
        return loaddate;
    }

    public void setLoaddate(Date loaddate) {
        this.loaddate = loaddate;
    }

    public boolean isSet() {
        return set;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "EmployeeObject{" +
                "name='" + name + '\'' +
                ", loaddate=" + loaddate +
                ", set=" + set +
                ", add='" + add + '\'' +
                '}';
    }
}
