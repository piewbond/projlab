// import java.awt.Polygon;

package vilagtalanvirologusok;

public interface PolygonChecker {
    int inf = 1000000000;

    default boolean isInside(int clickX, int clickY, Point[] polygon) {
        return true;
    }

    default boolean onSegment(Point p, Point q, Point r) {
        return true;
    }

    default int orientation() {
        return 0;
    }

    default boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        return true;
    }
    
    
    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
