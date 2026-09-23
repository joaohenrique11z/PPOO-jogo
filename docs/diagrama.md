# Diagrama de Classes — Factory Method

## Mapeamento do Padrão

| Papel no padrão    | Classe no jogo       | Responsabilidade                                                        |
|--------------------|-----------------------|--------------------------------------------------------------------------|
| **Product**        | `Enemy` (abstract)   | Interface comum dos inimigos: `getName()` e `attack()`                  |
| **ConcreteProduct**| `MutantAnimal`, `Cangaceiro` | Implementações concretas com nome e ataque próprios              |
| **Creator**        | `Location` (abstract)| Factory method `createEnemy()` + template method `enterLocation()`      |
| **ConcreteCreator**| `AmazoniaLocation`, `SertaoLocation` | Implementam `createEnemy()` retornando o inimigo da região|

## Diagrama

```mermaid
classDiagram
    direction LR

    class Enemy {
        <<abstract>>
        +String getName()
        +void attack()
    }

    class MutantAnimal {
        +String getName()
        +void attack()
    }

    class Cangaceiro {
        +String getName()
        +void attack()
    }

    class Location {
        <<abstract>>
        #Enemy createEnemy()*
        +void enterLocation()
    }

    class AmazoniaLocation {
        #Enemy createEnemy()
    }

    class SertaoLocation {
        #Enemy createEnemy()
    }

    Enemy <|-- MutantAnimal
    Enemy <|-- Cangaceiro
    Location <|-- AmazoniaLocation
    Location <|-- SertaoLocation
    Location ..> Enemy : cria via factory
```

> `createEnemy()` é abstrato em `Location` — cada `ConcreteCreator` fornece sua própria implementação.

## Extensibilidade

Para adicionar uma nova localização (ex: Rio de Janeiro), basta criar:
- `Criminal extends Enemy`
- `RioDeJaneiroLocation extends Location`

Nenhuma alteração no código existente é necessária.