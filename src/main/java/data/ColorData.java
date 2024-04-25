package data;

public enum ColorData {

   WHITE ("Белый"),
   BLACK ("Чёрный"),
   GREY("Серый");


    private final String name;

    ColorData(String name)
    {this.name=name;}


  public String getName() {return name;}


}