package UI;

import Core.Core;

public class ClientUI {

    private final Core core;

    public ClientUI(Core core) {
        this.core = core;
    }

    public void mainPage() {
        System.out.println("----Main menu----");
        System.out.println("1 - Jogar contra o computador.");
        System.out.println("2 - Jogar localmente com outra pessoa.");
        System.out.println("3 - Jogar online com outra pessoa.");
        System.out.println("0 - Sair do jogo.");
    }

    public void exitMessage() {
        System.out.println("Obrigado por jogar o nosso jogo! Até mais!");
    }
}
