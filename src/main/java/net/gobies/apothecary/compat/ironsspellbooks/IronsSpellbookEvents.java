package net.gobies.apothecary.compat.ironsspellbooks;

import io.redspace.ironsspellbooks.entity.mobs.dead_king_boss.DeadKingBoss;
import io.redspace.ironsspellbooks.entity.mobs.necromancer.NecromancerEntity;
import net.gobies.apothecary.Apothecary;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Apothecary.MOD_ID)
public class IronsSpellbookEvents {

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new IronsSpellbookEvents());
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();
        Entity mob = event.getSource().getEntity();
        if (entity != null) {
            int randomLongDuration = entity.getRandom().nextInt(1200 - 200 + 1) + 200;
            int randomShortDuration = entity.getRandom().nextInt(600 - 100 + 1) + 100;
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
