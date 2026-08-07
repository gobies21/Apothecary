package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Corrosion extends MobEffect {
    private static final Random RANDOM = new Random();

    public Corrosion(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity instanceof Player player && !livingEntity.level().isClientSide) {
            List<ItemStack> damageableItems = new ArrayList<>();
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (!stack.isEmpty() && stack.isDamageableItem()) {
                    if (stack.getItem() instanceof ArmorItem || stack.getItem() instanceof TieredItem || stack.getItem() instanceof TridentItem || stack.getItem() instanceof BowItem || stack.getItem() instanceof ShieldItem) {
                        damageableItems.add(stack);
                    }
                }
            }

            if (!damageableItems.isEmpty()) {
                ItemStack randomItem = damageableItems.get(RANDOM.nextInt(damageableItems.size()));
                int damageAmount = CommonConfig.CORROSION_AMOUNT.get() + amplifier;
                EquipmentSlot slot = player.getEquipmentSlotForItem(randomItem);
                randomItem.hurtAndBreak(damageAmount, player, slot);
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
