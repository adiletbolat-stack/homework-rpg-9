package com.narxoz.rpg.artifact;

public class RarityVisitor implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println(
                weapon.getName() + " rarity: LEGENDARY"
        );
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(
                potion.getName() + " rarity: COMMON"
        );
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(
                scroll.getName() + " rarity: RARE"
        );
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(
                ring.getName() + " rarity: EPIC"
        );
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(
                armor.getName() + " rarity: UNCOMMON"
        );
    }
}