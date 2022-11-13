package net.slimesurvival.util.provider;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

@Deprecated
public interface ExtendableTooltipProvider {
	public static final Text SHOW_DETAILS_TOOLTIP = new TranslatableText("tooltip.slimesurvival.show_details");
	public static final Text SHOW_HOW_TO_OBTAIN_TOOLTIP = new TranslatableText("tooltip.slimesurvival.show_how_to_obtain");
	public static final Text SHOW_LORE = new TranslatableText("tooltip.slimesurvival.show_lore");
	public static final Text SHOW_CREDITS = new TranslatableText("tooltip.slimesurvival.show_credits");

	String tooltipTranslationKey();

	default boolean hasExtendedTooltip() {
		return true;
	}
	default boolean hasTooltip() {
		return false;
	}
	default boolean hasDetails() {
		return false;
	}
	default boolean hasHowToObtain() {
		return false;
	}
	default boolean hasLore() {
		return false;
	}
	default boolean hasCredits() {
		return false;
	}



	default void tryAppend(List<Text> tooltip) {
		if (!hasExtendedTooltip()) return;

		if (hasCredits() && Screen.hasControlDown() && Screen.hasAltDown()) {
			append(tooltip, ".credits");

		} else if (hasDetails() && Screen.hasShiftDown()) {
			append(tooltip, ".details");

		} else if (hasHowToObtain() && Screen.hasControlDown()) {
			append(tooltip, ".how_to_obtain");

		} else if (hasLore() && Screen.hasAltDown()) {
			append(tooltip, ".lore");

		} else {
			if (hasTooltip()) append(tooltip, ".tooltip");
			if (hasDetails()) tooltip.add(SHOW_DETAILS_TOOLTIP);
			if (hasHowToObtain()) tooltip.add(SHOW_HOW_TO_OBTAIN_TOOLTIP);
			if (hasLore()) tooltip.add(SHOW_LORE);
			if (hasCredits()) tooltip.add(SHOW_CREDITS);
		}
	}



	default void append(List<Text> tooltip, String type) {
		String[] lines = I18n.translate(tooltipTranslationKey() + type).split("\n");
		ArrayList<Text> texts = new ArrayList<Text>();

		for (String line : lines) {
			texts.add(new LiteralText(line));
		}

		tooltip.addAll(texts);
	}
}
