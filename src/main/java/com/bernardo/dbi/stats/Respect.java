package com.bernardo.dbi.stats;

/**
 * Sistema de Respeito - Rastreia o nível de respeito do jogador
 * Ganho através de ações honrosas e compatível com o sistema Dragon Ball
 */
public class Respect {
    private int points;
    private int level;
    private int experience; // XP necessário para próximo nível
    
    // Constantes de progressão
    private static final int BASE_EXP_FOR_LEVEL = 100;
    private static final int EXP_MULTIPLIER = 15; // Multiplica a cada nível
    private static final int MAX_LEVEL = 100;
    
    public Respect(int initialPoints) {
        this.points = Math.max(0, initialPoints);
        this.level = calculateLevel();
        this.experience = 0;
    }
    
    public Respect() {
        this(0);
    }
    
    // ===== GETTERS =====
    public int getPoints() { return points; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getProgressToNextLevel() { return experience; }
    
    // ===== GANHO DE RESPEITO =====
    
    /**
     * Ganha pontos de respeito através de ações honrosas
     */
    public void gainRespect(int amount) {
        if (amount <= 0) return;
        
        int oldLevel = level;
        points += amount;
        experience += amount;
        
        // Verifica levelup
        level = calculateLevel();
        if (level > oldLevel) {
            onLevelUp(oldLevel, level);
        }
    }
    
    /**
     * Perde respeito através de ações desonrosas
     */
    public void losRespect(int amount) {
        if (amount <= 0) return;
        points = Math.max(0, points - amount);
        level = calculateLevel();
    }
    
    /**
     * Ganha respeito ao vencer inimigos
     */
    public void gainRespectFromBattle(int enemyLevel, boolean victorious) {
        if (!victorious) {
            losRespect(enemyLevel / 2);
            return;
        }
        
        int respectGain = (int)(enemyLevel * 1.5);
        gainRespect(respectGain);
    }
    
    /**
     * Ganha respeito ao proteger outros
     */
    public void gainRespectFromProtection(int playersProtected) {
        gainRespect(50 * playersProtected);
    }
    
    /**
     * Ganha respeito ao completar quests honradas
     */
    public void gainRespectFromQuest(String questType, boolean completed) {
        if (!completed) return;
        
        int respect = switch(questType) {
            case "DEFENSE" -> 150;      // Defesa
            case "RESCUE" -> 200;       // Resgate
            case "TRAINING" -> 100;     // Treinamento
            case "TOURNAMENT" -> 300;   // Torneio
            default -> 50;
        };
        
        gainRespect(respect);
    }
    
    // ===== SISTEMA DE TIER =====
    
    /**
     * Retorna o tier atual baseado no nível
     */
    public RespectTier getTier() {
        return RespectTier.fromLevel(level);
    }
    
    /**
     * Calcula o nível baseado nos pontos de respeito
     */
    private int calculateLevel() {
        if (points <= 0) return 1;
        if (points >= getMaxPoints()) return MAX_LEVEL;
        
        int level = 1;
        int totalNeeded = 0;
        
        for (int i = 2; i <= MAX_LEVEL; i++) {
            int expNeeded = BASE_EXP_FOR_LEVEL * (i - 1) * EXP_MULTIPLIER;
            if (points < totalNeeded + expNeeded) {
                return i - 1;
            }
            totalNeeded += expNeeded;
            level = i;
        }
        
        return level;
    }
    
    /**
     * Retorna o máximo de pontos possível
     */
    public int getMaxPoints() {
        int total = 0;
        for (int i = 1; i <= MAX_LEVEL; i++) {
            total += BASE_EXP_FOR_LEVEL * i * EXP_MULTIPLIER;
        }
        return total;
    }
    
    /**
     * Retorna os pontos necessários para o próximo nível
     */
    public int getPointsForNextLevel() {
        if (level >= MAX_LEVEL) return 0;
        return BASE_EXP_FOR_LEVEL * level * EXP_MULTIPLIER;
    }
    
    /**
     * Retorna o progresso em porcentagem para o próximo nível
     */
    public double getProgressPercentage() {
        if (level >= MAX_LEVEL) return 100.0;
        
        int pointsNeeded = getPointsForNextLevel();
        int pointsEarned = calculatePointsEarnedInCurrentLevel();
        
        if (pointsNeeded <= 0) return 100.0;
        return (double) pointsEarned / pointsNeeded * 100.0;
    }
    
    /**
     * Calcula quantos pontos foram ganhos no nível atual
     */
    private int calculatePointsEarnedInCurrentLevel() {
        int total = 0;
        for (int i = 1; i < level; i++) {
            total += BASE_EXP_FOR_LEVEL * i * EXP_MULTIPLIER;
        }
        return points - total;
    }
    
    // ===== BÔNUS E EFEITOS =====
    
    /**
     * Retorna bônus de dano baseado no respeito
     */
    public double getDamageBonus() {
        return 1.0 + (level * 0.02); // +2% de dano por nível
    }
    
    /**
     * Retorna redução de dano baseada no respeito
     */
    public double getDefenseBonus() {
        return 1.0 + (level * 0.01); // +1% defesa por nível
    }
    
    /**
     * Retorna velocidade de movimento baseada no respeito
     */
    public double getSpeedBonus() {
        return 1.0 + (level * 0.008); // +0.8% velocidade por nível
    }
    
    /**
     * Retorna bônus de experiência em combate
     */
    public double getExperienceMultiplier() {
        return 1.0 + (level * 0.01); // +1% XP por nível
    }
    
    /**
     * Verifica se o jogador tem respeito suficiente para uma ação
     */
    public boolean canPerform(RespectAction action) {
        return level >= action.getMinimumLevel();
    }
    
    /**
     * Chamado quando sobe de nível
     */
    private void onLevelUp(int oldLevel, int newLevel) {
        // Aqui você pode adicionar eventos especiais de level up
        for (int i = oldLevel + 1; i <= newLevel; i++) {
            RespectMilestone milestone = RespectMilestone.getMilestone(i);
            if (milestone != null) {
                // Evento de milestone alcançado
            }
        }
    }
    
    @Override
    public String toString() {
        return String.format("Respect[points=%d, level=%d, tier=%s]", 
            points, level, getTier().getName());
    }
}
