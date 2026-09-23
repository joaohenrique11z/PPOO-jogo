package game;

/**
 * Creator (Factory Method).
 * Define o factory method abstrato createEnemy() e o template method enterLocation().
 * Não conhece nenhuma classe concreta de inimigo — só a abstração Enemy.
 */
public abstract class Location {

    /**
     * Factory Method — cada subclasse decide qual inimigo concreto criar.
     * Visibilidade protected: só as subclasses precisam implementar.
     */
    protected abstract Enemy createEnemy();

    /**
     * Template Method — comportamento comum a todas as localizações.
     * Cria o inimigo via factory method e executa o ataque.
     */
    public void enterLocation() {
        Enemy enemy = createEnemy();
        System.out.println("Um " + enemy.getName() + " apareceu!");
        enemy.attack();
    }
}