package shopWork;

import productData.AdditionalMenuData;
import productData.MenuData;
import productData.OrderData;

public class RamenShirouShop extends Shop {

  RamenShirouShop(String shopName) {
    super(shopName);
  }


  MenuData menuData = new MenuData();
  AdditionalMenuData additionalData = new AdditionalMenuData();
  int totalFee = 0;

  @Override
  public void setMenu(){
    menuData.addData("小(小ラーメン)", 700);
    menuData.addData("小豚(小ラーメンチャーシュー増し)", 800);
    menuData.addData("大(大ラーメン)", 800);
    menuData.addData("大豚(大ラーメンチャーシュー増し)", 900);

    additionalData.addData("ニンニク", 0);
    additionalData.addData("ヤサイ", 0);
    additionalData.addData("アブラ", 0);
    additionalData.addData("カラメ", 0);
    additionalData.addData("煮玉子", 100);
    additionalData.addData("うずら(5個)", 100);
    additionalData.addData("チーズ", 100);
    additionalData.addData("魚粉", 50);
  }


  @Override
  public String orderCheck(OrderData orderData) {
    //ラーメン四郎の処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");
    //ラーメンの種類の確認
    String message1 = "\r\nお好きなラーメンの種類を選び、番号を入力してください\r\n";
    totalFee = checkMenuData(menuData, message1, orderData);
    if(totalFee < 0) {
      orderData.setOrderMessage("\r\nなにも注文をしなかった\r\n");
      return null;
    }else {
      orderData.setOrderMessage(shopName.concat("にて\r\n"));
      orderData.addOrderMessage(orderData.getOrder());
    }
    //トッピングの確認
    String message2 = "\r\nお好きなトッピングを選び、番号を入力してください\r\n";
    totalFee += checkAdditionalMenuData(additionalData, message2, orderData);

    if(orderData.getOrder() !=null) {
      orderData.addOrderMessage("\r\n"+orderData.getOrder());
    }
    return orderData.getOrderMessage();
  }


  @Override
  public int doAccounting() {
    //会計
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("合計（税込）｜"+totalFee+"円");
    System.out.println("となります");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆"+shopName+"へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return totalFee;
  }

}
