package game;

/**
 * ConcreteProduct (Factory Method).
 * Inimigo exclusivo da Amazônia.
 */
public class MutantAnimal extends Enemy {

    @Override
    public String getName() {
        return "Animal Mutante";
    }

    @Override
    public void attack() {
        System.out.println("O Animal Mutante ataca com garras venenosas!");
    }
}