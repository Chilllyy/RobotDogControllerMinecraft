package me.chillywilly;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.player.PlayerEntity;

public class RobotDogControllerClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
			if (entity instanceof PlayerEntity) {
				RobotDogController.LOGGER.info("Player Death!");
			}
		});
	}
}