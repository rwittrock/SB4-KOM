module Collision {
    exports dk.sdu.mmmi.cbse.collision;

    requires common;

    provides dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService with dk.sdu.mmmi.cbse.collision.Collider;
}