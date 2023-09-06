package slimesurvival.common.registry;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

// net.minecraft.item.Items
public class ModItems implements ItemRegistryContainer {
	public static final Item BOLT_ACTION_RIFLE = new Item(new FabricItemSettings().maxDamage(400));

	public static final Item HEAVY_RIFLE_AMMO = new Item(new FabricItemSettings().maxCount(32));
}
