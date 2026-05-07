package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class WeightAuditVisitor implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println(
                "Weapon weight: " + weapon.getWeight()
        );
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(
                "Potion weight: " + potion.getWeight()
        );
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(
                "Scroll weight: " + scroll.getWeight()
        );
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(
                "Ring weight: " + ring.getWeight()
        );
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(
                "Armor weight: " + armor.getWeight()
        );
    }
}