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