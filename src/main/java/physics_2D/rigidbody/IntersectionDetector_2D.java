package physics_2D.rigidbody;

import org.joml.Vector2f;
import physics_2D.primitives.AABB;
import physics_2D.primitives.Box_2D;
import physics_2D.primitives.Circle;
import renderer.Line_2D;
import util.GMath;

import java.util.Vector;

public class IntersectionDetector_2D {
    //Point vs. Primitives
    public static  boolean pointOnLine(Vector2f point, Line_2D line){
        //y = mx + b
        float dy = line.getEnd().y - line.getStart().y;//delta y
        float dx = line.getEnd().x - line.getStart().x;//delta x
        if(dx == 0){
            return GMath.compare(point.x, line.getStart().x);
        }
        float m = dy/dx;//rise/run
        float b = line.getEnd().y - (m * line.getEnd().x);//find origin

        return point.y == m * point.x + b;
    }

    public static boolean pointInCircle(Vector2f point, Circle circle){
        Vector2f circleCenter = circle.getCenter();
        Vector2f centerToPoint = new Vector2f(point).sub(circleCenter);

        return centerToPoint.lengthSquared() <= circle.getRadius() * circle.getRadius();
    }

    public static boolean pointInAABB(Vector2f point, AABB box){
        Vector2f min = box.getMin();
        Vector2f max = box.getMax();

        return point.x <= max.x && min.x <= point.x &&
                point.y <= max.y && min.y <= point.y;
    }

    public static boolean pointInBox2D(Vector2f point, Box_2D box){
        //Translate point into local space rotation
        Vector2f pointLocalBoxSpace = new Vector2f();
        GMath.rotate(pointLocalBoxSpace, box.getRigidBody().getRotation(), box.getRigidBody().getPosition());

        Vector2f min = box.getMin();
        Vector2f max = box.getMax();

        return pointLocalBoxSpace.x <= max.x && min.x <= pointLocalBoxSpace.x &&
                pointLocalBoxSpace.y <= max.y && min.y <= pointLocalBoxSpace.y;
    }

    public static boolean lineAndCircle(Line_2D line, Circle circle){//checks whether line and circle are intersecting
        if (pointInCircle(line.getStart(), circle) || pointInCircle(line.getEnd(), circle)){
            return true;
        }

        Vector2f ab = new Vector2f(line.getEnd()).sub(line.getStart());

        Vector2f circleCenter = circle.getCenter();
        Vector2f centerToLineStart = new Vector2f(circleCenter).sub(line.getStart());
        float t = centerToLineStart.dot(ab) / ab.dot(ab);

        if (t < 0.0f || t > 1.0f){
            return false;
        }

        Vector2f closestPoint = new Vector2f(line.getStart()).add(ab.mul(t));

        return pointInCircle(closestPoint,circle);
    }
}
