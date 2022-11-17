package physics_2D.primitives;

import org.joml.Vector2f;
import physics_2D.rigidbody.Rigidbody_2D;

public class Box_2D {
    private Vector2f size = new Vector2f();
    private Vector2f halfSize = new Vector2f();
    private Rigidbody_2D rigidBody = null;

    public Box_2D(){
        this.halfSize = new Vector2f(size).mul(0.5f);
    }

    public Box_2D(Vector2f min, Vector2f max){
        this.size = new Vector2f(max).sub(min);//gives us width and height
        this.halfSize = new Vector2f(size).mul(0.5f);
    }

    public Vector2f getMin() {
        return new Vector2f(this.rigidBody.getPosition()).sub(this.halfSize);//bottom left corner(position is center)
    }

    public Vector2f getMax() {
        return new Vector2f(this.rigidBody.getPosition()).add(this.halfSize);//Top right corner(position is center)
    }

    public Vector2f[] getVertices(){
        Vector2f min = getMin();
        Vector2f max = getMax();

        Vector2f[] vertices = {
                new Vector2f(min.x,min.y), new Vector2f(min.x,max.y),
                new Vector2f(max.x, min.y), new Vector2f(max.x,max.y)
        };//get all 4 vertices from min and max

        if(rigidBody.getRotation() != 0.0f){//the box is rotated
            for(Vector2f vertex : vertices){//we need to rotate the vertices
                //TODO: Implement this
                //GMath.rotate(vert, this.rigidBody.getPosition(), this.rigidBody.getRotation());
            }
        }

        return vertices;
    }

    public Rigidbody_2D getRigidBody() {
        return rigidBody;
    }
}
