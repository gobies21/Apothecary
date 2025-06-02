package net.gobies.apothecary.init;

import net.gobies.apothecary.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AEffects {

    public static final DeferredRegister<MobEffect> REGISTRY;
    public static final RegistryObject<MobEffect> IronSkin;
    public static final RegistryObject<MobEffect> BrokenArmor;
    public static final RegistryObject<MobEffect> DiamondSkin;
    public static final RegistryObject<MobEffect> RupturedArmor;
    public static final RegistryObject<MobEffect> Archery;
    public static final RegistryObject<MobEffect> Misfire;
    public static final RegistryObject<MobEffect> Wrath;
    public static final RegistryObject<MobEffect> Feeble;
    public static final RegistryObject<MobEffect> Indolence;
    public static final RegistryObject<MobEffect> Flight;
    public static final RegistryObject<MobEffect> Reach;

    public AEffects() {
    }

    static {
        REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "apothecary");
        IronSkin = REGISTRY.register("iron_skin", () -> new IronSkin(MobEffectCategory.BENEFICIAL, 0xDDDFE1));
        BrokenArmor = REGISTRY.register("broken_armor", () -> new BrokenArmor(MobEffectCategory.HARMFUL, 0x848587));
        DiamondSkin = REGISTRY.register("diamond_skin", () -> new DiamondSkin(MobEffectCategory.BENEFICIAL, 0x7DF9FF));
        RupturedArmor = REGISTRY.register("ruptured_armor", () -> new RupturedArmor(MobEffectCategory.HARMFUL, 0x3E7C7F));
        Archery = REGISTRY.register("archery", () -> new Archery(MobEffectCategory.BENEFICIAL, 0xFFC067));
        Misfire = REGISTRY.register("misfire", () -> new Misfire(MobEffectCategory.HARMFUL, 0x00008B));
        Wrath = REGISTRY.register("wrath", () -> new Wrath(MobEffectCategory.BENEFICIAL, 0x8B0000));
        Feeble = REGISTRY.register("feeble", () -> new Feeble(MobEffectCategory.HARMFUL, 0x370000));
        Indolence = REGISTRY.register("indolence", () -> new Indolence(MobEffectCategory.HARMFUL, 0x333333));
        Flight = REGISTRY.register("flight", () -> new Flight(MobEffectCategory.NEUTRAL, 0x63C5DA));
        Reach = REGISTRY.register("reach", () -> new Reach(MobEffectCategory.NEUTRAL, 0xCA5CDD));
    }
}