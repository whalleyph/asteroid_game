public interface SpaceShip extends GameObject {
    void collisionWithMeteor();
    void fireLaser();

    void turnRight();
    void turnLeft();

    void thrust();
}
