public class Planet {
	public double xxPos; 		//current x position.
	public double yyPos; 		//current y position.
	public double xxVel; 		//current velocity in the x direction.
	public double yyVel; 		//current velocity in the y direction.
	public double mass;  		//mass of the planet.
	public String imgFileName;  //filename of the image in the images directory that depicts the planet.

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		//compute the distance between this planet and planet p.
		return Math.sqrt((p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos));
	}

	public double calcForceExertedBy(Planet p){
		//compute the force exerted on this planet by the given planet p.
		return (6.67 * Math.pow(10, -11)) * mass * p.mass / (calcDistance(p) * calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		//compute the x-component fX of a force exerted on the planet.
		return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		//compute the y-component fY of a force exerted on the planet.
		return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
	}


	public double calcNetForceExertedByX(Planet[] allplanets){
		//compute the Fnet X exerted by all planets except itself .
		double force = 0;
		int index = 0;
		while (index < allplanets.length) {
			if(! this.equals(allplanets[index])) {
				force += calcForceExertedByX(allplanets[index]);
			}
			index += 1;
		}
	
		return force;
	}

	public double calcNetForceExertedByY(Planet[] allplanets){
		//compute the Fnet Y exerted by all planets except itself .
		double force = 0;
		int index = 0;
		while (index < allplanets.length) {
			if(! this.equals(allplanets[index])) {
				force += calcForceExertedByY(allplanets[index]);
			}
			index += 1;
		}
	
		return force;
	}

	
	public void update(double dt, double fx, double fy){
		//update change in the planet's velocity and position in period of time.
		double ax = fx / mass;
		double ay = fy / mass;
		xxVel = xxVel + ax * dt;
		yyVel = yyVel + ay * dt;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;	
	}

	
	public void draw(){
		//draw the plant at its current position.
		 StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
		 
	}
} 