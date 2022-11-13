package net.slimesurvival.common.registry;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.item.Items;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.slimesurvival.mixin.LootTableBuilderAccessor;

public class ModLootHandler {
	public static String register() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

			if (source.isBuiltin()) {
				if (id.equals(LootTables.FISHING_FISH_GAMEPLAY)) {
					modifyFishingFishGameplay(resourceManager, lootManager, id, tableBuilder, source);
				}
			}
		});

		return "Registered Loot Handler.";
	}



	private static void modifyFishingFishGameplay(ResourceManager resourceManager, LootManager lootManager, Identifier id, LootTable.Builder tableBuilder, LootTableSource source) {
		LootPool lootPool = ((LootTableBuilderAccessor) tableBuilder).getPools().get(0);
		LootPool.Builder lpb = FabricLootPoolBuilder.copyOf(lootPool);

		lpb.with(ItemEntry.builder(ModItemsNew.AXOLOTL_GILLS)
			.weight(5)
			.quality(1)
			.build()
		);
		lpb.with(ItemEntry.builder(Items.SCUTE)
			.weight(5)
			.quality(1)
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
			.build()
		);
		lpb.with(ItemEntry.builder(Items.SLIME_BLOCK)
			.weight(5)
			.quality(1)
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 8.0f)))
			.build()
		);



		((LootTableBuilderAccessor) tableBuilder).getPools().set(0, lpb.build());
	}
}
