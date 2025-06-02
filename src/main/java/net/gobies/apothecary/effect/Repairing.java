package net.gobies.apothecary.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Repairing extends MobEffect {
    private static final Random RANDOM = new Random();

    public Repairing(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof Player player && !entity.level().isClientSide) {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (!stack.isEmpty() && stack.isDamageableItem() && stack.getDamageValue() > 0) {
                    if (RANDOM.nextInt(20) == 0) {
                        int repairAmount = 1 + amplifier;
                        stack.setDamageValue(stack.getDamageValue() - repairAmount);
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
