package net.gobies.apothecary.compat.iceandfire;

import net.gobies.apothecary.config.CommonConfig;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.common.NeoForge;

public class IceandFireCompat {

    public static void loadCompat() {
        NeoForge.EVENT_BUS.register(new IceandFireCompat());
    }

    /*
    public boolean isLightningDragon(Entity entity) {
        if (!CommonConfig.DISABLE_ICEANDFIRE_COMPAT.get()) {
            if (ModList.get().isLoaded("iceandfire")) {
                return entity instanceof EntityLightningDragon;
            }
            return false;
        }
        return false;
    }

    @SubscribeEvent
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        if (!CommonConfig.APOTHECARY_ENABLED.get()) return;
        Entity entity = event.getEntity();
        if (isLightningDragon(entity) && event.getEffectInstance().getEffect() == AEffects.Shocked.get()) {
            event.setResult(MobEffectEvent.Result.DENY);
        }
    }


     */
}
