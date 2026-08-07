package net.gobies.apothecary.init;

import net.gobies.apothecary.Apothecary;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES;
    public static final DeferredHolder<Attribute, Attribute> DAMAGE_RESISTANCE;
    public static final DeferredHolder<Attribute, Attribute> DAMAGE_MULTIPLIER;
    public static final DeferredHolder<Attribute, Attribute> MAGIC_SHIELDING;
    public static final DeferredHolder<Attribute, Attribute> MAGIC_DAMAGE;
    public static final DeferredHolder<Attribute, Attribute> PROJECTILE_DAMAGE;
    public static final DeferredHolder<Attribute, Attribute> JUMP_HEIGHT;
    public static final DeferredHolder<Attribute, Attribute> DIG_SPEED;

    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }

    static {
        ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, Apothecary.MOD_ID);

        /*
        * Reduces or increases damage taken based on the value,
        * Every (0.1) value is equivalent to 10%
        * Default = 1.0 (no resistance)
        */
        DAMAGE_RESISTANCE = ATTRIBUTES.register("damage_resistance", () -> new RangedAttribute("attribute.name.apothecary.damage_resistance", 1.0D, -1024.0D, 2.0D).setSyncable(true));

        /*
        * Increases ALL damage dealt based on the value
        * Every (0.1) value is equivalent to 10%
        * Default = 1.0 (no damage multiplier)
        */
        DAMAGE_MULTIPLIER = ATTRIBUTES.register("damage_multiplier", () -> new RangedAttribute("attribute.name.apothecary.damage_multiplier", 1.0D, 0.0D, 1024.0D).setSyncable(true));

        /*
        * Reduces or increases magic damage taken based on the value
        * Every (1) value is equivalent to 5%
        * Default = 0.0 (no magic resistance)
        * If Irons Spellbooks is installed this attribute will also increase resistance against spell damage
        * Has only half of the effectiveness against spell damage
        */
        MAGIC_SHIELDING = ATTRIBUTES.register("magic_shielding", () -> new RangedAttribute("attribute.name.apothecary.magic_shielding", 0.0D, -20.0D, 20.0D).setSyncable(true));

        /*
        * Increases magic damage dealt based on the value
        * Every (0.1) value is equivalent to 10%
        * Default = 1.0 (no damage multiplier)
        * If Irons Spellbooks is installed this attribute will also increase spell damage
        */
        MAGIC_DAMAGE = ATTRIBUTES.register("magic_damage", () -> new RangedAttribute("attribute.name.apothecary.magic_damage", 1.0D, 0.0D, 1024.0D).setSyncable(true));

        /*
        * Increases projectile damage based on the value, the way the attribute was given matters
        * ADDITION = Every (1) value is equivalent to +1 projectile damage (flat damage)
        * MULTIPLY BASE - Every (0.1) value is equivalent to 10% (multiplied  damage)
        * If addition and multiply base modifiers are present the formula is = (projectile damage + flat damage) * multiplied damage
        */
        PROJECTILE_DAMAGE = ATTRIBUTES.register("projectile_damage", () -> new RangedAttribute("attribute.name.apothecary.projectile_damage", 1.0D, -1024.0D, 1024.0D).setSyncable(true));

        /*
        * Increases or decreases jump height based on the value
        * Every (0.5) value is half a block
        * Default = 1.0 (no extra jumping height)
        */
        JUMP_HEIGHT = ATTRIBUTES.register("jump_height", () -> new RangedAttribute("attribute.name.apothecary.jump_height", 1.0D, 0.0D, 1024.0D).setSyncable(true));

        /*
        * Increases or decreases digging speed based on the value
        * Every (0.1) value is equivalent to 10%
        * Default = 1.0 (no extra digging speed)
        */
        DIG_SPEED = ATTRIBUTES.register("dig_speed", () -> new RangedAttribute("attribute.name.apothecary.dig_speed", 1.0D, 0.0D, 1024.0D).setSyncable(true));
    }

    public static double getDamageResistance(LivingEntity livingEntity) {
        return getValue(livingEntity, DAMAGE_RESISTANCE);
    }

    public static double getDamageMultiplier(LivingEntity livingEntity) {
        return getValue(livingEntity, DAMAGE_MULTIPLIER);
    }

    public static double getMagicResistance(LivingEntity livingEntity) {
        return getValue(livingEntity, MAGIC_SHIELDING);
    }

    public static double getMagicDamage(LivingEntity livingEntity) {
        return getValue(livingEntity, MAGIC_DAMAGE);
    }

    public static double getProjectileDamage(LivingEntity livingEntity) {
        return getValue(livingEntity, PROJECTILE_DAMAGE);
    }

    public static double getJumpHeight(LivingEntity livingEntity) {
        return getValue(livingEntity, JUMP_HEIGHT);
    }

    public static double getDigSpeed(LivingEntity livingEntity) {
        return getValue(livingEntity, DIG_SPEED);
    }

    private static double getValue(LivingEntity entity, Holder<Attribute> attribute) {
        return entity.getAttributeValue(attribute);
    }
}