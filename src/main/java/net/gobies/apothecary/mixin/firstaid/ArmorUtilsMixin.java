package net.gobies.apothecary.mixin.firstaid;

import ichttt.mods.firstaid.common.util.ArmorUtils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ArmorUtils.class)
public class ArmorUtilsMixin {
    /**
     * @author gobies
     * @reason disables first aid resistance modification since apothecary changes resistance to an attribute
     */
    @Overwrite(remap = false)
    public static float applyGlobalPotionModifiers(Player player, DamageSource source, float damage) {
        return damage;
    }
}
