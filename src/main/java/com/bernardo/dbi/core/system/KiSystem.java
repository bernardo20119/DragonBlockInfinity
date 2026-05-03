package com.bernardo.dbi.core.system;







public class KiSystem {
    




    public boolean useKi(int amount) {
       // ki logic here
       if (currentKi < amount) {
        return false;
       }

       currentKi -= amount;
       return true;
    }
}