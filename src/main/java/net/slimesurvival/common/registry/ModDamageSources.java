package net.slimesurvival.common.registry;

import net.minecraft.entity.damage.DamageSource;

public class ModDamageSources {
	public static final DamageSource BASIC_DAMAGE = new BasicDamageSource("basicDamage");





	private static class BasicDamageSource extends DamageSource {
		public BasicDamageSource(String name) {
			super(name);
		}
	}
}
