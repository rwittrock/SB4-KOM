module Projectile {
    exports dk.sdu.mmmi.cbse.projectilesystem;

    requires common;

    provides dk.sdu.mmmi.cbse.common.services.IGamePluginService with dk.sdu.mmmi.cbse.projectilesystem.ProjectilePlugin;
    provides dk.sdu.mmmi.cbse.common.services.IEntityProcessingService with dk.sdu.mmmi.cbse.projectilesystem.ProjectileControlSystem;
}