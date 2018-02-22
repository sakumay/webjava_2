
public abstract class Factory {
  public final Restaurant create(String shopName) {
    Restaurant restaurant = createRestaurant(shopName);

    return restaurant;
}
  protected abstract Restaurant createRestaurant(String shopName);
}
