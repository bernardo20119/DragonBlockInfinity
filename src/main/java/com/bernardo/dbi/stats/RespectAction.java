package com.bernardo.dbi.stats;

/**
 * Define ações que requerem um nível mínimo de respeito
 */
public enum RespectAction {
    // Ações básicas
    LEARN_BASIC_TECHNIQUE(1, "Aprender Técnica Básica"),
    MEDITATE(5, "Meditar"),
    SENSE_ENERGY(10, "Sentir Energia"),
    
    // Ações intermediárias
    CHALLENGE_WEAK_OPPONENT(20, "Desafiar Oponente Fraco"),
    TEACH_DISCIPLE(25, "Ensinar Discípulo"),
    UNLOCK_INTERMEDIATE_TECHNIQUE(30, "Desbloquear Técnica Intermediária"),
    
    // Ações avançadas
    CHALLENGE_STRONG_OPPONENT(45, "Desafiar Oponente Forte"),
    ACCESS_SACRED_TRAINING(50, "Acessar Treinamento Sagrado"),
    LEARN_ADVANCED_TECHNIQUE(55, "Aprender Técnica Avançada"),
    
    // Ações de mestre
    TRAIN_MULTIPLE_DISCIPLES(70, "Treinar Múltiplos Discípulos"),
    UNLOCK_MASTER_TECHNIQUE(75, "Desbloquear Técnica de Mestre"),
    PARTICIPATE_WORLD_TOURNAMENT(80, "Participar do Torneio Mundial"),
    
    // Ações divinas
    UNLOCK_GODLY_POWER(90, "Desbloquear Poder Divino"),
    TEST_GOD_STRENGTH(95, "Testar Força Divina"),
    ACHIEVE_GODHOOD(99, "Alcançar Divindade");
    
    private final int minimumLevel;
    private final String description;
    
    RespectAction(int minimumLevel, String description) {
        this.minimumLevel = minimumLevel;
        this.description = description;
    }
    
    public int getMinimumLevel() { return minimumLevel; }
    public String getDescription() { return description; }
}
