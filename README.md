# README

## Disclaimer

This mod breaks probably over a dozen licenses and gives no credit to a large portion of the mod authors from whom I've stolen code from (largely because I've forgotten most of the people I've stolen code/assets from at this point).

As such, I present this repository as a way for me to track my own commit history in case I need to do a rollback at some point or view old code to cringe at.

I do NOT condone the stealing of mod authors' work in order to make revenue or otherwise illicitly reupload their mods in full.
This is simply a "collage" of different modder's work with some of my own and egregious amounts of duct tape and glue rivaling that of a high school art project.

## Compiling

***Good luck.***

## Fabric Properties

- Minecraft: 1.18.2
- Yarn Mappings: 1.18.2 + Build.4
- Fabric Loader: 0.14.9

## Dependencies

### Download Required

"WIP"

### Included

- PlayerAbilityLib
- Reach Entity Attributes
- Terraform Wood API
  - Workspace dependency for Bewitchment

### Recommended

- Universal Enchants by Fuzs
  - Will allow weapons with normally incompatible enchantments to work as intended (I.e., Mystite Longbow and Mystite Shortbow)
  - Can probably be substituted with any mod that completes the same function of allowing enchantments to work on different items (I.e., quick charge and piercing on bow)

## Credits

Note: *This list is incomplete*

- MultiBossbarFix
  - I copied your single mixin and transplanted it into my mod for 1.18.2.
- Things
  - I used your `ExtendableTooltipProvider` as "inspiration" for my own tooltip provider that supports line breaks (`\n`) in tooltip translation keys.
- Mob Origins
  - I literally copied your mixin for the bouncy effect.
- Better Nether
  - I hardcoded your `InitialStackStateProvider` for my own use.
