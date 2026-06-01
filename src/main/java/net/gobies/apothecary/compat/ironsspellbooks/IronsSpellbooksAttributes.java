package net.gobies.apothecary.compat.ironsspellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class IronsSpellbooksAttributes {

    public static Attribute spellPowerAttribute() {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            return AttributeRegistry.SPELL_POWER.get();
        }
        return null;
    }

    public static Attribute manaRegenerationAttribute() {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            return AttributeRegistry.MANA_REGEN.get();
        }
        return null;
    }
}
