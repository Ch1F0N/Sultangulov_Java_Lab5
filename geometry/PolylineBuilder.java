package geometry;

import java.util.*;
import java.util.stream.Collectors;

public class PolylineBuilder {
    public static Polyline buildPolyline(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Список точек пустой или null");
        }

        List<Point> processedPoints = points.stream()
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .distinct()
                .sorted(Comparator.comparingDouble(Point::getX))
                .collect(Collectors.toList());

        return new Polyline(processedPoints);
    }
}
