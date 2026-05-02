package com.bernardo.dbi.core.system;

import com.bernardo.dbi.stats.Spi;
import com.bernardo.dbi.stats.Will;

public class KiSystem {

    public int Spi;
    public int Will;
    public int regenKi;

    public KiSystem(int spi, int will) {
        this.Spi = spi;
        this.Will = will;
        this.regenKi = 0;
    }

    // Regen parado (idle)
    public void regenerateIdleKi(Spi spi) {
        regenKi = (int)(spi.getMaxKi() * spi.getKiRegenRate());
        spi.restoreKi(regenKi);
    }

    // Regen em combate
    public void regenerateCombatKi(Spi spi) {

        // Se estiver gastando muito Ki, reduz regen
        if (regenKi <= -5) {
            regenKi = (int)(spi.getMaxKi() * (spi.getKiRegenRate() * 0.5));
        } else {
            regenKi = (int)(spi.getMaxKi() * (spi.getKiRegenRate() * 0.2));
        }

        spi.restoreKi(regenKi);
    }

    public void consumeKI(Spi spi, int amount) {
        spi.useKi(amount);
    }

    public void consumeKiJump(Spi spi, int amount) {
        spi.useKi(amount);
    }

    public void consumeKIRun(Spi spi, int amount) {
        spi.useKi(amount);
    }
}
