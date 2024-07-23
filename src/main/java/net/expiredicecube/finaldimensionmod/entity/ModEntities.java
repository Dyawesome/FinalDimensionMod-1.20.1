package net.expiredicecube.finaldimensionmod.entity;

import net.expiredicecube.finaldimensionmod.FinalDimensionMod;
import net.expiredicecube.finaldimensionmod.entity.custom.SealedConduitProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FinalDimensionMod.MOD_ID);

    public static final RegistryObject<EntityType<SealedConduitProjectileEntity>> SEALED_CONDUIT =
            ENTITY_TYPES.register("sealed_conduit", ()->EntityType.Builder.<SealedConduitProjectileEntity>of(SealedConduitProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("sealed_conduit"));


    public static void register(IEventBus eventBus){ENTITY_TYPES.register(eventBus);}
}
