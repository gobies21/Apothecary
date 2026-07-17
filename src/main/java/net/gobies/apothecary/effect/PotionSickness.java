package net.gobies.apothecary.effect;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.DurationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PotionSickness extends MobEffect {
    private static final Random random = new Random();

    public PotionSickness(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (!(entity instanceof Player player) || player.level().isClientSide()) {
            return;
        }

        if (random.nextFloat() < CommonConfig.POTION_SICKNESS_CHANCE.get() + (amplifier * 0.01)) {
            float roll = random.nextFloat();

            if (roll < 0.60) { // 60% Chance
                int effectCount = (random.nextFloat() < 0.75f) ? 1 : 2;
                applyRandomNegativeEffects(player, effectCount);
            } else if (roll < 0.85) { // 25% Chance
                halfEffectDurations(player);
            } else { // 15% Chance
                clearAllEffects(player);
            }
        }
    }

    public static void applyRandomNegativeEffects(Player player, int count) {
        List<MobEffect> harmfulEffects = new ArrayList<>();
        List<? extends String> whiteList = CommonConfig.POTION_SICKNESS_WHITELIST.get();
        List<? extends String> blackList = CommonConfig.POTION_SICKNESS_BLACKLIST.get();

        if (!whiteList.isEmpty()) {
            for (String id : whiteList) {
                MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(id));
                if (effect != null && effect != AEffects.PotionSickness.get()) {
                    harmfulEffects.add(effect);
                }
            }
        } else {
            for (MobEffect effect : ForgeRegistries.MOB_EFFECTS.getValues()) {
                if (effect.getCategory() == MobEffectCategory.HARMFUL && effect != AEffects.PotionSickness.get()) {
                    if (effect == MobEffects.HARM || effect == AEffects.Lightning.get()) continue;
                    String id = Objects.requireNonNull(ForgeRegistries.MOB_EFFECTS.getKey(effect)).toString();
                    if (!blackList.contains(id)) {
                        harmfulEffects.add(effect);
                    }
                }
            }
        }
        if (harmfulEffects.isEmpty()) return;

        Collections.shuffle(harmfulEffects);
        int limit = Math.min(count, harmfulEffects.size());
        for (int i = 0; i < limit; i++) {
            int randomDuration = DurationUtils.getRandomVaryingDuration();
            int randomAmplifier = player.getRandom().nextFloat() >= 0.75f ? 1 : 0;
            player.addEffect(new MobEffectInstance(harmfulEffects.get(i), randomDuration, randomAmplifier));
        }
    }

    private void halfEffectDurations(Player player) {
        for (MobEffectInstance instance : new ArrayList<>(player.getActiveEffects())) {
            if (instance.getEffect().getCategory() == MobEffectCategory.BENEFICIAL) {
                int currentDuration = instance.getDuration();
                if (currentDuration > 50000) continue;

                int newDuration = (int) (currentDuration * 0.50f);

                if (newDuration > 20) {
                    player.addEffect(new MobEffectInstance(instance.getEffect(), newDuration, instance.getAmplifier(), instance.isAmbient(), instance.isVisible(), instance.showIcon()));
                } else {
                    player.removeEffect(instance.getEffect());
                }
            }
        }
    }

    private void clearAllEffects(Player player) {
        for (MobEffectInstance instance : new ArrayList<>(player.getActiveEffects())) {
            player.removeEffect(instance.getEffect());
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public @NotNull List<ItemStack> getCurativeItems() {
        return Collections.emptyList();
    }
}
