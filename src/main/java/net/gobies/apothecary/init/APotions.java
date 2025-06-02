package net.gobies.apothecary.init;

import net.gobies.apothecary.Apothecary;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class APotions {
    public static final DeferredRegister<Potion> POTIONS;

    //Apothecary potions
    public static final RegistryObject<Potion> IronSkin;
    public static final RegistryObject<Potion> LongIronSkin;
    public static final RegistryObject<Potion> StrongIronSkin;
    public static final RegistryObject<Potion> BrokenArmor;
    public static final RegistryObject<Potion> LongBrokenArmor;
    public static final RegistryObject<Potion> StrongBrokenArmor;
    public static final RegistryObject<Potion> DiamondSkin;
    public static final RegistryObject<Potion> LongDiamondSkin;
    public static final RegistryObject<Potion> StrongDiamondSkin;
    public static final RegistryObject<Potion> RupturedArmor;
    public static final RegistryObject<Potion> LongRupturedArmor;
    public static final RegistryObject<Potion> StrongRupturedArmor;
    public static final RegistryObject<Potion> Archery;
    public static final RegistryObject<Potion> LongArchery;
    public static final RegistryObject<Potion> StrongArchery;
    public static final RegistryObject<Potion> Misfire;
    public static final RegistryObject<Potion> LongMisfire;
    public static final RegistryObject<Potion> StrongMisfire;
    public static final RegistryObject<Potion> Wrath;
    public static final RegistryObject<Potion> LongWrath;
    public static final RegistryObject<Potion> StrongWrath;
    public static final RegistryObject<Potion> Feeble;
    public static final RegistryObject<Potion> LongFeeble;
    public static final RegistryObject<Potion> StrongFeeble;
    public static final RegistryObject<Potion> Indolence;
    public static final RegistryObject<Potion> LongIndolence;
    public static final RegistryObject<Potion> StrongIndolence;
    public static final RegistryObject<Potion> Flight;
    public static final RegistryObject<Potion> LongFlight;
    public static final RegistryObject<Potion> Reach;
    public static final RegistryObject<Potion> LongReach;
    public static final RegistryObject<Potion> StrongReach;
    public static final RegistryObject<Potion> MagicPower;
    public static final RegistryObject<Potion> LongMagicPower;
    public static final RegistryObject<Potion> StrongMagicPower;
    public static final RegistryObject<Potion> ManaRegeneration;
    public static final RegistryObject<Potion> LongManaRegeneration;
    public static final RegistryObject<Potion> StrongManaRegeneration;

    //Vanilla potions
    public static final RegistryObject<Potion> HealthBoost;
    public static final RegistryObject<Potion> LongHealthBoost;
    public static final RegistryObject<Potion> StrongHealthBoost;

    public static final RegistryObject<Potion> Resistance;
    public static final RegistryObject<Potion> LongResistance;
    public static final RegistryObject<Potion> StrongResistance;

    public APotions () {
    }

    public static void register (IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

    static {
        POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Apothecary.MOD_ID);

        //Apothecary potions
        IronSkin = POTIONS.register("iron_skin", () -> new Potion(new MobEffectInstance(AEffects.IronSkin.get(),3600,0)));
        LongIronSkin = POTIONS.register("long_iron_skin", () -> new Potion(new MobEffectInstance(AEffects.IronSkin.get(),9600,0)));
        StrongIronSkin = POTIONS.register("strong_iron_skin", () -> new Potion(new MobEffectInstance(AEffects.IronSkin.get(),1800,1)));

        BrokenArmor = POTIONS.register("broken_armor", () -> new Potion(new MobEffectInstance(AEffects.BrokenArmor.get(),3600,0)));
        LongBrokenArmor = POTIONS.register("long_broken_armor", () -> new Potion(new MobEffectInstance(AEffects.BrokenArmor.get(),9600,0)));
        StrongBrokenArmor = POTIONS.register("strong_broken_armor", () -> new Potion(new MobEffectInstance(AEffects.BrokenArmor.get(),1800,1)));

        DiamondSkin = POTIONS.register("diamond_skin", () -> new Potion(new MobEffectInstance(AEffects.DiamondSkin.get(),3600,0)));
        LongDiamondSkin = POTIONS.register("long_diamond_skin", () -> new Potion(new MobEffectInstance(AEffects.DiamondSkin.get(),9600,0)));
        StrongDiamondSkin = POTIONS.register("strong_diamond_skin", () -> new Potion(new MobEffectInstance(AEffects.DiamondSkin.get(),1800,1)));

        RupturedArmor = POTIONS.register("ruptured_armor", () -> new Potion(new MobEffectInstance(AEffects.RupturedArmor.get(),3600,0)));
        LongRupturedArmor = POTIONS.register("long_ruptured_armor", () -> new Potion(new MobEffectInstance(AEffects.RupturedArmor.get(),9600,0)));
        StrongRupturedArmor = POTIONS.register("strong_ruptured_armor", () -> new Potion(new MobEffectInstance(AEffects.RupturedArmor.get(),1800,1)));

        Archery = POTIONS.register("archery", () -> new Potion(new MobEffectInstance(AEffects.Archery.get(),3600,0)));
        LongArchery = POTIONS.register("long_archery", () -> new Potion(new MobEffectInstance(AEffects.Archery.get(),9600,0)));
        StrongArchery = POTIONS.register("strong_archery", () -> new Potion(new MobEffectInstance(AEffects.Archery.get(),1800,1)));

        Misfire = POTIONS.register("misfire", () -> new Potion(new MobEffectInstance(AEffects.Misfire.get(),3600,0)));
        LongMisfire = POTIONS.register("long_misfire", () -> new Potion(new MobEffectInstance(AEffects.Misfire.get(),9600,0)));
        StrongMisfire = POTIONS.register("strong_misfire", () -> new Potion(new MobEffectInstance(AEffects.Misfire.get(),1800,1)));

        Wrath = POTIONS.register("wrath", () -> new Potion(new MobEffectInstance(AEffects.Wrath.get(),3600,0)));
        LongWrath = POTIONS.register("long_wrath", () -> new Potion(new MobEffectInstance(AEffects.Wrath.get(),9600,0)));
        StrongWrath = POTIONS.register("strong_wrath", () -> new Potion(new MobEffectInstance(AEffects.Wrath.get(),1800,1)));

        Feeble = POTIONS.register("feeble", () -> new Potion(new MobEffectInstance(AEffects.Feeble.get(),3600,0)));
        LongFeeble = POTIONS.register("long_feeble", () -> new Potion(new MobEffectInstance(AEffects.Feeble.get(),9600,0)));
        StrongFeeble = POTIONS.register("strong_feeble", () -> new Potion(new MobEffectInstance(AEffects.Feeble.get(),1800,1)));

        Indolence = POTIONS.register("indolence", () -> new Potion(new MobEffectInstance(AEffects.Indolence.get(),3600,0)));
        LongIndolence = POTIONS.register("long_indolence", () -> new Potion(new MobEffectInstance(AEffects.Indolence.get(),9600,0)));
        StrongIndolence = POTIONS.register("strong_indolence", () -> new Potion(new MobEffectInstance(AEffects.Indolence.get(),1800,1)));

        Flight = POTIONS.register("flight", () -> new Potion(new MobEffectInstance(AEffects.Flight.get(),3600,0)));
        LongFlight = POTIONS.register("long_flight", () -> new Potion(new MobEffectInstance(AEffects.Flight.get(),9600,0)));

        Reach = POTIONS.register("reach", () -> new Potion(new MobEffectInstance(AEffects.Reach.get(),3600,0)));
        LongReach = POTIONS.register("long_reach", () -> new Potion(new MobEffectInstance(AEffects.Reach.get(),9600,0)));
        StrongReach = POTIONS.register("strong_reach", () -> new Potion(new MobEffectInstance(AEffects.Reach.get(),1800,1)));

        MagicPower = POTIONS.register("magic_power", () -> new Potion(new MobEffectInstance(AEffects.MagicPower.get(),3600,0)));
        LongMagicPower = POTIONS.register("long_magic_power", () -> new Potion(new MobEffectInstance(AEffects.MagicPower.get(),9600,0)));
        StrongMagicPower = POTIONS.register("strong_magic_power", () -> new Potion(new MobEffectInstance(AEffects.MagicPower.get(),1800,1)));

        ManaRegeneration = POTIONS.register("mana_regeneration", () -> new Potion(new MobEffectInstance(AEffects.ManaRegeneration.get(),3600,0)));
        LongManaRegeneration = POTIONS.register("long_mana_regeneration", () -> new Potion(new MobEffectInstance(AEffects.ManaRegeneration.get(),9600,0)));
        StrongManaRegeneration = POTIONS.register("strong_mana_regeneration", () -> new Potion(new MobEffectInstance(AEffects.ManaRegeneration.get(),1800,1)));

        //Vanilla potions
        HealthBoost = POTIONS.register("health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,3600,0)));
        LongHealthBoost = POTIONS.register("long_health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,9600,0)));
        StrongHealthBoost = POTIONS.register("strong_health_boost", () -> new Potion(new MobEffectInstance(MobEffects.HEALTH_BOOST,1800,1)));

        Resistance = POTIONS.register("resistance", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,3600,0)));
        LongResistance = POTIONS.register("long_resistance", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,9600,0)));
        StrongResistance = POTIONS.register("strong_resistance", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,1800,1)));
    }
}
