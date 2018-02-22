import java.util.Scanner;

public class Shop extends Restaurant {

  private String shopName;
  Shop(String shopName) {
  this.shopName = shopName;
  }

  public void work() {
  }

  @Override
  public int work(MenuData menuData, SelectionMenuData selectionMenuData) {
    //突然ステーキの処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int fee = 0;
    int meatFee = 0;

    while(continueFlg){
      System.out.println("\r\nお好きな肉の種類を選び、番号を入力してください\r\n");

      for(int count = 0; count < menuData.getSize(); count++) {
        System.out.print((count+1)+"）"+menuData.getName(count)+" ");
        System.out.print("：１gあたり "+menuData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）選択を終了する\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        return 0;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(menuData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          continueFlg = false;
          meatFee = menuData.getPrice(choseNumber-1);
        }
      }
    }

    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("◆◆お好みのグラム数をお選びください◆◆");
      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\nグラム数を入力してください　＞ ");
      String input = getInputData();

      try {
        choseNumber = Integer.parseInt(input);
      }catch(NumberFormatException error) {
        errorMassageFlg = true;
      }
      if(0 == choseNumber) {
        errorMassageFlg = true;
      }else {
        continueFlg = false;
        fee += meatFee * choseNumber;
      }
    }

    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("\r\nお好きなセットメニューを選び、番号を入力してください\r\n");

      for(int count = 0; count < selectionMenuData.getSize(); count++) {
        System.out.print((count+1)+"）"+selectionMenuData.getName(count)+" ");
        System.out.print("：＋ "+selectionMenuData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）セットメニューなし\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        continueFlg = false;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(selectionMenuData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          continueFlg = false;
          fee += selectionMenuData.getPrice(choseNumber-1);
        }
      }

    }
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("小計　｜"+fee+"円");
    int consumptionTax = (int)(fee * 0.08);
    System.out.println("消費税｜"+consumptionTax+"円");
    System.out.println("合計　｜"+(fee+consumptionTax)+"円");
    System.out.println("となります");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆"+shopName+"へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return fee+consumptionTax;

  }

  @Override
  public int work(MenuData menuData, AdditionalMenuData additionalData) {
    //ラーメン四郎の処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int fee = 0;

    while(continueFlg){
      System.out.println("\r\nお好きなラーメンの種類を選び、番号を入力してください\r\n");

      for(int count = 0; count < menuData.getSize(); count++) {
        System.out.print((count+1)+"）"+menuData.getName(count)+" ");
        System.out.print("： "+menuData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）選択を終了する\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        return 0;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(menuData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          continueFlg = false;
          fee += menuData.getPrice(choseNumber-1);
        }
      }
    }

    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("\r\nお好きなトッピングを選び、番号を入力してください\r\n");


      for(int count = 0; count < additionalData.getSize(); count++) {
        System.out.print((count+1)+"）"+additionalData.getName(count)+" ");
        System.out.print("：＋ "+additionalData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）トッピングの選択を終了する\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        continueFlg = false;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(additionalData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          fee += additionalData.getPrice(choseNumber-1);
          errorMassageFlg = false;
        }
      }

    }
    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("合計（税込）｜"+fee+"円");
    System.out.println("となります");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆"+shopName+"へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return fee;
  }


  @Override
  public int work(MenuData menuData, SelectionMenuData selectionMenuData,
      AdditionalMenuData additionalData) {
    //あかまるうどんの処理を記載
    System.out.println("◆◆"+shopName+"へようこそ◆◆");

    boolean continueFlg = true;
    boolean errorMassageFlg = false;
    int choseNumber = 0;
    int fee = 0;

    while(continueFlg){
      System.out.println("\r\nお好きなうどんの種類を選び、番号を入力してください\r\n");

      for(int count = 0; count < menuData.getSize(); count++) {
        System.out.print((count+1)+"）"+menuData.getName(count)+" ");
        System.out.print("： "+menuData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）選択を終了する\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        return 0;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(menuData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          continueFlg = false;
          fee += menuData.getPrice(choseNumber-1);
        }
      }
    }

    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("\r\nうどんのお好みを選び、番号を入力してください\r\n");

      for(int count = 0; count < selectionMenuData.getSize(); count++) {
        System.out.print((count+1)+"）"+selectionMenuData.getName(count)+" ");
        System.out.print("：＋ "+selectionMenuData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）そのまま\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        continueFlg = false;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(selectionMenuData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          continueFlg = false;
          fee += selectionMenuData.getPrice(choseNumber-1);
        }
      }
    }

    continueFlg = true;
    errorMassageFlg = false;
    while(continueFlg){
      System.out.println("\r\nお好きなトッピングを選び、番号を入力してください\r\n");


      for(int count = 0; count < additionalData.getSize(); count++) {
        System.out.print((count+1)+"）"+additionalData.getName(count)+" ");
        System.out.print("：＋ "+additionalData.getPrice(count)+"円\r\n");
      }
      System.out.print("e）トッピングの選択を終了する\r\n");

      if(errorMassageFlg) {
        System.out.println("\r\n[!]入力コマンドが正しくありませんでした[!]");
      }
      System.out.print("\r\n番号を入力してください　＞ ");

      String input = getInputData();

      if(input.equals("e")) {
        continueFlg = false;
      }else {
        try {
          choseNumber = Integer.parseInt(input);
        }catch(NumberFormatException error) {
          errorMassageFlg = true;
        }
        if(additionalData.getSize() < choseNumber || choseNumber == 0) {
          errorMassageFlg = true;
        }else {
          fee += additionalData.getPrice(choseNumber-1);
          errorMassageFlg = false;
        }
      }

    }

    System.out.println("\r\n◆◆  お会計  ◆◆");
    System.out.println("小計　｜"+fee+"円");
    int consumptionTax = (int)(fee * 0.08);
    System.out.println("消費税｜"+consumptionTax+"円");
    System.out.println("合計　｜"+(fee+consumptionTax)+"円");
    System.out.println("となります");

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\r\n◆◆"+shopName+"へのご利用ありがとうございました◆◆");
    System.out.println("◆◆またのご来店をお待ちしております◆◆");
    return fee;
  }

  private String getInputData() {
    Scanner scan = new Scanner(System.in);
    String input = scan.next();

    if(input.isEmpty()) {
      input = "b";
    }
    return input;
  }


}
