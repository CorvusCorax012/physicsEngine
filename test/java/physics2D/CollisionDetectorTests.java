package physics2D;

import org.joml.Vector2f;
import org.junit.Test;
import physics_2D.rigidbody.IntersectionDetector_2D;
import renderer.Line_2D;

import static org.junit.Assert.assertTrue;


public class CollisionDetectorTests {

    private final float EPSILON = 0.000001f;

    @Test
    public void pointOnLinePass(){
        Line_2D line = new Line_2D(new Vector2f(0,0), new Vector2f(12,4));
        Vector2f point = new Vector2f(0,0);

        assertTrue(IntersectionDetector_2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnLineTwoPass(){
        Line_2D line = new Line_2D(new Vector2f(0,0), new Vector2f(12,4));
        Vector2f point = new Vector2f(12,4);

        assertTrue(IntersectionDetector_2D.pointOnLine(point, line));
    }

    @Test
    public void pointOnVerticalLinePass(){
        Line_2D line = new Line_2D(new Vector2f(0,0), new Vector2f(0,10));
        Vector2f point = new Vector2f(0,5);

        assertTrue(IntersectionDetector_2D.pointOnLine(point, line));
    }
}
