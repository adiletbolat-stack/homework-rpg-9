package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class LoreVisitor implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println(
                weapon.getName() + " was forged in dragon fire."
        );
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(
                potion.getName() + " was brewed by forgotten alchemists."
        );
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(
                scroll.getName() + " contains ancient runes."
        );
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(
                ring.getName() + " belonged to an immortal king."
        );
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(
                armor.getName() + " protected heroes in ancient wars."
        );
    }
}