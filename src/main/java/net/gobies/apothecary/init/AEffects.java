package net.gobies.apothecary.init;

import net.gobies.apothecary.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AEffects {

    public static final DeferredRegister<MobEffect> EFFECTS;
    public static final RegistryObject<MobEffect> IronSkin;
    public static final RegistryObject<MobEffect> DiamondSkin;
    public static final RegistryObject<MobEffect> MagicShield;
    public static final RegistryObject<MobEffect> Archery;
    public static final RegistryObject<MobEffect> Wrath;
    public static final RegistryObject<MobEffect> Flight;
    public static final RegistryObject<MobEffect> Reach;
    public static final RegistryObject<MobEffect> Repairing;
    public static final RegistryObject<MobEffect> MagicPower;
    public static final RegistryObject<MobEffect> ManaRegeneration;
    public static final RegistryObject<MobEffect> Thorns;
    public static final RegistryObject<MobEffect> Purification;
    public static final RegistryObject<MobEffect> Spelunker;
    public static final RegistryObject<MobEffect> Extension;
    public static final RegistryObject<MobEffect> BrokenArmor;
    public static final RegistryObject<MobEffect> RupturedArmor;
    public static final RegistryObject<MobEffect> Misfire;
    public static final RegistryObject<MobEffect> Frail;
    public static final RegistryObject<MobEffect> Vulnerable;
    public static final RegistryObject<MobEffect> Corrosion;
    public static final RegistryObject<MobEffect> MagicDrain;
    public static final RegistryObject<MobEffect> ManaExhaustion;
    public static final RegistryObject<MobEffect> Confusion;
    public static final RegistryObject<MobEffect> Corruption;
    public static final RegistryObject<MobEffect> Burning;
    public static final RegistryObject<MobEffect> Shocked;
    public static final RegistryObject<MobEffect> Shuffling;
    public static final RegistryObject<MobEffect> Lightning;
    public static final RegistryObject<MobEffect> Reversion;

    public static final RegistryObject<MobEffect> PotionSickness;

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    static {
        EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "apothecary");
        // Positive
        IronSkin = EFFECTS.register("iron_skin", () -> new IronSkin(MobEffectCategory.BENEFICIAL, 0xD9D9D9));
        DiamondSkin = EFFECTS.register("diamond_skin", () -> new DiamondSkin(MobEffectCategory.BENEFICIAL, 0x4AEDD9));
        MagicShield = EFFECTS.register("magic_shield", () -> new MagicShield(MobEffectCategory.BENEFICIAL, 0xEA79E4));
        Archery = EFFECTS.register("archery", () -> new Archery(MobEffectCategory.BENEFICIAL, 0xFFC067));
        Wrath = EFFECTS.register("wrath", () -> new Wrath(MobEffectCategory.BENEFICIAL, 0x8B0000));
        Flight = EFFECTS.register("flight", () -> new Flight(MobEffectCategory.BENEFICIAL, 0x63C5DA));
        Reach = EFFECTS.register("reach", () -> new Reach(MobEffectCategory.BENEFICIAL, 0xCA5CDD));
        Repairing = EFFECTS.register("repairing", () -> new Repairing(MobEffectCategory.BENEFICIAL, 0x008000));
        MagicPower = EFFECTS.register("magic_power", () -> new MagicPower(MobEffectCategory.BENEFICIAL, 0x7600BC));
        ManaRegeneration = EFFECTS.register("mana_regeneration", () -> new ManaRegeneration(MobEffectCategory.BENEFICIAL, 0xFF00FF));
        Thorns = EFFECTS.register("thorns", () -> new Thorns(MobEffectCategory.BENEFICIAL, 0x65FE08));
        Purification = EFFECTS.register("purification", () -> new Purification(MobEffectCategory.BENEFICIAL, 0xEEBEF5));
        Spelunker = EFFECTS.register("spelunker", () -> new Spelunker(MobEffectCategory.BENEFICIAL, 0xAF8A38));
        Extension = EFFECTS.register("extension", () -> new Extension(MobEffectCategory.BENEFICIAL, 0xFFFFFF));

        // Negative
        BrokenArmor = EFFECTS.register("broken_armor", () -> new BrokenArmor(MobEffectCategory.HARMFUL, 0x727272));
        RupturedArmor = EFFECTS.register("ruptured_armor", () -> new RupturedArmor(MobEffectCategory.HARMFUL, 0x2A8478));
        Misfire = EFFECTS.register("misfire", () -> new Misfire(MobEffectCategory.HARMFUL, 0x99733E));
        Frail = EFFECTS.register("frail", () -> new Frail(MobEffectCategory.HARMFUL, 0x873737));
        Vulnerable = EFFECTS.register("vulnerable", () -> new Vulnerable(MobEffectCategory.HARMFUL, 0x9B232E));
        Corrosion = EFFECTS.register("corrosion", () -> new Corrosion(MobEffectCategory.HARMFUL, 0x52712D));
        MagicDrain = EFFECTS.register("magic_drain", () -> new MagicDrain(MobEffectCategory.HARMFUL, 0x4A186B));
        ManaExhaustion = EFFECTS.register("mana_exhaustion", () -> new ManaExhaustion(MobEffectCategory.HARMFUL, 0x990099));
        Confusion = EFFECTS.register("confusion", () -> new Confusion(MobEffectCategory.HARMFUL, 0xFFFF00));
        Corruption = EFFECTS.register("corruption", () -> new Corruption(MobEffectCategory.HARMFUL, 0x3D015C));
        Burning = EFFECTS.register("burning", () -> new Burning(MobEffectCategory.HARMFUL, 0xFF7F00));
        Shocked = EFFECTS.register("shocked", () -> new Shocked(MobEffectCategory.HARMFUL, 0x644CB2));
        Shuffling = EFFECTS.register("shuffling", () -> new Shuffling(MobEffectCategory.HARMFUL, 0x00008B));
        Lightning = EFFECTS.register("lightning", () -> new Lightning(MobEffectCategory.HARMFUL, 0x93B9DF));
        Reversion = EFFECTS.register("reversion", () -> new Reversion(MobEffectCategory.HARMFUL, 0x4048A0));

        PotionSickness = EFFECTS.register("potion_sickness", () -> new PotionSickness(MobEffectCategory.HARMFUL, 0xB374C9));
    }
}