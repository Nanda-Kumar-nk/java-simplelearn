package sometest;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Nanda Kumar
 * @since 13/10/2022
 */
public class ScheduleLineData {

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

    private Date reqTime;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.loadDate</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private Date loadDate;

    /** <i>Generated property</i> for <code>ScheduleLineItemResponseData.reqDate</code> property defined at extension <code>signifysapgatewayservices</code>. */

    private Date reqDate;

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getBaseUom() {
        return baseUom;
    }

    public void setBaseUom(String baseUom) {
        this.baseUom = baseUom;
    }

    public BigDecimal getConfirmedQuantity() {
        return confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity) {
        this.confirmedQuantity = confirmedQuantity;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(String salesUnit) {
        this.salesUnit = salesUnit;
    }

    public BigDecimal getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(BigDecimal requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public String getScheduleLine1() {
        return scheduleLine1;
    }

    public void setScheduleLine1(String scheduleLine1) {
        this.scheduleLine1 = scheduleLine1;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }
}
