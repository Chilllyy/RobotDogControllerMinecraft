package me.chillywilly.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.chillywilly.RobotDogController;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class DeathMixin {
    @Inject(at = @At("HEAD"), method="onDeath")
    private void death(CallbackInfo info, DamageSource damageSource) {
        RobotDogController.LOGGER.info("Death Detected!");
    }
}
