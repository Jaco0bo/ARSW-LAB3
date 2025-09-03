package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("subsamplingFilter")
public class SubsamplingFilter implements BluePrintsFilter {
    @Override
    public Blueprint applyFilter(Blueprint bp) {
        List<Point> filteredPoints = new ArrayList<>();
        List<Point> points = bp.getPoints();
        for (int i = 0; i < points.size(); i++) {
            if (i % 2 == 0) {
                filteredPoints.add(points.get(i));
            }
        }
        return new Blueprint(bp.getAuthor(), bp.getName(), filteredPoints.toArray(new Point[0]));
    }
}
