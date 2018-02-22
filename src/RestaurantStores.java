
public class RestaurantStores extends Factory {

  @Override
  protected Restaurant createRestaurant(String shopName) {

    return new Shop(shopName);
  }

}
