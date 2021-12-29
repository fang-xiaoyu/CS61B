public class Planet {
    public double xxPos;    //Its current x position
    public double yyPos;    //Its current y position
    public double xxVel;    //Its current velocity in the x direction
    public double yyVel;    //Its current velocity in the y direction
    public double mass;     //Its mass
    public String imgFileName;    //The name of the file that corresponds to the image that depicts the body
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = Math.abs(p.xxPos - this.xxPos);
        double dy = Math.abs(p.yyPos - this.yyPos);
        double r2 = dx*dx + dy*dy;
        return Math.sqrt(r2);
    }

    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        double F = (Planet.G * p.mass*this.mass) / (r*r);
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double Fx = F * (dx / r);
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double Fy = F * (dy / r);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] all_Planets) {
        double netFx = 0;
        for (int i = 0; i < all_Planets.length; i++) {
            if (all_Planets[i].equals(this)) {
                continue;
            }
            netFx += calcForceExertedByX(all_Planets[i]);
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] all_Planets) {
        double netFy = 0;
        for (int i = 0; i < all_Planets.length; i++) {
            if (all_Planets[i].equals(this)) {
                continue;
            }
            netFy += calcForceExertedByY(all_Planets[i]);
        }
        return netFy;
    }

    public void update(double dt, double netFx, double netFy) {
        double netAx = netFx / this.mass;
        double netAy = netFy / this.mass;
        this.xxVel = this.xxVel + dt * netAx;
        this.yyVel = this.yyVel + dt * netAy;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        String imgPath = "./images/" + this.imgFileName;
        //StdDraw.clear();
        StdDraw.picture(this.xxPos, this.yyPos, imgPath);
    }
}
