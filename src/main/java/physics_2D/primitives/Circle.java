package physics_2D.primitives;

import org.joml.Vector2f;
import physics_2D.rigidbody.Rigidbody_2D;

public class Circle {
    private float radius;
    private Rigidbody_2D body = null;
    public Circle(float radius){
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public Vector2f getCenter(){
        return body.getPosition();
    }

}
