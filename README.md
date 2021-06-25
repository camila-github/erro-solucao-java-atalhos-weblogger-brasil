## Exercicio (Java):  Atalhos para o Weblogger Brasil

O exercicio publicado é referente ao treinamento do Bootcamp Java Developer - Introdução a Busca e Substituição em Java 
(https://digitalinnovation.one)


#### Descrição do Desafio:

Você está ajudando a desenvolver um sistema de gerenciamento de weblog chamado Weblogger Brasil. Embora Weblogger Brasil coloque todo o conteúdo direto no website em HTML, nem todos autores apreciam usar tags HTML em seus textos. Para tornar a vida deles mais fáceis, Weblogger Brasil oferece uma sintaxe simples chamada atalhos para obter alguns efeitos textuais em HTML. Sua tarefa é, dado um documento escrito com atalhos, traduzi-lo para o HTML apropriado.
Um atalho é usado para colocar texto em itálico. HTML faz isto com as tags < i> e < /i>, mas no Weblogger Brasil um autor pode simplesmente colocar um pedaço de texto entre dois caracteres de sublinhado, '_'. 

Portanto, onde um autor escreve
  Você _ _deveria_ _ ver a foca no zoologico!
                
Weblogger Brasil vai publicar o seguinte:
  Você <i>< i> deveria < /i></i> ver a foca no zoologico!
                
Outro atalho serve para colocar texto em negrito, o que, em HTML, é feito com as tags < b> e < /b> . Weblogger Brasil permite aos autores fazer o mesmo com pares do caractere asterisco, '*'.

Quando um autor escreve o texto
  Marque a conta  * *a receber* * para  * *paga* *
                
ele vai sair no website assim:
  Marque a conta <b>< b>a receber< /b></b> para <b>< b>paga< /b></b> .


#### Entrada:

A entrada contem vários casos de teste. Cada caso de teste é composto por uma linha que contem uma string texto, com zero ou mais usos dos atalhos itálico e negrito. Cada texto tem de 1 a 50 caracteres, inclusive. Os únicos caracteres permitidos no texto são os caracteres alfabéticos (de 'a' a 'z' e de 'A' a 'Z'), o sublinhado ('_'), o asterisco ('*'), o caractere de espaço e os símbolos de pontuação ',', ';', '.', '!', '?', '-', '(' e ')'. O caractere sublinhado '_' ocorre no texto um número par de vezes. O asterisco '*' também aparece um número par de vezes no texto. Nenhuma substring do texto entre um par de sublinhados ou entre um par de asteriscos pode conter outros sublinhados ou asteriscos, respectivamente.


#### Saída:

Para cada linha de entrada seu programa deve gerar uma linha de saída com o texto traduzido para HTML como demonstrado nos exemplos abaixo. Para tornar itálico um pedaço de texto no HTML, você deve iniciar este pedaço com a tag < i> e terminá-lo com a tag < /i>. Para texto em negrito, inicie com < b> e termine com < /b>.

Exemplos de Entrada  | Exemplos de Saída
------------- | -------------
Você _ _deveria_ _ ver a foca no zoologico! | Você < i><i>deveria</i>< /i> ver a foca no zoologico!
Marque a conta * *a receber* * para * *paga* *. | Marque a conta <b>< b><b>a receber</b>< /b> para < b><b>paga</b>< /b>.


#### Java　

```java
//SOLUCAO 1

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
```

