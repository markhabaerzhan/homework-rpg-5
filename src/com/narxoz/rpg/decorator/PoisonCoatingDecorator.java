package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName();
    }
    @Override
    public int getDamage() {
        return super.getDamage() + 5;
    }
    @Override
    public String getEffectSummary() {
        String previous = super.getEffectSummary();
        if (previous.equals("None")) {
            return "Poison";
        }
        return previous + " Poison";
    }
}
