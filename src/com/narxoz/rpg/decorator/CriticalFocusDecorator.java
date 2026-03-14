package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName();
    }
    @Override
    public int getDamage() {
        return super.getDamage() * 2;
    }
    @Override
    public String getEffectSummary() {
        String previous = super.getEffectSummary();
        if (previous.equals("None")) {
            return "Critical";
        }
        return previous + " Critical";
    }
}
