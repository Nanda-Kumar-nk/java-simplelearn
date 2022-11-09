package trygeneric;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */

import java.io.Serializable;


public  class SapGenericTableOutputLine  implements Serializable
{

    /** Default serialVersionUID value. */

    private static final long serialVersionUID = 1L;

    /** <i>Generated property</i> for <code>SapGenericTableOutputLine.fieldName</code> property defined at extension <code>philipslightingoutboundservices</code>. */

    private String fieldName;

    /** <i>Generated property</i> for <code>SapGenericTableOutputLine.fieldValue</code> property defined at extension <code>philipslightingoutboundservices</code>. */

    private String fieldValue;

    public SapGenericTableOutputLine()
    {
        // default constructor
    }

    public void setFieldName(final String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldValue(final String fieldValue)
    {
        this.fieldValue = fieldValue;
    }

    public String getFieldValue()
    {
        return fieldValue;
    }


}
