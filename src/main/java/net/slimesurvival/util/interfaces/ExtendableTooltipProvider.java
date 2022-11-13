package net.slimesurvival.util.interfaces;

import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.slimesurvival.util.TooltipHelper;
import net.slimesurvival.util.settings.ExtendableTooltipSettings;

public interface ExtendableTooltipProvider {

	default void addExtendableTooltips(List<Text> tooltip, ExtendableTooltipSettings tooltipSettings) {
		boolean hasDetails = tooltipSettings.hasDetails;
		boolean hasHowToObtain = tooltipSettings.hasHowToObtain;
		boolean hasLore = tooltipSettings.hasDetails;
		boolean hasCredits = tooltipSettings.hasCredits;
		String translationKey = tooltipSettings.translationKey;

		if (hasCredits && Screen.hasControlDown() && Screen.hasAltDown()) {
			TooltipHelper.append(tooltip, translationKey + ".credits");
		}
		else if (hasDetails && Screen.hasShiftDown()) {
			TooltipHelper.append(tooltip, translationKey + ".details");
		}
		else if (hasHowToObtain && Screen.hasControlDown()) {
			TooltipHelper.append(tooltip, translationKey + ".how_to_obtain");
		}
		else if (hasLore && Screen.hasAltDown()) {
			TooltipHelper.append(tooltip, translationKey + ".lore");
		}
		else {
			if (hasCredits) {
				TooltipHelper.append(tooltip, ".tooltip");
			}
			if (hasDetails) {
				tooltip.add(TooltipHelper.SHOW_DETAILS_TOOLTIP);
			}
			if (hasHowToObtain) {
				tooltip.add(TooltipHelper.SHOW_HOW_TO_OBTAIN_TOOLTIP);
			}
			if (hasLore) {
				tooltip.add(TooltipHelper.SHOW_LORE);
			}
			if (hasCredits) {
				tooltip.add(TooltipHelper.SHOW_CREDITS);
			}
		}
	}
}
