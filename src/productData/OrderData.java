package productData;

public class OrderData {

  protected String order;
  protected String orderMessage = null;

  public void setOrder(String order) {
    this.order = order;
  }

  public String getOrder() {
    return order;
  }

  public void setOrderMessage(String orderMessage) {
    this.orderMessage = orderMessage;
  }

  public void addOrderMessage(String addMessage) {
    this.orderMessage = this.orderMessage.concat(addMessage);
  }
  public String getOrderMessage() {
    return orderMessage;
  }

}
