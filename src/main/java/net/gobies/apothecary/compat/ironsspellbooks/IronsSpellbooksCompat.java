package net.gobies.apothecary.compat.ironsspellbooks;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingBoss;
import io.redspace.ironsspellbooks.entity.mobs.necromancer.NecromancerEntity;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.gobies.apothecary.util.DurationUtils;
import net.gobies.apothecary.util.ModLoadedUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class IronsSpellbooksCompat {

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new IronsSpellbooksCompat());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (!CommonConfig.APOTHECARY_ENABLED.get()) return;
        if (CommonConfig.ENABLE_WORLD_EVENTS.get()) {
            LivingEntity entity = event.getEntity();
            Entity mob = event.getSource().getEntity();
            if (entity != null) {
                int randomShortDuration = DurationUtils.getRandomShortDuration();
                int randomLongDuration = DurationUtils.getRandomLongDuration();
                MobEffectInstance currentEffect = entity.getEffect(AEffects.MagicDrain.get());
                int newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 2) : 0;
                if (mob instanceof NecromancerEntity || (mob instanceof DeadKingBoss)) {
                    if (entity.getRandom().nextFloat() < 0.05) {
                        entity.addEffect(new MobEffectInstance(AEffects.MagicDrain.get(), randomShortDuration, newAmplifier));
                    }
                    currentEffect = entity.getEffect(AEffects.ManaExhaustion.get());
                    newAmplifier = (currentEffect != null) ? Math.min(currentEffect.getAmplifier() + 1, 2) : 0;
                    if (entity.getRandom().nextFloat() < 0.05) {
                        entity.addEffect(new MobEffectInstance(AEffects.ManaExhaustion.get(), randomLongDuration, newAmplifier));
                    }
                }
            }
        }
    }
    public static Attribute spellPowerAttribute() {
        return AttributeRegistry.SPELL_POWER.get();
    }

    public static Attribute manaRegenerationAttribute() {
        return AttributeRegistry.MANA_REGEN.get();
    }

    public static Attribute spellResistanceAttribute() {
        return AttributeRegistry.SPELL_RESIST.get();
    }

    public static MobEffectInstance getOakSkinEffect(Player player) {
        if (ModLoadedUtil.isIronsSpellbooksLoaded()) {
            return player.getEffect(MobEffectRegistry.OAKSKIN.get());
        }
        return null;
    }
}

