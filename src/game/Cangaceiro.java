package game;

/**
 * ConcreteProduct (Factory Method).
 * Inimigo exclusivo do Sertão.
 */
public class Cangaceiro extends Enemy {

    @Override
    public String getName() {
        return "Cangaceiro";
    }

    @Override
    public void attack() {
        System.out.println("O Cangaceiro ataca com seu punhal!");
    }
}