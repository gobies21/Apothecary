package net.gobies.apothecary.compat.iceandfire;

import com.github.alexthe666.iceandfire.entity.EntityLightningDragon;
import net.gobies.apothecary.init.AEffects;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;

public class IceandFireCompat {

    public static void loadCompat() {
        MinecraftForge.EVENT_BUS.register(new IceandFireCompat());
    }

    public boolean isLightningDragon(Entity entity) {
        if (ModList.get().isLoaded("iceandfire")) {
            return entity instanceof EntityLightningDragon;
        }
        return false;
    }

    @SubscribeEvent
    public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        Entity entity = event.getEntity();
        if (isLightningDragon(entity) && event.getEffectInstance().getEffect() == AEffects.Shocked.get()) {
            event.setResult(MobEffectEvent.Result.DENY);
        }
    }
}
