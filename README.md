# README

## Disclaimer

This mod breaks probably over a dozen licenses and gives no credit to any mod authors from whom I've stolen code from.

As such, I present this repository as a way for me to track my own commit history in case I need to do a rollback at some point or view old code to cringe at.

I do NOT condone the stealing of mod authors' work in order to make revenue or otherwise illicitly reupload their mods in full.
This is simply a "collage" of different modder's work with some of my own and egregious amounts of duct tape and glue rivaling that of a high school art project.

## Compiling

If you wish to compile this mod, I suggest you don't since it'll probably break a lot of things if you don't follow its `build.gradle` and `gradle.properties` to a tee.

## Fabric Properties

- Minecraft: 1.18.2
- Yarn Mappings: 1.18.2 + Build.3
- Fabric Loader: 0.14.7

## Dependencies

### Download Required

- Artifacts
  - My mod has a mixin that "rebalances" the Feral Claws
- Bewitchment by MoriyaShiine
  - Used for various origins, recipes, weapons, etc.
- Origins by Apace100
  - Used for my own special origins and powers
- *Patchouli is a mod by Vazkii*
  - Used for in-game mod documentation (that I haven't done because I'm too lazy)
- Pehkui
  - Used for scale related changes
- Trinkets
  - Used for the various trinkets my mod adds
- Projectile Damage
  - Gives my ranged weapons custom damage and allows for certain trinkets to work

### Included

- PlayerAbilityLib
- Reach Entity Attributes
- Terraform Wood API

## Recommended

- Universal Enchants by Fuzs
  - Will allow weapons with normally incompatible enchantments to work as intended (I.e., Mystite Longbow and Mystite Shortbow)
  - Can probably be substituted with any mod that completes the same function of allowing enchantments to work on different items (I.e., quick charge and piercing on bow)

## Credits

- DragonLoot
- I stole a lot of your code for my registries
- MultiBossbarFix
- I literally copied your single mixin and transplanted it into my mod for 1.18.2
- Things
  - I used your `ExtendableTooltipProvider` as "inspiration" for my own tooltip provider that supports line breaks (`\n`) in tooltip translation keys
- Mob Origins
  - I literally copied your mixin for the bouncy effect
