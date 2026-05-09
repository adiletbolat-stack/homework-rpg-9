package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.visitor.GoldValueVisitor;
import com.narxoz.rpg.visitor.LoreVisitor;
import com.narxoz.rpg.visitor.WeightAuditVisitor;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        printBanner();
        Hero warrior = new Hero(
                "Albert",
                150,
                25,
                35,
                20,
                100,
                new Inventory()
        );

        Hero mage = new Hero(
                "Kate",
                90,
                120,
                15,
                8,
                250,
                new Inventory()
        );


        GoldValueVisitor goldVisitor = new GoldValueVisitor();
        WeightAuditVisitor weightVisitor = new WeightAuditVisitor();
        LoreVisitor loreVisitor = new LoreVisitor();

        System.out.println("Visitors initialized:");
        System.out.println("- " + goldVisitor.getClass().getSimpleName());
        System.out.println("- " + weightVisitor.getClass().getSimpleName());
        System.out.println("- " + loreVisitor.getClass().getSimpleName());

        ChronomancerEngine engine = new ChronomancerEngine();

    
        VaultRunResult result = engine.runVault(
               Arrays.asList(warrior, mage)
        );


        System.out.println();
        System.out.println("=== FINAL VAULT RESULT ===");
        System.out.println(result);
    }

    private static void printBanner() {

        System.out.println("====================================");
        System.out.println("     CHRONOMANCER'S VAULT DEMO      ");
        System.out.println("====================================");
        System.out.println();
    }
}