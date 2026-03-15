package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Knight", 120);
        BossEnemy boss = new BossEnemy("Dragon", 150, 18);

        AttackAction basic = new BasicAttack("Sword Slash", 20);

        AttackAction fireAttack =
                new FireRuneDecorator(basic);
        AttackAction poisonFireAttack =
                new PoisonCoatingDecorator(
                        new FireRuneDecorator(basic)
                );
        AttackAction ultimateAttack =
                new CriticalFocusDecorator(
                        new PoisonCoatingDecorator(
                                new FireRuneDecorator(basic)
                        )
                );
        AttackAction enhanced = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)
                )
        );

        System.out.println("--- Decorator Preview ---");
        System.out.println("Base action: " + basic.getActionName());
        System.out.println("Base damage: " + basic.getDamage());
        System.out.println("Base effects: " + basic.getEffectSummary());
        System.out.println();
        System.out.println("Fire attack damage: " + fireAttack.getDamage());
        System.out.println("Poison + Fire damage: " + poisonFireAttack.getDamage());
        System.out.println();
        System.out.println("Ultimate Attack (Fire + Poison + Critical):");
        System.out.println("Damage: " + ultimateAttack.getDamage());
        System.out.println("Effects: " + ultimateAttack.getEffectSummary());
        System.out.println();
        System.out.println("Enhanced action: " + enhanced.getActionName());
        System.out.println("Enhanced damage: " + enhanced.getDamage());
        System.out.println("Enhanced effects: " + enhanced.getEffectSummary());

        System.out.println("\n--- Facade Preview ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, enhanced);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println("\n=== Demo Complete ===");
    }
}
