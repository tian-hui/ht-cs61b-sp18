public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other) {
        double dx = other.xxPos - this.xxPos;
        double dy = other.yyPos - this.yyPos;
        double r = Math.sqrt(dx*dx + dy*dy);
        return r;
    }

    public double calcForceExertedBy(Planet other) {
        double r = this.calcDistance(other);
        double force = (G * this.mass * other.mass) / (r * r);
        return force;
    }

    public double calcForceExertedByX(Planet other) {
        double dx = other.xxPos - this.xxPos;
        double r = this.calcDistance(other);
        double fx = this.calcForceExertedBy(other) * dx / r;
        return fx;
    }

    public double calcForceExertedByY(Planet other) {
        double dy = other.yyPos - this.yyPos;
        double r = this.calcDistance(other);
        double fy = this.calcForceExertedBy(other) * dy / r;
        return fy;        
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double netfx = 0;
        for (Planet p : planets) {
            if (p.equals(this)) {
                continue;
            } else {
                netfx = netfx + this.calcForceExertedByX(p);
            }
        }
        return netfx;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netfy = 0;
        for (Planet p : planets) {
            if (p.equals(this)) {
                continue;
            } else {
                netfy = netfy + this.calcForceExertedByY(p);
            }
        }
        return netfy;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        String imageToDraw = "images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, imageToDraw);
    }
}