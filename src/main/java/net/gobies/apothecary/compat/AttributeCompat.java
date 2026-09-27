package net.gobies.apothecary.compat;


import net.gobies.apothecary.init.AAttributes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class AttributeCompat {

    private static final ResourceLocation ENRICHMENT_PROJECTILE_DAMAGE_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.enrichment.projectile_damage");
    private static final ResourceLocation ENRICHMENT_MAGIC_DAMAGE_KEY = ResourceLocation.fromNamespaceAndPath("apothecary", "effect.enrichment.magic_damage");

    public static void attachAttributes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            if (ModList.get().isLoaded("bountifulfares")) {
                var enrichmentEffect = BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.fromNamespaceAndPath("bountifulfares", "enrichment"));
                if (enrichmentEffect != null) {
                    enrichmentEffect.addAttributeModifier(AAttributes.PROJECTILE_DAMAGE, ENRICHMENT_PROJECTILE_DAMAGE_KEY, 0.08, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                    enrichmentEffect.addAttributeModifier(AAttributes.MAGIC_DAMAGE, ENRICHMENT_MAGIC_DAMAGE_KEY, 0.08, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
                }
            }
        });
    }
}