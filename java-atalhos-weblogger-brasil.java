import java.util.Scanner;

public class AtalhosWebloggerBrasil {
  public static void main(String[] args) {
    Scanner scr = new Scanner(System.in);
    String linhaEntrada;
        
    while(scr.hasNextLine()) {
      linhaEntrada = scr.nextLine();
      boolean inicio = true;
    
      while (linhaEntrada.contains("_") || linhaEntrada.contains("*")) {
        if (linhaEntrada.contains("_") && inicio) {
          linhaEntrada = linhaEntrada.replaceFirst("_", "<i>");
          inicio = false;
        } else if (linhaEntrada.contains("_") && !inicio) {
          linhaEntrada = linhaEntrada.replaceFirst("_", "</i>");
          inicio = true;
        } else if (linhaEntrada.contains("*") && inicio) {
          linhaEntrada = linhaEntrada.replaceFirst("\\*", "<b>");
          inicio = false;
        } else if (linhaEntrada.contains("*") && !inicio) {
          linhaEntrada = linhaEntrada.replaceFirst("\\*", "</b>");
          inicio = true;
        }
      }
            
      System.out.println(linhaEntrada);
    }
  }
}