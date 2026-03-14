package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }
    @Override
    public String getActionName() {
        return super.getActionName();
    }
    @Override
    public int getDamage() {
        return super.getDamage() + 10;
    }
    @Override
    public String getEffectSummary() {
        String previous = super.getEffectSummary();
        if (previous.equals("None")) {
            return "Fire";
        }
        return previous + " Fire";
    }
}
