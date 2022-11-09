package excelread;

import java.util.List;

public class RolePolicyList {

    private String roleName;
    private List<RolePolicy> rolePolicies;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RolePolicy> getRolePolicies() {
        return rolePolicies;
    }

    public void setRolePolicies(List<RolePolicy> rolePolicies) {
        this.rolePolicies = rolePolicies;
    }
}
