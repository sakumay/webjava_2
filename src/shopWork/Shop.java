package shopWork;

public abstract class Shop {

  protected String shopName;

  Shop(String shopName) {
    this.shopName = shopName;
  }

  public abstract int work();

}
