package net.slimesurvival.common.recipe;

import com.google.gson.JsonObject;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

public class MixingRecipeSerializer extends ShapelessRecipe.Serializer {
	
	public static final MixingRecipeSerializer INSTANCE = new MixingRecipeSerializer();

	@Override
	public ShapelessRecipe read(Identifier identifier, JsonObject jsonObject) {
		return new MixingRecipe(super.read(identifier, jsonObject));
	}

	@Override
	public ShapelessRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
		return new MixingRecipe(super.read(identifier, packetByteBuf));
	}
}
