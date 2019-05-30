package com.macaco;

public class Personaje extends Entidad {
    private boolean weapon;

    public void setWeapon(boolean weapon)
    {
        this.weapon = weapon;
    }

    public boolean hasWeapon()
    {
        return weapon;
    }
}
