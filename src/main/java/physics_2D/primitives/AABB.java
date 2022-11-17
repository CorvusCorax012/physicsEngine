package physics_2D.primitives;

import org.joml.Vector2f;
import physics_2D.rigidbody.Rigidbody_2D;

//Axis Aligned Bounding Box
public class AABB {
    private Vector2f size = new Vector2f();
    private Vector2f halfSize = new Vector2f();
    private Rigidbody_2D rigidBody = null;

    public AABB(){
        this.halfSize = new Vector2f(size).mul(0.5f);
    }

    public AABB(Vector2f min, Vector2f max){
        this.size = new Vector2f(max).sub(min);//gives us width and height
        this.halfSize = new Vector2f(size).mul(0.5f);
    }

    public Vector2f getMin() {
        return new Vector2f(this.rigidBody.getPosition()).sub(this.halfSize);//bottom left corner(position is center)
    }

    public Vector2f getMax() {
        return new Vector2f(this.rigidBody.getPosition()).add(this.halfSize);//Top right corner(position is center)
    }
}
