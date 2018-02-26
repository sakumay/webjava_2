package shopWork;

public class ShopFactory extends Factory {

  @Override
  protected Shop createShop(String shopName) {

    switch(shopName) {

      case "突然ステーキ":
        return new TotsuzenStakeShop(shopName);

      case "ラーメン四郎":
        return new RamenShirouShop(shopName);

      case "あかまるうどん":
        return new AkamaruUdonShop(shopName);

    }

    return null;

  }

}
