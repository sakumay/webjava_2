package shopWork;
//import Restaurant;

public abstract class Factory {
  public final Shop create(String shopName) {

    Shop shop = createShop(shopName);

    return shop;
  }
  protected abstract Shop createShop(String shopName);
}
