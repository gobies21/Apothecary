package net.gobies.apothecary.mixin;

import net.gobies.apothecary.Config;
import net.gobies.apothecary.util.AUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Witch.class)
public abstract class WitchMixin {
    @Inject(
            method = "performRangedAttack",
            at = @At("HEAD"),
            cancellable = true
    )
    private void replaceDefaultPotions(LivingEntity pTarget, float pDistanceFactor, CallbackInfo ci) {
        if (Config.ENABLE_WORLD_EVENTS.get()) {
            Witch witch = (Witch) (Object) this;
            if (!witch.isDrinkingPotion() && pTarget instanceof Player player) {
                ThrownPotion thrownPotion = new ThrownPotion(witch.level(), witch);
                RandomSource random = witch.getRandom();

                // Determine the potion to throw based on rarity
                Potion selectedPotion = AUtils.determinePotionByRarity(random);
                double d0 = player.getX() + player.getDeltaMovement().x - witch.getX();
                double d1 = player.getEyeY() - (double) 1.1F - witch.getY();
                double d2 = player.getZ() + player.getDeltaMovement().z - witch.getZ();
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                thrownPotion.setItem(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), Objects.requireNonNull(selectedPotion)));
                thrownPotion.setXRot(thrownPotion.getXRot() + 20.0F);
                thrownPotion.shoot(d0, d1 + d3 * 0.2, d2, 0.75F, 8.0F);
                if (!witch.isSilent()) {
                    witch.level().playSound(null, witch.getX(), witch.getY(), witch.getZ(), SoundEvents.WITCH_THROW, witch.getSoundSource(), 1.0F, 0.8F + witch.getRandom().nextFloat() * 0.4F);
                }

                witch.level().addFreshEntity(thrownPotion);
                witch.setTarget(null);
                ci.cancel();
            }
        }
    }
}