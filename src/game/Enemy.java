package game;

/**
 * Product (Factory Method).
 * Define a interface comum de todos os inimigos do jogo.
 */
public abstract class Enemy {

    /** Retorna o nome de exibição do inimigo. */
    public abstract String getName();

    /** Executa o ataque do inimigo (imprime no console). */
    public abstract void attack();
}