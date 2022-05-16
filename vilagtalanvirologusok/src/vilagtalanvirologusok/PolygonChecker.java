// import java.awt.Polygon;

package vilagtalanvirologusok;

import java.awt.*;

public interface PolygonChecker {
    int inf = 1000000000;

    default boolean isInside(int clickX, int clickY, Point[] polygon, int n) {
        if (n < 3) {
            return false;
        }

        Point p = new Point(clickX, clickY);
        Point ext = new Point(this.inf, clickY);

        int count = 0;
        int i = 0;

        do {
            int next = (i + 1) % n;
            if (doIntersect(polygon[i], polygon[next], p, ext)) {
                if (orientation(polygon[i], p, polygon[next]) == 0) {
                    return onSegment(polygon[i], p, polygon[next]);
                }
                count++;
            }
            i = next;
        } while(i != 0);

        return (count % 2 == 1);
    }

    default boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

    default int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) {
            return 0;
        }
        return (val > 0) ? 1 : 2;
    }

    default boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }

        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }

        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }

        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }
        return false;
    }


    default Point[] polygonToArray(Polygon polygon) {
        Point[] res = new Point[polygon.npoints];

        int x, y;

        if (polygon.npoints > 0) {
            for (int i = 0; i < polygon.npoints; i++) {
                x = polygon.xpoints[i];
                y = polygon.ypoints[i];
                res[i] = new Point(x, y);
            }
        }

        return res;
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
