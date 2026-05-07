package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class GoldValueVisitor implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println(
                weapon.getName() + " value: " + weapon.getValue() + " gold"
        );
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(
                potion.getName() + " value: " + potion.getValue() + " gold"
        );
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(
                scroll.getName() + " value: " + scroll.getValue() + " gold"
        );
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(
                ring.getName() + " value: " + ring.getValue() + " gold"
        );
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(
                armor.getName() + " value: " + armor.getValue() + " gold"
        );
    }
}