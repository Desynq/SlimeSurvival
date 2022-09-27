package net.slimesurvival.common.item.material;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.slimesurvival.common.interfaces.ExtendableTooltipProvider;
import net.slimesurvival.common.registry.ModItemGroups;

public class CreeperFlesh extends Item implements ExtendableTooltipProvider {

	public CreeperFlesh(Settings settings) {
		super(settings.group(ModItemGroups.MATERIALS).maxCount(32).food(new FoodComponent.Builder()
			.hunger(3)
			.saturationModifier(1/3F)
			.alwaysEdible()
			.build()
		));
	}




	@Override
	public boolean hasDetails() {
		return true;
	}

	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
	}
}