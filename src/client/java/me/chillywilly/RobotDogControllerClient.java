package me.chillywilly;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.player.PlayerEntity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RobotDogControllerClient implements ClientModInitializer {
	private final OkHttpClient client = new OkHttpClient();
	@Override
	public void onInitializeClient() {
		ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
			if (entity instanceof PlayerEntity) {
				RobotDogController.LOGGER.info("Player Death!");

				try {
					sendJump();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private void sendJump() throws Exception {
		Request request = new Request.Builder()
		.url("http://10.0.0.193:5000/jump")
		.build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call arg0, IOException arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				// TODO Auto-generated method stub
				
			}
		});
	}
}