# smashgg-java
Java API wrapper for Smash.gg's public api

## Authors 
#### Jarrod Blanton, Brandon Cooke

## Goal
This package is meant to act as a standalone library wrapper around the Smash.gg Public API. 
It offers Java Object implementations of the typical constructs offered by the API. These constructs
are `Tournaments`, `Events`, `Phases`, `Phase Groups`, `Video Games`, and `Characters`. 

Smash.gg organizes a construct heirarchy of the following specification:
**Tournaments** -contain--> **Events** -contain--> **Phases** -contain--> **Phases Groups**

Phases Groups are atomic. They contain all of the Sets in any given Tournament, even if the tournament is 
made up of a single bracket. [Here's an example](https://smash.gg/tournament/21xx-cameron-s-birthday-bash-1/events/melee-singles/brackets/291494/618443)

