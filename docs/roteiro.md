# Roteiro de Implementação — Factory Method

> **Como usar este documento:** siga as etapas **uma por vez**, na ordem.
> Faça o commit de cada etapa antes de avançar para a próxima.
> O histórico de commits deve contar a evolução real do projeto.

Todos os arquivos Java ficam em `src/game/` e pertencem ao pacote `game`.

---

## Etapa 2 — Classe abstrata `Enemy` (Product)

### Onde colocar
Criar arquivo novo: `src/game/Enemy.java`

### O que colocar
```java
// Arquivo novo
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
```

### Como deve ficar (resultado esperado)
Nenhuma saída no console — este passo é só estrutura. O arquivo deve compilar sem erros:
```
javac src/game/Enemy.java
```

### Commit sugerido
```
feat: adiciona classe abstrata Enemy (Product)
```

---

## Etapa 3 — `MutantAnimal` (ConcreteProduct)

### Onde colocar
Criar arquivo novo: `src/game/MutantAnimal.java`

### O que colocar
```java
// Arquivo novo
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
```

### Como deve ficar (resultado esperado)
Nenhuma saída no console — este passo é só estrutura. Os dois arquivos devem compilar juntos sem erros:
```
javac src/game/Enemy.java src/game/MutantAnimal.java
```

### Commit sugerido
```
feat: adiciona MutantAnimal (ConcreteProduct da Amazônia)
```

---

## Etapa 4 — `Cangaceiro` (ConcreteProduct)

### Onde colocar
Criar arquivo novo: `src/game/Cangaceiro.java`

### O que colocar
```java
// Arquivo novo
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
```

### Como deve ficar (resultado esperado)
Nenhuma saída no console — este passo é só estrutura. Os três arquivos devem compilar juntos sem erros:
```
javac src/game/Enemy.java src/game/MutantAnimal.java src/game/Cangaceiro.java
```

### Commit sugerido
```
feat: adiciona Cangaceiro (ConcreteProduct do Sertão)
```

---

## Etapa 5 — Classe abstrata `Location` (Creator)

### Onde colocar
Criar arquivo novo: `src/game/Location.java`

### O que colocar
```java
// Arquivo novo
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
```

### Como deve ficar (resultado esperado)
Nenhuma saída no console — este passo é só estrutura. Todos os arquivos devem compilar juntos sem erros:
```
javac src/game/*.java
```

### Commit sugerido
```
feat: adiciona classe abstrata Location (Creator) com factory e template method
```

---

## Etapa 6 — `AmazoniaLocation` (ConcreteCreator)

### Onde colocar
Criar arquivo novo: `src/game/AmazoniaLocation.java`

### O que colocar
```java
// Arquivo novo
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
```

### Como deve ficar (resultado esperado)
Nenhuma saída no console — este passo é só estrutura. Todos os arquivos devem compilar:
```
javac src/game/*.java
```

### Commit sugerido
```
feat: adiciona AmazoniaLocation (ConcreteCreator da Amazônia)
```

---

## Etapa 7 — `SertaoLocation` (ConcreteCreator)

### Onde colocar
Criar arquivo novo: `src/game/SertaoLocation.java`

### O que colocar
```java
// Arquivo novo
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
```

### Como deve ficar (resultado esperado)
Nenhuma saída no console — este passo é só estrutura. Todos os arquivos devem compilar:
```
javac src/game/*.java
```

### Commit sugerido
```
feat: adiciona SertaoLocation (ConcreteCreator do Sertão)
```

---

## Etapa 8 — Classe de simulação `GameTestDrive`

### Onde colocar
Criar arquivo novo: `src/game/GameTestDrive.java`

### O que colocar
```java
// Arquivo novo
package game;

/**
 * Simulação / Test Drive.
 * Demonstra o Factory Method: o código cliente usa apenas as abstrações
 * Location e Enemy — as classes concretas só aparecem na instanciação
 * das localizações.
 */
public class GameTestDrive {

    public static void main(String[] args) {
        System.out.println("=== Jogo de Ação — Localizações Brasileiras ===");
        System.out.println();

        // Variáveis tipadas como Location (abstração), não como classe concreta
        Location amazonia = new AmazoniaLocation();
        Location sertao = new SertaoLocation();

        System.out.println(">> Jogador entra na Amazônia:");
        amazonia.enterLocation();

        System.out.println();

        System.out.println(">> Jogador entra no Sertão:");
        sertao.enterLocation();
    }
}
```

### Como deve ficar (resultado esperado)
Compilar e executar:
```
javac src/game/*.java
java -cp src game.GameTestDrive
```

Saída exata esperada no console:
```
=== Jogo de Ação — Localizações Brasileiras ===

>> Jogador entra na Amazônia:
Um Animal Mutante apareceu!
O Animal Mutante ataca com garras venenosas!

>> Jogador entra no Sertão:
Um Cangaceiro apareceu!
O Cangaceiro ataca com seu punhal!
```

### Commit sugerido
```
feat: adiciona GameTestDrive com simulação das duas localizações
```

---

## Nota Final — Extensibilidade futura (Rio de Janeiro)

> **Não implementar agora.** Esta seção existe apenas para demonstrar que a
> arquitetura permite extensão sem modificação do código existente (Open/Closed Principle).

Para adicionar o Rio de Janeiro no futuro, bastaria criar **dois arquivos novos**:

**`src/game/Criminal.java`** (novo ConcreteProduct):
```java
package game;

public class Criminal extends Enemy {
    @Override
    public String getName() {
        return "Criminoso";
    }

    @Override
    public void attack() {
        System.out.println("O Criminoso ataca com uma arma improvisada!");
    }
}
```

**`src/game/RioDeJaneiroLocation.java`** (novo ConcreteCreator):
```java
package game;

public class RioDeJaneiroLocation extends Location {
    @Override
    protected Enemy createEnemy() {
        return new Criminal();
    }
}
```

**Nenhum arquivo existente precisaria ser alterado** — apenas o `GameTestDrive` ganharia
mais uma chamada para demonstrar a nova localização. Isso é a essência do Factory Method.

---

## Checklist

Marque cada etapa conforme for commitando:

- [ ] Etapa 1 — Diagrama de classes (`docs/diagrama.md`)
- [ ] Etapa 2 — Classe abstrata `Enemy` (Product)
- [ ] Etapa 3 — `MutantAnimal` (ConcreteProduct)
- [ ] Etapa 4 — `Cangaceiro` (ConcreteProduct)
- [ ] Etapa 5 — Classe abstrata `Location` (Creator)
- [ ] Etapa 6 — `AmazoniaLocation` (ConcreteCreator)
- [ ] Etapa 7 — `SertaoLocation` (ConcreteCreator)
- [ ] Etapa 8 — `GameTestDrive` (simulação)
