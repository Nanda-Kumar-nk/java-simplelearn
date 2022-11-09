package excelread;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ReadTableFromExcel {

    private static final String EXCEL_PATH = "D:\\others\\ldpolicygeneration\\new\\Book1.xlsx";

    public List<DataTableDTO> getEntries() {

        List<DataTableDTO> tableValues = new ArrayList<>();

        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(EXCEL_PATH);
            String strSelectQuerry = "Select * from  Data";
            System.out.println(strSelectQuerry);

            Recordset recordset = null;
            recordset = connection.executeQuery(strSelectQuerry);
            List<String> fieldNames = recordset.getFieldNames();
            System.out.println(fieldNames);

            int rowIndex = 1;
            while (recordset.next()) {
                DataTableDTO dataTableDTO = new DataTableDTO();

                dataTableDTO.setActions(getFieldValue(recordset, "Actions", rowIndex));

                dataTableDTO.setTester(getFieldValue(recordset, "Tester", rowIndex));
                dataTableDTO.setFunctionalEngineer(getFieldValue(recordset, "Functional Engineer", rowIndex));
                dataTableDTO.setBusiness(getFieldValue(recordset, "Business", rowIndex));
                dataTableDTO.setResource(getFieldValue(recordset, "Resource", rowIndex));
                dataTableDTO.setAction(getFieldValue(recordset, "Action", rowIndex));

                tableValues.add(dataTableDTO);

                rowIndex++;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tableValues;
    }

    private static String getFieldValue(Recordset recordset, String fieldName, int rowIndex) throws FilloException {
        String value = recordset.getField(fieldName);
        if (StringUtils.isBlank(value)) {
            throw new RuntimeException("row has empty fields   in row " + rowIndex);
        }
        return StringUtils.trim(value);
    }
}