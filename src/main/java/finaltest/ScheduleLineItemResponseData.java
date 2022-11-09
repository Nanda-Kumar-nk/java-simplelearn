package finaltest;

import java.math.BigDecimal;

/**
 * @author Nanda Kumar
 * @since 06/06/2022
 */
public class ScheduleLineItemResponseData {
    private static final long serialVersionUID = 1L;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.itemNumber</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String itemNumber;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.baseUom</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String baseUom;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.confirmedQuantity</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private BigDecimal confirmedQuantity;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.reqType</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String reqType;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.salesUnit</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String salesUnit;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.requestedQuantity</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private BigDecimal requestedQuantity;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.scheduleLine1</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String scheduleLine1;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.reqTime</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String reqTime;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.loadDate</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String loadDate;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.reqDate</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private String reqDate;

    public ScheduleLineItemResponseData()
    {
        // default constructor
    }

    public void setItemNumber(final String itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    public String getItemNumber()
    {
        return itemNumber;
    }

    public void setBaseUom(final String baseUom)
    {
        this.baseUom = baseUom;
    }

    public String getBaseUom()
    {
        return baseUom;
    }

    public void setConfirmedQuantity(final BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    public BigDecimal getConfirmedQuantity()
    {
        return confirmedQuantity;
    }

    public void setReqType(final String reqType)
    {
        this.reqType = reqType;
    }

    public String getReqType()
    {
        return reqType;
    }

    public void setSalesUnit(final String salesUnit)
    {
        this.salesUnit = salesUnit;
    }

    public String getSalesUnit()
    {
        return salesUnit;
    }

    public void setRequestedQuantity(final BigDecimal requestedQuantity)
    {
        this.requestedQuantity = requestedQuantity;
    }

    public BigDecimal getRequestedQuantity()
    {
        return requestedQuantity;
    }

    public void setScheduleLine1(final String scheduleLine1)
    {
        this.scheduleLine1 = scheduleLine1;
    }

    public String getScheduleLine1()
    {
        return scheduleLine1;
    }

    public void setReqTime(final String reqTime)
    {
        this.reqTime = reqTime;
    }

    public String getReqTime()
    {
        return reqTime;
    }

    public void setLoadDate(final String loadDate)
    {
        this.loadDate = loadDate;
    }

    public String getLoadDate()
    {
        return loadDate;
    }

    public void setReqDate(final String reqDate)
    {
        this.reqDate = reqDate;
    }

    public String getReqDate()
    {
        return reqDate;
    }
}