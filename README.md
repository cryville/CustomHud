# CustomHUD - Custom text overlay mod for scripting
Minecraft version: 1.12.2 (*both client-side and server-side required*)

Note: Do not abuse the mod or it may kill the server network traffic.

## API
```js
var CustomHudApi = Java.type("world.cryville.customhud.CustomHudApi"); // Declaration
CustomHudApi.put(player, id, posX, posY, anchorX, anchorY, dropsShadow); // Create a new overlay
CustomHudApi.set(player, id, text); // Update the content of an overlay
CustomHudApi.remove(player, id); // Remove an overlay
```

`player` is instance of `net.minecraft.entity.player.EntityPlayerMP`.

## Example (CustomNPCs)
```js
var CustomHudApi = Java.type("world.cryville.customhud.CustomHudApi");
function init(e) {
    var player = e.player.getMCEntity();
    CustomHudApi.put(player, 1, 0.02, 0.95, 0, 1, true); // anchorX = 0 (horizontal align: left) anchorY = 1 (vertical align: bottom)
    CustomHudApi.set(player, 1, "§aHello, World!");
}
```
