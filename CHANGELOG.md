# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).  

## [1.1.5] - 2020-07-29

### Fixed
- Trash can appearance

## [1.1.4] - 2020-07-28

### Fixed
- Compatibility with 1.16.1

## [1.1.3] - 2019-12-22

### Fixed
- Compatibility with 1.15

### Changed
- Make barrel rendering code less gruesome
- Removed transparency from fill bars (this is a temporary regression)
  - On a related note, I'm aware of item lighting issues on barrels
- Updated Fabric and all mods to 1.15 versions

## [1.1.2] - 2019-09-08

### Fixed
- Barrel hat deleting items without at least one identical item in inventory

## [1.1.1] - 2019-08-29

### Fixed
- Game crash upon item barrels being placed next to existing UnitedConveyors conveyors

## [1.1.0] - 2019-08-21

### Changed
- Refactored barrel/storage APIs for easier future expansion

### Fixed
- Item barrels not stacking after being crafted (now stack up to 8)

### Added
- HWYLA integration for item barrels 

## [1.0.9] - 2019-07-21

### Added
- All GitHub contributors to fabric.mod.json

### Changed
- Fabric versions to 1.14.4

### Fixed
- Noncompliant fabric.mod.json thanks to Juuxel

## [1.0.8] - 2019-06-30

### Added
- Screwdriver
  - Removes upgrades from Barrels
- New upgrade UI
  - Displays list and status when holding an upgrade or screwdriver
  - Shows conflicting upgrades
- Barrel Hat status messages (will eventually replace with graphical overlay)
- Hint message when trying to use stacked barrels with the Barrel Hat

### Changed
- Barrel hat now leaves 1 of each item in inventory/barrels
  - Allows for repeated usage, helpful when building
- Fabric versions to 1.14.3

### Fixed
- (Maybe) Issue where barrels would only hold 15 stacks on 1.14.3 (comment on #70)
- Dupe glitch as a result of missing items

## [1.0.7] - 2019-06-01

### Fixed
- Bug preventing the last stack from being extracted from barrels

## [1.0.6] - 2019-05-26

### Fixed
- Barrels will no longer delete inserted items hopefully for real this time

### Added
- Support for/dependency on LibBlockAttributes

## [1.0.5] - 2019-05-21

### Fixed
- Barrels will no longer delete inserted items when 63 items below max capacity
- Rendering issue with shields on the faces of barrels
- Client-side bug involving an equipped shield when trying to use a barrel

## [1.0.4] - 2019-05-14

### Changed
 - Fabric versions to 1.14.1

### Fixed
 - Barrels can now be broken properly from the front

### Added
 - Waterlogging support to Trash Can
 - Chinese Translation thanks to XuyuEre

## [1.0.3] - 2019-05-03

### Fixed
 - Multiplayer Barrel extraction issues (potentially; if not, this was an internal change that should have been made
   anyway)

## [1.0.2] - 2019-04-30

### Changed
 - Kotlin language adapter is no longer embedded

### Fixed
 - Dupe glitch with Barrel hat and stacked barrels
 - Double right-click behavior when empty

## [1.0.1] - 2019-04-23

### Fixed
 - Issue where Simple Pipes (and presumably other item-related mods) would not
   be able to interact with barrels properly, resulting in the deletion of 
   items

## [1.0.0] - 2019-04-22

This is a total rewrite of Stockpile, so some changes won't be listed.
**This is a breaking upgrade -- your old worlds will no longer work!** Old
barrels will disappear, as their IDs have changed.

### Changed
 - Dependency from Scala to Kotlin language adapter
 - Fabric and Minecraft versions to 1.14 Pre-Release 5
 - Internal structure to accommodate for an API 
 - Default barrel behavior to being locked
 
### Added
 - Proper upgrade system
   - Right-click on a Barrel with an upgrade to apply it
   - Upgrade removal is currently not implemented but will be added in the future
 - Barrel Hat
   - Allows for barrel interaction from inventory
   
### Fixed
 - Trash can now drops properly

## [0.5.2] - 2019-03-14

### Changed
 - Dependencies to Minecraft 19w11b versions
 - Mod package root to `me.branchpanic.mods` to reflect new domain

## [0.5.1] - 2019-03-01

### Fixed
 - Bug where Stockpile crashed dedicated servers on startup
 
## [0.5.0] - 2019-02-27

### Changed
 - Dependencies to Minecraft 19w09a versions

### Removed
 - Dependency on Cereal

## [0.4.6] - 2019-02-16

### Changed
 - Cereal version to 3.0.0-beta.2
 - Dependencies to Minecraft 19w07a versions

## [0.4.4] - 2019-01-26

### Fixed
 - Bug where an entire stack of barrels could be upgraded for the cost of one  

## [0.4.3] - 2019-01-25

### Changed
 - Cereal version to 3.0.0-beta
 - Dependencies to Minecraft 19w04a versions

## [0.4.2] - 2019-01-18

### Changed
 - Dependencies to Minecraft 19w03a/b/c versions

## [0.4.1] - 2019-01-12

### Added
 - Comparator output for barrels, since it wasn't implemented in the previous version
 
### Fixed
 - Version being reported as 1.0.0 

## [0.4.0] - 2019-01-12

### Added
 - Dependency on Cereal
 - Dependency on Fabric's Scala language adapter
 - Tag support to Barrel upgrade system
    - Instead of only chests, any item tagged `stockpile:barrel_storage_upgrade` will upgrade 

### Changed
 - Modding platform from Rift to Fabric
 - Barrel recipe
    - Rotated to make more sense with the texture
    - Uses tag `stockpile:barrel_storage_upgrade` to allow any chest-like block to be used in the recipe
    - Now yields 2 barrels to offset iron requirement
 - Barrel upgrades to take a little bit less experience
 - Barrel texture to fit in a bit more new textures
 
### Removed
 - Dependency on Riftlin

## [0.3.0] - 2018-08-30

### Added
 - Dependency on Riftlin
 - Ability to "lock" barrels
    - By default, barrels are unlocked
    - Shift right-click to toggle lock state
    - Locked barrels continue accepting only one item when empty
    - Unlocked barrels accept any item when empty
 - French translation (thanks to Yanis48)
    
### Changed
 - Rift version to 1.0.4-66
 - Barrel drop behavior in creative mode
    - Barrels no longer drop when broken in creative
    - Copies can be obtained via pick block
    
### Fixed
 - Indicator bar not properly filling up properly

## [0.2.0] - 2018-08-16

### Added
 - Indicator bar showing how full a barrel is

### Fixed
 - Issue where tile entities weren't removed after blocks were
 - Empty barrels showing their item as Air when right-clicked
 - Date on version 0.1.1 in the changelog (oops)

## [0.1.1] - 2018-08-14

### Changed
 - Rift version from 1.0.2-33 to 1.0.3-45

## [0.1.0] - 2018-08-08

### Added
 - Barrel: holds many stacks of a single item
    - Right-click to insert the held stack (if possible)
    - Double-right-click to insert as many stacks as possible from inventory
    - Left-click to extract a single item
    - Crouch-left-click to extract an entire stack
  - Trash Can: deletes items
    - Right-clicking opens/closes the lid
    - When open, items thrown on top are deleted
    - Items hoppered in are always deleted
