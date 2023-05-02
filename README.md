# TowerDefense
### Phase 1
- Start Screen:
  - A way to "start the game" that moves to the initial configuration screen
  - A way to "quit the game" that quits the game within the application
- Initial Configuration Screen:
  - An input for the character's name
  - Name cannot be whitespace-only, empty, or null
  - An input for at least 3 difficulties
  - A way to lock-in choices and move to the Game Screen
- Game Screen:
  - Display start money, varied by difficulty
  - Display/describe a path leading to a monument that enemies will travel on in future
milestones
  - Display/describe a monument that enemies will attack and towers will defend in future
milestones
  - Display/describe monument health, varied by difficulty
### Phase 2
- Tower Menu:
  - Player can purchase Towers from the Tower menu with money
  - Tower costs vary based off difficulty
  - Towers will not be able to be bought with insufficient funds
- Placement:
  - After purchasing, the player can place towers onto the map
  - The player will not be allowed to play towers onto the path
- Towers:
  - At least 3 different types of towers, differentiated either visually or
textually for now
### Phase 3
- Starting Combat:
  - On the Game Screen, there will be a new prompt/option to "start combat"
  - When activating this prompt/option, enemies will start travelling along the path
- Enemies:
  - There will be at least 3 different types of enemies, differentiated
either visually or textually for now
  - If the enemies reach the monument, monument health will decrease
- Game Over:
  - If the monument health is less than or equal to 0, the game will end, and the player
be brought to a game over screen
  - The game over screen will console the player and offer a prompt/option to bring
them back to the welcome screen to restart the game
### Phase 4
- Combat:
  - Towers in 'proximity' to enemies will attack said enemies
  - Towers will have some sort of proximity idea
  - Combat will be able to be viewed appropriately by the player (a.k.a. it doesn’t
happen in an instant, and the player can somehow see that towers hit the enemies such
as health bars or physical projectiles)
  - Enemies will disappear if their ‘health’ reaches zero
  - Over the course of the game, the player is able to change their
tower placement, such as buying new towers or moving their towers
  - The 3 different towers 
  attack enemies in some distinct manner
  - The 3 different enemies will have varying gameplay
- Money:
  - There will be some way for the player to gain money while playing the game
  - There will be some way to spend money during the game after the first activation of
“Start Combat”
### Phase 5
- Final Boss:
  - After some time/rounds, and much
more powerful enemy will appear
  - The player will be notified when they defeat this enemy that they have won the
game
- Win Screen:
  - Triggered after defeating the final boss
  - Statistics will be added to both Game Over and Win Screen
  - will be able to start over without exiting the app or close the app through the
application
- Upgrades:
  - Individual towers will now be able to be upgraded, increase some tower statistics to
benefit the player in gameplay (damage, attack speed, range, area of effect, etc.)
  - The player will be able to see the upgrade level of their tower
