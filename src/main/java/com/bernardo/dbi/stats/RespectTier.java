package com.bernardo.dbi.stats;

/**
 * Define os Tiers de Respeito do sistema Dragon Ball
 * Baseado nos títulos e reputação do universo
 */
public enum RespectTier {
    OUTCAST(1, 10, "Exilado", 0xFF0000),           // Vermelho escuro
    UNKNOWN(11, 20, "Desconhecido", 0x808080),     // Cinza
    NOVICE(21, 30, "Novato", 0xFFFF00),            // Amarelo
    WARRIOR(31, 45, "Guerreiro", 0xFF8C00),        // Laranja
    FIGHTER(46, 60, "Lutador", 0xFF6347),          // Tomate
    CHAMPION(61, 75, "Campeão", 0x32CD32),         // Verde Lima
    MASTER(76, 85, "Mestre", 0x4169E1),            // Azul Royal
    LEGEND(86, 95, "Lenda", 0xFFD700),             // Ouro
    DIVINE(96, 100, "Divino", 0xFF1493),           // Rosa profundo
    SUPREME(101, 100, "Supremo", 0xFFFFFF);        // Branco (especial)
    
    private final int minLevel;
    private final int maxLevel;
    private final String name;
    private final int color;
    
    RespectTier(int minLevel, int maxLevel, String name, int color) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.name = name;
        this.color = color;
    }
    
    public int getMinLevel() { return minLevel; }
    public int getMaxLevel() { return maxLevel; }
    public String getName() { return name; }
    public int getColor() { return color; }
    
    /**
     * Retorna o tier baseado no nível
     */
    public static RespectTier fromLevel(int level) {
        for (RespectTier tier : values()) {
            if (level >= tier.minLevel && level <= tier.maxLevel) {
                return tier;
            }
        }
        return OUTCAST;
    }
    
    /**
     * Retorna uma descrição do tier
     */
    public String getDescription() {
        return switch(this) {
            case OUTCAST -> "Considerado um criminoso ou vilão";
            case UNKNOWN -> "Pouco conhecido, sem reputação definida";
            case NOVICE -> "Iniciante, começando sua jornada";
            case WARRIOR -> "Um guerreiro respeitado e competente";
            case FIGHTER -> "Um lutador forte e honrado";
            case CHAMPION -> "Campeão reconhecido e admirado";
            case MASTER -> "Mestre das artes marciais e estratégia";
            case LEGEND -> "Uma lenda viva do universo";
            case DIVINE -> "Guerreiro de poder divino";
            case SUPREME -> "O ser mais respeitado do universo";
        };
    }
    
    /**
     * Retorna bônus especial do tier
     */
    public double getTierBonus() {
        return switch(this) {
            case OUTCAST -> 0.5;    // -50% bônus
            case UNKNOWN -> 1.0;    // Sem bônus
            case NOVICE -> 1.1;     // +10% bônus
            case WARRIOR -> 1.2;    // +20% bônus
            case FIGHTER -> 1.3;    // +30% bônus
            case CHAMPION -> 1.5;   // +50% bônus
            case MASTER -> 1.75;    // +75% bônus
            case LEGEND -> 2.0;     // +100% bônus
            case DIVINE -> 2.5;     // +150% bônus
            case SUPREME -> 3.0;    // +200% bônus
        };
    }
}
