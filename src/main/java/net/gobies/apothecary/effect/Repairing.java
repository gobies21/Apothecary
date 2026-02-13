package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repairing extends MobEffect {
    private static final Random RANDOM = new Random();

    public Repairing(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof Player player && !livingEntity.level().isClientSide) {
            List<ItemStack> damageableItems = new ArrayList<>();
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (!stack.isEmpty() && stack.isDamageableItem() && stack.getDamageValue() > 0) {
                    if (stack.getItem() instanceof ArmorItem || stack.getItem() instanceof TieredItem || stack.getItem() instanceof TridentItem || stack.getItem() instanceof BowItem || stack.getItem() instanceof ShieldItem) {
                        damageableItems.add(stack);
                    }
                }
            }

            if (!damageableItems.isEmpty()) {
                ItemStack randomItem = damageableItems.get(RANDOM.nextInt(damageableItems.size()));
                int repairAmount = CommonConfig.REPAIRING_AMOUNT.get() + amplifier;
                randomItem.setDamageValue(Math.max(0, randomItem.getDamageValue() - repairAmount));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
