package game;

/**
 * ConcreteCreator (Factory Method).
 * Fábrica de inimigos do Sertão — retorna Cangaceiro.
 * Único ponto do código que referencia Cangaceiro diretamente.
 */
public class SertaoLocation extends Location {

    @Override
    protected Enemy createEnemy() {
        return new Cangaceiro();
    }
}