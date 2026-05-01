package com.bernardo.dbi.stats;

import java.util.HashMap;
import java.util.Map;

/**
 * Define marcos/milestones especiais ao atingir certos níveis de respeito
 */
public class RespectMilestone {
    private static final Map<Integer, RespectMilestone> MILESTONES = new HashMap<>();
    
    static {
        // Milestones cada 10 níveis
        MILESTONES.put(10, new RespectMilestone(10, "Guerreiro em Treinamento", "Você está começando a ser reconhecido"));
        MILESTONES.put(20, new RespectMilestone(20, "Iniciante Confiável", "Sua reputação começa a crescer"));
        MILESTONES.put(30, new RespectMilestone(30, "Guerreiro Respeitado", "Você é agora um verdadeiro guerreiro"));
        MILESTONES.put(40, new RespectMilestone(40, "Combatente Formidável", "Sua força é amplamente reconhecida"));
        MILESTONES.put(50, new RespectMilestone(50, "Campeão Emergente", "Você está entre os melhores"));
        MILESTONES.put(60, new RespectMilestone(60, "Campeão Confirmado", "Sua vitória é praticamente certa"));
        MILESTONES.put(70, new RespectMilestone(70, "Mestre Renomado", "Você é um mestre reconhecido mundialmente"));
        MILESTONES.put(80, new RespectMilestone(80, "Lenda em Ascensão", "Sua legenda começa a ser contada"));
        MILESTONES.put(90, new RespectMilestone(90, "Lenda Absoluta", "Você é uma lenda do universo"));
        MILESTONES.put(100, new RespectMilestone(100, "Ser Supremo", "Você atingiu o respeito máximo"));
    }
    
    private final int level;
    private final String title;
    private final String description;
    
    public RespectMilestone(int level, String title, String description) {
        this.level = level;
        this.title = title;
        this.description = description;
    }
    
    public int getLevel() { return level; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    
    /**
     * Obtém um milestone para um nível específico
     */
    public static RespectMilestone getMilestone(int level) {
        return MILESTONES.get(level);
    }
    
    /**
     * Verifica se um nível é um milestone
     */
    public static boolean isMilestone(int level) {
        return MILESTONES.containsKey(level);
    }
    
    /**
     * Obtém todos os milestones
     */
    public static Map<Integer, RespectMilestone> getAllMilestones() {
        return new HashMap<>(MILESTONES);
    }
}
