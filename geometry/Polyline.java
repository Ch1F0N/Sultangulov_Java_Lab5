package geometry;

import java.util.List;
import java.util.stream.Collectors;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("Список точек не может быть пустым");
        }
        this.points = points;
    }

    public List<Point> getPoints() { return points; }

    @Override
    public String toString() {
        return "Линия [" + points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
