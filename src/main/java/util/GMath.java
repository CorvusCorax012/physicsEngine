package util;

import org.joml.Vector2f;

public class GMath {
    public static void rotate(Vector2f vector, float angleDeg, Vector2f origin){
        float x = vector.x - origin.x;//here we move any vector to the origin for easier calculation
        float y = vector.y - origin.y;

        float cos = (float)Math.cos(Math.toRadians(angleDeg));//cast to radians for calculations since we will
        float sin = (float)Math.sin(Math.toRadians(angleDeg));//pass in degrees.

        float xPrime = (x * cos) - (y * sin);//fancy proof
        float yPrime = (x * sin) + (y * cos);

        xPrime += origin.x;
        yPrime += origin.y;//here we are moving it back to the original place

        vector.x = xPrime;
        vector.y = yPrime;//we modify the vector that is passed in.
    }

    //compare two nums to a certain degree of precision
    public static boolean compare(float x, float y, float epsilon){
        return Math.abs(x - y) <= epsilon * Math.max(1.0f, Math.max(Math.abs(x), Math.abs(y)));//trick need to research
    }

    public static boolean compare(Vector2f vec1, Vector2f vec2, float epsilon){
        return compare(vec1.x, vec2.x, epsilon) && compare(vec1.y, vec2.y, epsilon);
    }

    //Overloaded compare with min float value
    public static boolean compare(float x, float y){
        return Math.abs(x - y) <= Float.MIN_VALUE * Math.max(1.0f, Math.max(Math.abs(x), Math.abs(y)));//trick need to research
    }

    public static boolean compare(Vector2f vec1, Vector2f vec2){
        return compare(vec1.x, vec2.x) && compare(vec1.y, vec2.y);
    }
}
