package round2;

public class Circle {
    public static void main(String[] args) {
        new Circle().drawCircle(1);
        new Circle().drawCircle(2);
        new Circle().drawCircle(3);
        new Circle().drawCircle(4);
    }
    void drawCircle(int r) {
        // Consider a rectangle of size N*N
        int N = 2 * r + 1;

        int x, y;  // Coordinates inside the rectangle

        // Draw a square of size N*N.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Start from the left most corner point
                x = i - r;
                y = j - r;

                // If this point is inside the circle, print it
                if (x * x + y * y <= r * r)
                    System.out.print("O");
                else // If outside the circle, print space
                    System.out.print(".");
                System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
