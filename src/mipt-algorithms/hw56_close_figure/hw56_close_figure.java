import java.util.Scanner;

class Circle {
    int num;
    double cx;
    double cy;
    double r;

    public Circle(int num, double cx, double cy, double r) {
        this.num = num;  // исправлено: убрано int num
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }
}

class Polygon {
    int num;
    int m; 
    double[] x; 
    double[] y; 

    public Polygon(int num, int m, double[] x, double[] y) {
        this.num = num;  // исправлено: убрано int num
        this.m = m;
        this.x = x;
        this.y = y;
    }
}

public class hw56_close_figure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Чтение координат локации
        String startCoord = scanner.nextLine();
        String[] coord = startCoord.split(" ");
        double x0 = Double.parseDouble(coord[0]);
        double y0 = Double.parseDouble(coord[1]);
        
        // Чтение количества фигур
        int figuresQ = Integer.parseInt(scanner.nextLine().trim());
        
        // Массив для хранения фигур
        Object[] figures = new Object[figuresQ];
        
        // Чтение описаний фигур
        for (int i = 0; i < figuresQ; i++) {
            String figure = scanner.nextLine();
            String[] figureData = figure.split(" ");
            
            if (figureData[0].equals("Circle")) {
                // Circle: cx cy r
                int num = i;
                double cx = Double.parseDouble(figureData[1]);
                double cy = Double.parseDouble(figureData[2]);
                double r = Double.parseDouble(figureData[3]);
                
                figures[i] = new Circle(num, cx, cy, r);
                
            } else if (figureData[0].equals("Polygon")) {
                // Polygon: m x1 y1 x2 y2 ... xm ym
                int num = i;
                int m = Integer.parseInt(figureData[1]);
                double[] xCoords = new double[m];
                double[] yCoords = new double[m];
                
                for (int j = 0; j < m; j++) {
                    xCoords[j] = Double.parseDouble(figureData[2 + j*2]);
                    yCoords[j] = Double.parseDouble(figureData[3 + j*2]);
                }
                
                figures[i] = new Polygon(num, m, xCoords, yCoords);
            }
        }
        
        scanner.close();

        // Находим максимальную координату для определения длины луча
        double maxAbsX = 0.0;
        double maxAbsY = 0.0;
        
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] instanceof Circle) {
                Circle circle = (Circle) figures[i];
                maxAbsX = Math.max(maxAbsX, Math.abs(circle.cx));
                maxAbsY = Math.max(maxAbsY, Math.abs(circle.cy));
                
            } else if (figures[i] instanceof Polygon) {
                Polygon polygon = (Polygon) figures[i];
                for (int j = 0; j < polygon.m; j++) {
                    maxAbsX = Math.max(maxAbsX, Math.abs(polygon.x[j]));
                    maxAbsY = Math.max(maxAbsY, Math.abs(polygon.y[j]));
                }
            }
        }

        // Длина луча - максимальное расстояние от начала координат до самой дальней точки + расстояние до точки (x0, y0)
        double maxDistanceFromOrigin = Math.sqrt(maxAbsX * maxAbsX + maxAbsY * maxAbsY);
        double distanceToPoint = Math.sqrt(x0 * x0 + y0 * y0);
        double rayLength = maxDistanceFromOrigin + distanceToPoint + 1.0; // добавляем запас
        
        // Инициализируем переменные для поиска ближайшей фигуры
        double minDistance = Double.MAX_VALUE;
        int closestFigureNum = -1;
        
        // Луч вращается на 360 градусов, проверяем пересечения
        int steps = 3600; // 3600 шагов = 0.1 градус на шаг
        double angleStep = 2 * Math.PI / steps; // шаг в радианах
        
        for (int step = 0; step < steps; step++) {
            double angle = step * angleStep;
            
            // Координаты конца луча
            double xEnd = x0 + rayLength * Math.cos(angle);
            double yEnd = y0 + rayLength * Math.sin(angle);
            
            // Для каждой фигуры проверяем пересечение с лучом
            for (int i = 0; i < figures.length; i++) {
                double intersectionDistance = Double.MAX_VALUE;
                
                if (figures[i] instanceof Circle) {
                    Circle circle = (Circle) figures[i];
                    intersectionDistance = intersectRayWithCircle(x0, y0, xEnd, yEnd, circle);
                    
                } else if (figures[i] instanceof Polygon) {
                    Polygon polygon = (Polygon) figures[i];
                    intersectionDistance = intersectRayWithPolygon(x0, y0, xEnd, yEnd, polygon);
                }
                
                // Если нашли пересечение ближе, чем текущее минимальное
                if (intersectionDistance < minDistance - 1e-9) { // учитываем погрешность
                    minDistance = intersectionDistance;
                    closestFigureNum = i;
                }
                // Если расстояние одинаковое, берем фигуру с меньшим номером
                else if (Math.abs(intersectionDistance - minDistance) < 1e-9 && i < closestFigureNum) {
                    closestFigureNum = i;
                }
            }
        }
        
        // Выводим номер ближайшей фигуры (индексация с 0, по условию вероятно нужно выводить с 1)
        System.out.println(closestFigureNum + 1);
    }
    
    // Функция пересечения луча с окружностью
    private static double intersectRayWithCircle(double x0, double y0, double xEnd, double yEnd, Circle circle) {
        // Вектор направления луча
        double dx = xEnd - x0;
        double dy = yEnd - y0;
        
        // Параметрическое уравнение луча: x = x0 + t*dx, y = y0 + t*dy, где t >= 0
        
        // Квадратное уравнение для пересечения луча с окружностью
        double a = dx*dx + dy*dy;
        double b = 2*(dx*(x0 - circle.cx) + dy*(y0 - circle.cy));
        double c = (x0 - circle.cx)*(x0 - circle.cx) + (y0 - circle.cy)*(y0 - circle.cy) - circle.r*circle.r;
        
        double discriminant = b*b - 4*a*c;
        
        if (discriminant < 0) {
            return Double.MAX_VALUE; // нет пересечения
        }
        
        double sqrtDisc = Math.sqrt(discriminant);
        double t1 = (-b - sqrtDisc) / (2*a);
        double t2 = (-b + sqrtDisc) / (2*a);
        
        // Нас интересует первое положительное пересечение
        double t = Double.MAX_VALUE;
        if (t1 > 1e-9) {
            t = t1;
        }
        if (t2 > 1e-9 && t2 < t) {
            t = t2;
        }
        
        if (t == Double.MAX_VALUE) {
            return Double.MAX_VALUE;
        }
        
        // Расстояние от точки (x0, y0) до точки пересечения
        return t * Math.sqrt(dx*dx + dy*dy);
    }
    
    // Функция пересечения луча с многоугольником
    private static double intersectRayWithPolygon(double x0, double y0, double xEnd, double yEnd, Polygon polygon) {
        double minDistance = Double.MAX_VALUE;
        
        // Проверяем пересечение с каждой стороной многоугольника
        for (int i = 0; i < polygon.m; i++) {
            int j = (i + 1) % polygon.m; // следующая вершина
            
            double x1 = polygon.x[i];
            double y1 = polygon.y[i];
            double x2 = polygon.x[j];
            double y2 = polygon.y[j];
            
            double distance = intersectRayWithSegment(x0, y0, xEnd, yEnd, x1, y1, x2, y2);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        
        return minDistance;
    }
    
    // Функция пересечения луча с отрезком
    private static double intersectRayWithSegment(double x0, double y0, double xEnd, double yEnd, 
                                                  double x1, double y1, double x2, double y2) {
        // Параметрическое уравнение луча: x = x0 + t*dx, y = y0 + t*dy, t >= 0
        double dx = xEnd - x0;
        double dy = yEnd - y0;
        
        // Параметрическое уравнение отрезка: x = x1 + u*(x2-x1), y = y1 + u*(y2-y1), 0 <= u <= 1
        double dxSeg = x2 - x1;
        double dySeg = y2 - y1;
        
        // Решаем систему уравнений
        double denominator = dySeg * dx - dxSeg * dy;
        
        if (Math.abs(denominator) < 1e-9) {
            return Double.MAX_VALUE; // луч и отрезок параллельны
        }
        
        double t = ((x1 - x0) * dySeg - (y1 - y0) * dxSeg) / denominator;
        double u = ((x1 - x0) * dy - (y1 - y0) * dx) / denominator;
        
        // Проверяем условия пересечения
        if (t >= 0 && u >= 0 && u <= 1) {
            // Расстояние от точки (x0, y0) до точки пересечения
            return t * Math.sqrt(dx*dx + dy*dy);
        }
        
        return Double.MAX_VALUE;
    }
}