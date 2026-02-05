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
    public static final RegistryObject<MobEffect> BrokenArmor;
    public static final RegistryObject<MobEffect> DiamondSkin;
    public static final RegistryObject<MobEffect> RupturedArmor;
    public static final RegistryObject<MobEffect> Archery;
    public static final RegistryObject<MobEffect> Misfire;
    public static final RegistryObject<MobEffect> Wrath;
    public static final RegistryObject<MobEffect> Feeble;
    public static final RegistryObject<MobEffect> Vulnerable;
    public static final RegistryObject<MobEffect> Flight;
    public static final RegistryObject<MobEffect> Reach;
    public static final RegistryObject<MobEffect> Repairing;
    public static final RegistryObject<MobEffect> Corrosion;
    public static final RegistryObject<MobEffect> MagicPower;
    public static final RegistryObject<MobEffect> MagicDrain;
    public static final RegistryObject<MobEffect> ManaRegeneration;
    public static final RegistryObject<MobEffect> ManaExhaustion;
    public static final RegistryObject<MobEffect> Thorns;
    public static final RegistryObject<MobEffect> Confusion;
    public static final RegistryObject<MobEffect> Purification;
    public static final RegistryObject<MobEffect> Corruption;
    public static final RegistryObject<MobEffect> Burning;
    public static final RegistryObject<MobEffect> Shocked;
    public static final RegistryObject<MobEffect> Shuffling;
    public static final RegistryObject<MobEffect> Lightning;
    public static final RegistryObject<MobEffect> Spelunker;
    public static final RegistryObject<MobEffect> Extension;
    public static final RegistryObject<MobEffect> Reversion;

    public static void register (IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

    static {
        EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "apothecary");
        IronSkin = EFFECTS.register("iron_skin", () -> new IronSkin(MobEffectCategory.BENEFICIAL, 0xDDDFE1));
        BrokenArmor = EFFECTS.register("broken_armor", () -> new BrokenArmor(MobEffectCategory.HARMFUL, 0x848587));
        DiamondSkin = EFFECTS.register("diamond_skin", () -> new DiamondSkin(MobEffectCategory.BENEFICIAL, 0x7DF9FF));
        RupturedArmor = EFFECTS.register("ruptured_armor", () -> new RupturedArmor(MobEffectCategory.HARMFUL, 0x3E7C7F));
        Archery = EFFECTS.register("archery", () -> new Archery(MobEffectCategory.BENEFICIAL, 0xFFC067));
        Misfire = EFFECTS.register("misfire", () -> new Misfire(MobEffectCategory.HARMFUL, 0x00008B));
        Wrath = EFFECTS.register("wrath", () -> new Wrath(MobEffectCategory.BENEFICIAL, 0x8B0000));
        Feeble = EFFECTS.register("feeble", () -> new Feeble(MobEffectCategory.HARMFUL, 0x4D3A8F));
        Vulnerable = EFFECTS.register("vulnerable", () -> new Vulnerable(MobEffectCategory.HARMFUL, 0x333333));
        Flight = EFFECTS.register("flight", () -> new Flight(MobEffectCategory.BENEFICIAL, 0x63C5DA));
        Reach = EFFECTS.register("reach", () -> new Reach(MobEffectCategory.BENEFICIAL, 0xCA5CDD));
        Repairing = EFFECTS.register("repairing", () -> new Repairing(MobEffectCategory.BENEFICIAL, 0x008000));
        Corrosion = EFFECTS.register("corrosion", () -> new Corrosion(MobEffectCategory.HARMFUL, 0x52712D));
        MagicPower = EFFECTS.register("magic_power", () -> new MagicPower(MobEffectCategory.BENEFICIAL, 0x7600BC));
        MagicDrain = EFFECTS.register("magic_drain", () -> new MagicDrain(MobEffectCategory.HARMFUL, 0x520083));
        ManaRegeneration = EFFECTS.register("mana_regeneration", () -> new ManaRegeneration(MobEffectCategory.BENEFICIAL, 0xFF00FF));
        ManaExhaustion = EFFECTS.register("mana_exhaustion", () -> new ManaExhaustion(MobEffectCategory.HARMFUL, 0x990099));
        Thorns = EFFECTS.register("thorns", () -> new Thorns(MobEffectCategory.BENEFICIAL, 0x65FE08));
        Confusion = EFFECTS.register("confusion", () -> new Confusion(MobEffectCategory.HARMFUL, 0xFFFF00));
        Purification = EFFECTS.register("purification", () -> new Purification(MobEffectCategory.BENEFICIAL, 0xFFB6C1));
        Corruption = EFFECTS.register("corruption", () -> new Corruption(MobEffectCategory.HARMFUL, 0x2B0F3D));
        Burning = EFFECTS.register("burning", () -> new Burning(MobEffectCategory.HARMFUL, 0xC25811));
        Shocked = EFFECTS.register("shocked", () -> new Shocked(MobEffectCategory.HARMFUL, 0x8F00FF));
        Shuffling = EFFECTS.register("shuffling", () -> new Shuffling(MobEffectCategory.HARMFUL, 0x00008B));
        Lightning = EFFECTS.register("lightning", () -> new Lightning(MobEffectCategory.HARMFUL, 0x93B9DF));
        Spelunker = EFFECTS.register("spelunker", () -> new Spelunker(MobEffectCategory.BENEFICIAL, 0xC9C92C));
        Extension = EFFECTS.register("extension", () -> new Extension(MobEffectCategory.BENEFICIAL, 0x66356E));
        Reversion = EFFECTS.register("reversion", () -> new Reversion(MobEffectCategory.HARMFUL, 0x4048A0));
    }
}