package filterunique;

/**
 * @author Nanda Kumar
 * @since 25/11/2021
 */
public class TimeLimitExample {

    private String salesarea;
    private String deliveryPlant;
    private String route;

    public TimeLimitExample(String salesarea, String deliveryPlant, String route) {
        this.salesarea = salesarea;
        this.deliveryPlant = deliveryPlant;
        this.route = route;
    }

    public String getSalesarea() {
        return salesarea;
    }

    public void setSalesarea(String salesarea) {
        this.salesarea = salesarea;
    }

    public String getDeliveryPlant() {
        return deliveryPlant;
    }

    public void setDeliveryPlant(String deliveryPlant) {
        this.deliveryPlant = deliveryPlant;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }


    @Override
    public String toString() {
        return "TimeLimitExample{" +
                "salesarea='" + salesarea + '\'' +
                ", deliveryPlant='" + deliveryPlant + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
