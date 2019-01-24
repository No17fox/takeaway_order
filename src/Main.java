import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Tools tools = new Tools();
    tools.promptInput();
    try {
      tools.readUserInput();
    } catch (IOException e) {
      System.out.println("Exception encountered: " + e);
    }
  }
}
