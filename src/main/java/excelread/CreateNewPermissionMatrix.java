package excelread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNewPermissionMatrix {

    public static void main(String[] args) throws IOException, InterruptedException {

        ReadTableFromExcel readTableFromExcel = new ReadTableFromExcel();
        List<DataTableDTO> dataTable = readTableFromExcel.getEntries();

        RolePolicyList testerRolePolicies = new RolePolicyList();
        testerRolePolicies.setRoleName("tester_role_policy");
        RolePolicyList functionalEngineerRolePolicies = new RolePolicyList();
        functionalEngineerRolePolicies.setRoleName("functional_role_Policy");
        RolePolicyList businessRolePolicies = new RolePolicyList();
        businessRolePolicies.setRoleName("business_role_Policy");

        List<RolePolicy> testerRolePolicyList = new ArrayList();
        List<RolePolicy> functionalEngineerRolePolicyList = new ArrayList();
        List<RolePolicy> businessRolePolicyList = new ArrayList();

        for (DataTableDTO dataTableDTO : dataTable) {
            RolePolicy testerRolePolicy = new RolePolicy();
            RolePolicy functionalEngineerRolePolicy = new RolePolicy();
            RolePolicy businessRolePolicy = new RolePolicy();

            populateRole(dataTableDTO, testerRolePolicy, "tester");
            populateRole(dataTableDTO, functionalEngineerRolePolicy, "functionalengineer");
            populateRole(dataTableDTO, businessRolePolicy, "business");

            testerRolePolicyList.add(testerRolePolicy);
            functionalEngineerRolePolicyList.add(functionalEngineerRolePolicy);
            businessRolePolicyList.add(businessRolePolicy);

        }

        testerRolePolicies.setRolePolicies(testerRolePolicyList);
        functionalEngineerRolePolicies.setRolePolicies(functionalEngineerRolePolicyList);
        businessRolePolicies.setRolePolicies(businessRolePolicyList);

        WritePolicyToFile writePolicyToFile = new WritePolicyToFile();

        writePolicyToFile.cleanDirectory();
        writePolicyToFile.write(testerRolePolicies);
        writePolicyToFile.write(functionalEngineerRolePolicies);
        writePolicyToFile.write(businessRolePolicies);
    }

    private static void populateRole(DataTableDTO dataTableDTO, RolePolicy rolePolicy, String role) {

        rolePolicy.setActions(List.of(dataTableDTO.getAction()));
        rolePolicy.setResources(List.of(dataTableDTO.getResource()));

        if (role.equals("tester")) {
            rolePolicy.setEffect(dataTableDTO.getTester());
        } else if (role.equals("functionalengineer")) {
            rolePolicy.setEffect(dataTableDTO.getFunctionalEngineer());
        } else if (role.equals("business")) {
            rolePolicy.setEffect(dataTableDTO.getBusiness());
        } else {
            throw new RuntimeException("unknown role found : " + role);
        }
    }
}