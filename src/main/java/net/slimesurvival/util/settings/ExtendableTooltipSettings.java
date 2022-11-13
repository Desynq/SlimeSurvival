package net.slimesurvival.util.settings;

public class ExtendableTooltipSettings {
	public boolean hasDetails;
	public boolean hasHowToObtain;
	public boolean hasLore;
	public boolean hasCredits;
	public String translationKey;

	public ExtendableTooltipSettings hasDetails() {
		this.hasDetails = true;
		return this;
	}

	public ExtendableTooltipSettings hasHowToObtain() {
		this.hasHowToObtain = true;
		return this;
	}

	public ExtendableTooltipSettings hasLore() {
		this.hasHowToObtain = true;
		return this;
	}

	public ExtendableTooltipSettings hasCredits() {
		this.hasCredits = true;
		return this;
	}

	public ExtendableTooltipSettings setTranslationKey(String key) {
		this.translationKey = key;
		return this;
	}
}
