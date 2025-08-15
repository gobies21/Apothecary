package net.gobies.apothecary.effect;

import net.gobies.apothecary.compat.OreCompat;
import net.gobies.apothecary.config.CommonConfig;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Vector3f;

import java.util.*;
import java.util.stream.Collectors;

public class Spelunker extends MobEffect {
    public Spelunker(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Level level = livingEntity.level();
        BlockPos entityPos = livingEntity.blockPosition();

        if (level.isClientSide() && livingEntity instanceof Player player) {
            ClientLevel clientWorld = (ClientLevel) level;
            detectAndSpawnOreParticles(player, clientWorld, entityPos, amplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration % 10 == 0;
    }

    private void detectAndSpawnOreParticles(Player player, ClientLevel clientLevel, BlockPos entityPos, int amplifier) {
        int radius = 7 * (amplifier + 1);
        int maxOres = 1;
        Vec3 entityVec = player.position();
        PriorityQueue<BlockPos> orePositions = new PriorityQueue<>(Comparator.comparingDouble(pos -> pos.distSqr(entityPos)));
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = entityPos.offset(x, y, z);
                    BlockState state = clientLevel.getBlockState(pos);

                    if (isOre(state.getBlock()) || isConfigOre(state.getBlock()) || OreCompat.isModdedOre(state.getBlock())) {
                        orePositions.offer(pos);
                    }
                }
            }
        }

        int oreCount = 0;
        while (!orePositions.isEmpty() && oreCount < maxOres) {
            BlockPos pos = orePositions.poll();
            Vec3 oreVec = Vec3.atCenterOf(pos);
            Vec3 direction = oreVec.subtract(entityVec).normalize();

            double distanceToOre = entityVec.distanceTo(oreVec);
            if (distanceToOre <= 2.0) {
                oreCount++;
                continue;
            }

            for (double d = 0.1; d < 2.5; d += 0.1) {
                double particleX = entityVec.x + direction.x * d;
                double particleY = entityVec.y + direction.y * d + 0.5f;
                double particleZ = entityVec.z + direction.z * d;

                particleX = Math.min(Math.max(particleX, entityVec.x - 5), entityVec.x + 5);
                particleY = Math.min(Math.max(particleY, entityVec.y - 5), entityVec.y + 5);
                particleZ = Math.min(Math.max(particleZ, entityVec.z - 5), entityVec.z + 5);
                clientLevel.addParticle(new DustParticleOptions(new Vector3f(1.0F, 1.0F, 0), 1.0F), particleX, particleY, particleZ, 0.0, 0.0, 0.0);
            }
            oreCount++;
        }
    }


    private boolean isOre(Block block) {
        List<Block> ORE_BLOCKS = Arrays.asList(
                Blocks.COAL_ORE,
                Blocks.DEEPSLATE_COAL_ORE,
                Blocks.COPPER_ORE,
                Blocks.DEEPSLATE_COPPER_ORE,
                Blocks.IRON_ORE,
                Blocks.DEEPSLATE_IRON_ORE,
                Blocks.GOLD_ORE,
                Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.DIAMOND_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                Blocks.REDSTONE_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE,
                Blocks.EMERALD_ORE,
                Blocks.DEEPSLATE_EMERALD_ORE,
                Blocks.LAPIS_ORE,
                Blocks.DEEPSLATE_LAPIS_ORE,
                Blocks.NETHER_GOLD_ORE,
                Blocks.NETHER_QUARTZ_ORE,
                Blocks.ANCIENT_DEBRIS
        );
        return ORE_BLOCKS.contains(block);
    }


    private boolean isConfigOre(Block block) {
        Set<ResourceLocation> oreBlockLocations = CommonConfig.SPELUNKER_ORE_LIST.get().stream()
                .map(ResourceLocation::new)
                .collect(Collectors.toSet());

        return oreBlockLocations.contains(ForgeRegistries.BLOCKS.getKey(block));
    }
}

