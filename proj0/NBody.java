public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[n];
        double xP, yP, xV, yV, m;
        String img;

        int i;
        for (i = 0; i < n; i++) {
            xP = in.readDouble();
            yP = in.readDouble();
            xV = in.readDouble();
            yV = in.readDouble();
            m = in.readDouble();
            img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }

        return planets;
    }

    public static void main(String args[]) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        String background = "images/starfield.jpg";
        StdDraw.setScale(-1*radius, radius);
        StdDraw.picture(0, 0, background);
 
        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.enableDoubleBuffering();
        double t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];

        int i;
        while (t < T) {
            for (i = 0; i < planets.length; i += 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (i = 0; i < planets.length; i += 1) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, background);
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);

        for (i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                      planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                      planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

    }
}