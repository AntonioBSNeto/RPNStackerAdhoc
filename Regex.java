public class Regex {

  public static boolean isNum(String token) {
    return token.matches("[0-9]+");
  }

  public static boolean isOP(String token) {
    return token.matches("(\\+|-|\\*|/)");
  }

}