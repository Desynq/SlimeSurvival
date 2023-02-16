package net.slimesurvival.common.item.tool;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.slimesurvival.util.provider.ExtendableTooltipProvider;

public class ExperienceCrystalItem extends Item implements ExtendableTooltipProvider {

	public ExperienceCrystalItem(Settings settings) {
		super(settings);
	}



	public static int getStoredExperience(ItemStack stack) {
		return stack.getOrCreateNbt().getInt("StoredExperience");
	}



	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);
		Integer storedExperience = getStoredExperience(stack);
		Integer experienceMultiplier = hand == Hand.OFF_HAND ? 100 : 10;




		if (!user.isSneaking() && user.totalExperience >= experienceMultiplier && storedExperience <= 3000 - experienceMultiplier) {
			storedExperience += experienceMultiplier;
			stack.getOrCreateNbt().putInt("StoredExperience", storedExperience);
			user.addExperience(-experienceMultiplier);

			user.sendMessage(Text.of(storedExperience.toString()), true);

			return TypedActionResult.success(stack);
		}
		if (user.isSneaking() && storedExperience >= experienceMultiplier) {
			storedExperience -= experienceMultiplier;
			stack.getOrCreateNbt().putInt("StoredExperience", storedExperience);
			user.addExperience(experienceMultiplier);

			user.sendMessage(Text.of(storedExperience.toString()), true);

			return TypedActionResult.success(stack);
		}

		return TypedActionResult.pass(stack);
	}








	@Override
	public String tooltipTranslationKey() {
		return this.getTranslationKey();
	}

	@Override
	public boolean hasDetails() {
		return true;
	}
	@Override
	public boolean hasCredits() {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tryAppend(tooltip);
		
		tooltip.add(1, Text.translatable("item.slimesurvival.experience_crystal.tooltip", getStoredExperience(stack)));
	}
}
