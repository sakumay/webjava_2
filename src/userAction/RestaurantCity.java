package userAction;

public class RestaurantCity {

  public static void main(String[] args) {

    int totalFee = 0;

    System.out.println("◆◆　RestaurantCity　◆◆");
    System.out.println("◆◆飲食店街へようこそ◆◆");

    Eater eater = new Eater();

    totalFee = eater.choseShop();

    if(totalFee != 0) {
      System.out.println("◆◆飲食店街を終了します◆◆\r\n");
      System.out.println("◆◇ 合計利用金額："+totalFee+"円 ◇◆\r\n\r\n");
      System.out.println("◆◆　お腹いっぱいになりましたか？　◆◆");
    }else {
      System.out.println("\r\n　（ただ立ち寄ってみただけだった・・・）\r\n");
    }

    System.out.println("◆◆またのお越しをお待ちしております◆◆");


  }
}
