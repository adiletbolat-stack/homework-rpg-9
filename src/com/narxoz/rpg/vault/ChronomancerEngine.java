package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.RarityVisitor;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.GoldValueVisitor;
import com.narxoz.rpg.visitor.LoreVisitor;
import com.narxoz.rpg.visitor.WeightAuditVisitor;

import java.util.List;

public class ChronomancerEngine {

    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return vault run summary result
     */
    public VaultRunResult runVault(List<Hero> party) {

        if (party == null || party.isEmpty()) {
            return new VaultRunResult(0, 0, 0);
        }

        int heroesProcessed = 0;
        int visitorsApplied = 0;
        int restoredHeroes = 0;

        for (Hero hero : party) {

            heroesProcessed++;

            System.out.println();
            System.out.println("=================================");
            System.out.println("Hero entering vault: " + hero.getName());
            System.out.println("=================================");

            Inventory inventory = new Inventory();

            inventory.addArtifact(
                    new Weapon("Dragon Slayer", 250, 15, 40)
            );

            inventory.addArtifact(
                    new Potion("Greater Healing Potion", 75, 2, 50)
            );

            inventory.addArtifact(
                    new Scroll("Scroll of Firestorm", 120, 1, "Firestorm")
            );



            inventory.addArtifact(
                    new Armor("Titan Plate", 200, 30, 25)
            );

            hero.setInventory(inventory);

            GoldValueVisitor goldVisitor = new GoldValueVisitor();
            WeightAuditVisitor weightVisitor = new WeightAuditVisitor();
            LoreVisitor loreVisitor = new LoreVisitor();
            RarityVisitor rarityVisitor = new RarityVisitor();

            System.out.println();
            System.out.println("=== APPRAISAL START ===");

            inventory.accept(goldVisitor);
            visitorsApplied++;

            inventory.accept(weightVisitor);
            visitorsApplied++;

            inventory.accept(loreVisitor);
            visitorsApplied++;

            inventory.accept(rarityVisitor);
            visitorsApplied++;

            System.out.println("=== APPRAISAL END ===");
            System.out.println();

            Caretaker caretaker = new Caretaker();

            System.out.println("Saving hero snapshot...");

            HeroMemento snapshot = hero.createMemento();

            caretaker.save(snapshot);

            System.out.println();
            System.out.println(hero.getName() + " triggered a vault trap!");

            hero.takeDamage(999);

            System.out.println("HP after trap: " + hero.getHp());

            HeroMemento restored = caretaker.undo();

            if (restored != null) {

                System.out.println();
                System.out.println("Rewinding hero state...");

                hero.restoreFromMemento(restored);

                restoredHeroes++;

                System.out.println(
                        hero.getName() + " restored successfully!"
                );

                System.out.println(
                        "Current HP: " + hero.getHp()
                );
            }

            System.out.println();
            System.out.println("Vault sequence complete.");
        }

        return new VaultRunResult(
                heroesProcessed,
                visitorsApplied,
                restoredHeroes
        );
    }
}