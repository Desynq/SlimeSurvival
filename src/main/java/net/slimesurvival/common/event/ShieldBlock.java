package net.slimesurvival.common.event;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldBlockCallback;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.slimesurvival.common.enchantment.ShieldEnchantmentHelper;
import net.slimesurvival.common.registry.ModEnchantments;

public class ShieldBlock {

	public static double parryKnockbackMultiplier;

	public static float baseKnockbackValue = 0.5F;
	public static float barbedDamage = 4.0F;





	public static void register() {
		ShieldBlockCallback.EVENT.register((defender, source, amount, hand, shield) -> extracted(defender, source, hand));
	}





	private static ActionResult extracted(LivingEntity defender, DamageSource source, Hand hand) {
		// Living Entity
		LivingEntity attacker = (LivingEntity) source.getAttacker();
		assert attacker != null;
		// Parry
		if (defender instanceof PlayerEntity player && defender.getItemUseTime() <= 10 && defender.isSneaking() && !source.isProjectile()) {
			attacker.playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 0.5F, 1.0F);
			ItemStack stack = player.getStackInHand(hand);

			parryKnockbackMultiplier = baseKnockbackValue + ((EnchantmentHelper.getEquipmentLevel(ModEnchantments.PUMMELING_ENCHANTMENT, defender) * 0.416666667) - baseKnockbackValue);

			// Barbed
			if (ShieldEnchantmentHelper.hasBarbed(defender)) {
				attacker.damage(DamageSource.MAGIC, barbedDamage);
				stack.damage(2, attacker, (e) -> e.sendToolBreakStatus(hand));
			}

			// Knockback
			double dx = attacker.getX() - defender.getX();
			double dz = attacker.getZ() - defender.getZ();
			double f = Math.max(Math.sqrt(dx * dx + dz * dz), 0.001D);
			attacker.addVelocity( dx / f * parryKnockbackMultiplier, 0.25D, dz / f * parryKnockbackMultiplier);
			attacker.velocityModified = true;
			player.addExhaustion(1.0F);
			player.getItemCooldownManager().set(Items.SHIELD, 20);
			defender.clearActiveItem();
			defender.world.sendEntityStatus(defender, (byte) 30);
			defender.setInvulnerable(true);
			stack.damage(1, attacker, (e2) -> e2.sendToolBreakStatus(hand));

		}
		if (defender.getItemUseTime() > 200 && defender instanceof PlayerEntity player) {
			player.getItemCooldownManager().set(Items.SHIELD, 100);
			defender.clearActiveItem();
			defender.world.sendEntityStatus(defender, (byte) 30);
		}
		return ActionResult.success(true);
	}
	
	
}
