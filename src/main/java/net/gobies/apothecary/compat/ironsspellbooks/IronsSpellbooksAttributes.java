package net.gobies.apothecary.compat.ironsspellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class IronsSpellbooksAttributes {

    public static Attribute spellPowerAttribute() {
        return AttributeRegistry.SPELL_POWER.get();
    }

    public static Attribute manaRegenerationAttribute() {
        return AttributeRegistry.MANA_REGEN.get();
    }
}
