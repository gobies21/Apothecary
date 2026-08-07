package net.gobies.apothecary.init;

import net.gobies.apothecary.Apothecary;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class APotions {
    public static final DeferredRegister<Potion> POTIONS;

    // Apothecary potions
    public static final DeferredHolder<Potion, Potion> IronSkin;
    public static final DeferredHolder<Potion, Potion> LongIronSkin;
    public static final DeferredHolder<Potion, Potion> StrongIronSkin;
    public static final DeferredHolder<Potion, Potion> DiamondSkin;
    public static final DeferredHolder<Potion, Potion> LongDiamondSkin;
    public static final DeferredHolder<Potion, Potion> StrongDiamondSkin;
    public static final DeferredHolder<Potion, Potion> MagicShield;
    public static final DeferredHolder<Potion, Potion> LongMagicShield;
    public static final DeferredHolder<Potion, Potion> StrongMagicShield;
    public static final DeferredHolder<Potion, Potion> Archery;
    public static final DeferredHolder<Potion, Potion> LongArchery;
    public static final DeferredHolder<Potion, Potion> StrongArchery;
    public static final DeferredHolder<Potion, Potion> Wrath;
    public static final DeferredHolder<Potion, Potion> LongWrath;
    public static final DeferredHolder<Potion, Potion> StrongWrath;
    public static final DeferredHolder<Potion, Potion> Flight;
    public static final DeferredHolder<Potion, Potion> Reach;
    public static final DeferredHolder<Potion, Potion> LongReach;
    public static final DeferredHolder<Potion, Potion> StrongReach;
    public static final DeferredHolder<Potion, Potion> Repairing;
    public static final DeferredHolder<Potion, Potion> LongRepairing;
    public static final DeferredHolder<Potion, Potion> StrongRepairing;
    public static final DeferredHolder<Potion, Potion> MagicPower;
    public static final DeferredHolder<Potion, Potion> LongMagicPower;
    public static final DeferredHolder<Potion, Potion> StrongMagicPower;
    public static final DeferredHolder<Potion, Potion> ManaRegeneration;
    public static final DeferredHolder<Potion, Potion> LongManaRegeneration;
    public static final DeferredHolder<Potion, Potion> StrongManaRegeneration;
    public static final DeferredHolder<Potion, Potion> Thorns;
    public static final DeferredHolder<Potion, Potion> LongThorns;
    public static final DeferredHolder<Potion, Potion> StrongThorns;
    public static final DeferredHolder<Potion, Potion> Purification;
    public static final DeferredHolder<Potion, Potion> Spelunker;
    public static final DeferredHolder<Potion, Potion> LongSpelunker;
    public static final DeferredHolder<Potion, Potion> StrongSpelunker;
    public static final DeferredHolder<Potion, Potion> Extension;
    public static final DeferredHolder<Potion, Potion> BrokenArmor;
    public static final DeferredHolder<Potion, Potion> LongBrokenArmor;
    public static final DeferredHolder<Potion, Potion> StrongBrokenArmor;
    public static final DeferredHolder<Potion, Potion> RupturedArmor;
    public static final DeferredHolder<Potion, Potion> LongRupturedArmor;
    public static final DeferredHolder<Potion, Potion> StrongRupturedArmor;
    public static final DeferredHolder<Potion, Potion> Misfire;
    public static final DeferredHolder<Potion, Potion> LongMisfire;
    public static final DeferredHolder<Potion, Potion> Frail;
    public static final DeferredHolder<Potion, Potion> LongFrail;
    public static final DeferredHolder<Potion, Potion> StrongFrail;
    public static final DeferredHolder<Potion, Potion> Vulnerable;
    public static final DeferredHolder<Potion, Potion> LongVulnerable;
    public static final DeferredHolder<Potion, Potion> StrongVulnerable;
    public static final DeferredHolder<Potion, Potion> Corrosion;
    public static final DeferredHolder<Potion, Potion> LongCorrosion;
    public static final DeferredHolder<Potion, Potion> StrongCorrosion;
    public static final DeferredHolder<Potion, Potion> MagicDrain;
    public static final DeferredHolder<Potion, Potion> LongMagicDrain;
    public static final DeferredHolder<Potion, Potion> StrongMagicDrain;
    public static final DeferredHolder<Potion, Potion> ManaExhaustion;
    public static final DeferredHolder<Potion, Potion> LongManaExhaustion;
    public static final DeferredHolder<Potion, Potion> StrongManaExhaustion;
    public static final DeferredHolder<Potion, Potion> Confusion;
    public static final DeferredHolder<Potion, Potion> LongConfusion;
    public static final DeferredHolder<Potion, Potion> Corruption;
    public static final DeferredHolder<Potion, Potion> Burning;
    public static final DeferredHolder<Potion, Potion> LongBurning;
    public static final DeferredHolder<Potion, Potion> StrongBurning;
    public static final DeferredHolder<Potion, Potion> Shocked;
    public static final DeferredHolder<Potion, Potion> LongShocked;
    public static final DeferredHolder<Potion, Potion> StrongShocked;
    public static final DeferredHolder<Potion, Potion> Shuffling;
    public static final DeferredHolder<Potion, Potion> Lightning;
    public static final DeferredHolder<Potion, Potion> StrongLightning;
    public static final DeferredHolder<Potion, Potion> StrongExtension;
    public static final DeferredHolder<Potion, Potion> Reversion;
    public static final DeferredHolder<Potion, Potion> StrongReversion;

    // Vanilla potions
    public static final DeferredHolder<Potion, Potion> HealthBoost;
    public static final DeferredHolder<Potion, Potion> LongHealthBoost;
    public static final DeferredHolder<Potion, Potion> StrongHealthBoost;
    public static final DeferredHolder<Potion, Potion> Resistance;
    public static final DeferredHolder<Potion, Potion> LongResistance;
    public static final DeferredHolder<Potion, Potion> StrongResistance;
    public static final DeferredHolder<Potion, Potion> Wither;
    public static final DeferredHolder<Potion, Potion> LongWither;
    public static final DeferredHolder<Potion, Potion> StrongWither;

    public static void register (IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    static {
        POTIONS = DeferredRegister.create(Registries.POTION, Apothecary.MOD_ID);

        // Positive Effects
        IronSkin = POTIONS.register("iron_skin", () -> new Potion(new MobEffectInstance(AEffects.IronSkin,3600,0)));
        LongIronSkin = POTIONS.register("long_iron_skin", () -> new Potion(new MobEffectInstance(AEffects.IronSkin,9600,0)));
        StrongIronSkin = POTIONS.register("strong_iron_skin", () -> new Potion(new MobEffectInstance(AEffects.IronSkin,1800,1)));

        DiamondSkin = POTIONS.register("diamond_skin", () -> new Potion(new MobEffectInstance(AEffects.DiamondSkin,3600,0)));
        LongDiamondSkin = POTIONS.register("long_diamond_skin", () -> new Potion(new MobEffectInstance(AEffects.DiamondSkin,9600,0)));
        StrongDiamondSkin = POTIONS.register("strong_diamond_skin", () -> new Potion(new MobEffectInstance(AEffects.DiamondSkin,1800,1)));

        MagicShield = POTIONS.register("magic_shield", () -> new Potion(new MobEffectInstance(AEffects.MagicShield,3600,0)));
        LongMagicShield = POTIONS.register("long_magic_shield", () -> new Potion(new MobEffectInstance(AEffects.MagicShield,9600,0)));
        StrongMagicShield = POTIONS.register("strong_magic_shield", () -> new Potion(new MobEffectInstance(AEffects.MagicShield,1800,1)));

        Archery = POTIONS.register("archery", () -> new Potion(new MobEffectInstance(AEffects.Archery,3600,0)));
        LongArchery = POTIONS.register("long_archery", () -> new Potion(new MobEffectInstance(AEffects.Archery,9600,0)));
        StrongArchery = POTIONS.register("strong_archery", () -> new Potion(new MobEffectInstance(AEffects.Archery,1800,1)));

        Wrath = POTIONS.register("wrath", () -> new Potion(new MobEffectInstance(AEffects.Wrath,3600,0)));
        LongWrath = POTIONS.register("long_wrath", () -> new Potion(new MobEffectInstance(AEffects.Wrath,9600,0)));
        StrongWrath = POTIONS.register("strong_wrath", () -> new Potion(new MobEffectInstance(AEffects.Wrath,1800,1)));

        Flight = POTIONS.register("flight", () -> new Potion(new MobEffectInstance(AEffects.Flight,3600,0)));

        Reach = POTIONS.register("reach", () -> new Potion(new MobEffectInstance(AEffects.Reach,3600,0)));
        LongReach = POTIONS.register("long_reach", () -> new Potion(new MobEffectInstance(AEffects.Reach,9600,0)));
        StrongReach = POTIONS.register("strong_reach", () -> new Potion(new MobEffectInstance(AEffects.Reach,1800,1)));

        Repairing = POTIONS.register("repairing", () -> new Potion(new MobEffectInstance(AEffects.Repairing,3600,0)));
        LongRepairing = POTIONS.register("long_repairing", () -> new Potion(new MobEffectInstance(AEffects.Repairing,9600,0)));
        StrongRepairing = POTIONS.register("strong_repairing", () -> new Potion(new MobEffectInstance(AEffects.Repairing,1800,1)));

        MagicPower = POTIONS.register("magic_power", () -> new Potion(new MobEffectInstance(AEffects.MagicPower,3600,0)));
        LongMagicPower = POTIONS.register("long_magic_power", () -> new Potion(new MobEffectInstance(AEffects.MagicPower,9600,0)));
        StrongMagicPower = POTIONS.register("strong_magic_power", () -> new Potion(new MobEffectInstance(AEffects.MagicPower,1800,1)));

        ManaRegeneration = POTIONS.register("mana_regeneration", () -> new Potion(new MobEffectInstance(AEffects.ManaRegeneration,3600,0)));
        LongManaRegeneration = POTIONS.register("long_mana_regeneration", () -> new Potion(new MobEffectInstance(AEffects.ManaRegeneration,9600,0)));
        StrongManaRegeneration = POTIONS.register("strong_mana_regeneration", () -> new Potion(new MobEffectInstance(AEffects.ManaRegeneration,1800,1)));

        Thorns = POTIONS.register("thorns", () -> new Potion(new MobEffectInstance(AEffects.Thorns,3600,0)));
        LongThorns = POTIONS.register("long_thorns", () -> new Potion(new MobEffectInstance(AEffects.Thorns,9600,0)));
        StrongThorns = POTIONS.register("strong_thorns", () -> new Potion(new MobEffectInstance(AEffects.Thorns,1800,1)));

        Purification = POTIONS.register("purification", () -> new Potion(new MobEffectInstance(AEffects.Purification,1,0)));

        Spelunker = POTIONS.register("spelunker", () -> new Potion(new MobEffectInstance(AEffects.Spelunker,3600,0)));
        LongSpelunker = POTIONS.register("long_spelunker", () -> new Potion(new MobEffectInstance(AEffects.Spelunker,9600,0)));
        StrongSpelunker = POTIONS.register("strong_spelunker", () -> new Potion(new MobEffectInstance(AEffects.Spelunker,1800,1)));

        Extension = POTIONS.register("extension", () -> new Potion(new MobEffectInstance(AEffects.Extension,1,0)));
        StrongExtension = POTIONS.register("strong_extension", () -> new Potion(new MobEffectInstance(AEffects.Extension,1,1)));

        // Negative Effects
        BrokenArmor = POTIONS.register("broken_armor", () -> new Potion(new MobEffectInstance(AEffects.BrokenArmor,900,0)));
        LongBrokenArmor = POTIONS.register("long_broken_armor", () -> new Potion(new MobEffectInstance(AEffects.BrokenArmor,1800,0)));
        StrongBrokenArmor = POTIONS.register("strong_broken_armor", () -> new Potion(new MobEffectInstance(AEffects.BrokenArmor,450,1)));

        RupturedArmor = POTIONS.register("ruptured_armor", () -> new Potion(new MobEffectInstance(AEffects.RupturedArmor,900,0)));
        LongRupturedArmor = POTIONS.register("long_ruptured_armor", () -> new Potion(new MobEffectInstance(AEffects.RupturedArmor,1800,0)));
        StrongRupturedArmor = POTIONS.register("strong_ruptured_armor", () -> new Potion(new MobEffectInstance(AEffects.RupturedArmor,450,1)));

        Misfire = POTIONS.register("misfire", () -> new Potion(new MobEffectInstance(AEffects.Misfire,1800,0)));
        LongMisfire = POTIONS.register("long_misfire", () -> new Potion(new MobEffectInstance(AEffects.Misfire,4800,0)));

        Frail = POTIONS.register("frail", () -> new Potion(new MobEffectInstance(AEffects.Frail,900,0)));
        LongFrail = POTIONS.register("long_frail", () -> new Potion(new MobEffectInstance(AEffects.Frail,1800,0)));
        StrongFrail = POTIONS.register("strong_frail", () -> new Potion(new MobEffectInstance(AEffects.Frail,450,1)));

        Vulnerable = POTIONS.register("vulnerable", () -> new Potion(new MobEffectInstance(AEffects.Vulnerable,900,0)));
        LongVulnerable = POTIONS.register("long_vulnerable", () -> new Potion(new MobEffectInstance(AEffects.Vulnerable,1800,0)));
        StrongVulnerable = POTIONS.register("strong_vulnerable", () -> new Potion(new MobEffectInstance(AEffects.Vulnerable,450,1)));

        Corrosion = POTIONS.register("corrosion", () -> new Potion(new MobEffectInstance(AEffects.Corrosion,900,0)));
        LongCorrosion = POTIONS.register("long_corrosion", () -> new Potion(new MobEffectInstance(AEffects.Corrosion,1800,0)));
        StrongCorrosion = POTIONS.register("strong_corrosion", () -> new Potion(new MobEffectInstance(AEffects.Corrosion,450,1)));

        MagicDrain = POTIONS.register("magic_drain", () -> new Potion(new MobEffectInstance(AEffects.MagicDrain,900,0)));
        LongMagicDrain = POTIONS.register("long_magic_drain", () -> new Potion(new MobEffectInstance(AEffects.MagicDrain,1800,0)));
        StrongMagicDrain = POTIONS.register("strong_magic_drain", () -> new Potion(new MobEffectInstance(AEffects.MagicDrain,450,1)));

        ManaExhaustion = POTIONS.register("mana_exhaustion", () -> new Potion(new MobEffectInstance(AEffects.ManaExhaustion,900,0)));
        LongManaExhaustion = POTIONS.register("long_mana_exhaustion", () -> new Potion(new MobEffectInstance(AEffects.ManaExhaustion,1800,0)));
        StrongManaExhaustion = POTIONS.register("strong_mana_exhaustion", () -> new Potion(new MobEffectInstance(AEffects.ManaExhaustion,450,1)));

        Confusion = POTIONS.register("confusion", ( ) -> new Potion(new MobEffectInstance(AEffects.Confusion,900,0)));
        LongConfusion = POTIONS.register("long_confusion", () -> new Potion(new MobEffectInstance(AEffects.Confusion,1800,0)));

        Corruption = POTIONS.register("corruption", () -> new Potion(new MobEffectInstance(AEffects.Corruption,1,0)));

        Burning = POTIONS.register("burning", () -> new Potion(new MobEffectInstance(AEffects.Burning,900,0)));
        LongBurning = POTIONS.register("long_burning", () -> new Potion(new MobEffectInstance(AEffects.Burning,1800,0)));
        StrongBurning = POTIONS.register("strong_burning", () -> new Potion(new MobEffectInstance(AEffects.Burning,450,1)));

        Shocked = POTIONS.register("shocked", () -> new Potion(new MobEffectInstance(AEffects.Shocked,900,0)));
        LongShocked = POTIONS.register("long_shocked", () -> new Potion(new MobEffectInstance(AEffects.Shocked,1800,0)));
        StrongShocked = POTIONS.register("strong_shocked", () -> new Potion(new MobEffectInstance(AEffects.Shocked,450,1)));

        Shuffling = POTIONS.register("shuffling", () -> new Potion(new MobEffectInstance(AEffects.Shuffling,1,0)));

        Lightning = POTIONS.register("lightning", () -> new Potion(new MobEffectInstance(AEffects.Lightning,1,0)));
        StrongLightning = POTIONS.register("strong_lightning", () -> new Potion(new MobEffectInstance(AEffects.Lightning,1,1)));

        Reversion = POTIONS.register("reversion", () -> new Potion(new MobEffectInstance(AEffects.Reversion,1,0)));
        StrongReversion = POTIONS.register("strong_reversion", () -> new Potion(new MobEffectInstance(AEffects.Reversion,1,1)));

        // Vanilla potions
        HealthBoost = POTIONS.register("health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,3600,0)));
        LongHealthBoost = POTIONS.register("long_health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,9600,0)));
        StrongHealthBoost = POTIONS.register("strong_health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,1800,1)));

        Resistance = POTIONS.register("resistance", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,3600,0)));
        LongResistance = POTIONS.register("long_resistance", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,9600,0)));
        StrongResistance = POTIONS.register("strong_resistance", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,1800,1)));

        Wither = POTIONS.register("wither", () -> new Potion(new MobEffectInstance(MobEffects.WITHER,900,0)));
        LongWither = POTIONS.register("long_wither", () -> new Potion(new MobEffectInstance(MobEffects.WITHER,1800,0)));
        StrongWither = POTIONS.register("strong_wither", () -> new Potion(new MobEffectInstance(MobEffects.WITHER,450,1)));}
}
