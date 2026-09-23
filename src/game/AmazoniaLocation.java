package game;

/**
 * ConcreteCreator (Factory Method).
 * Fábrica de inimigos da Amazônia — retorna MutantAnimal.
 * Único ponto do código que referencia MutantAnimal diretamente.
 */
public class AmazoniaLocation extends Location {

    @Override
    protected Enemy createEnemy() {
        return new MutantAnimal();
    }
}