public class NBody {
	
	public static double readRadius(String filename) {
		In in = new In(filename);
		int numberOfPlanets = in.readInt();
		return in.readDouble();	
	}

	public static Planet[] readPlanets(String filename){
		int index = 0;
		In in = new In(filename);
		int numberOfPlanets = in.readInt();
		Planet [] allPlanets = new Planet[numberOfPlanets];
		double radius = in.readDouble();
		while (index < numberOfPlanets) {
			double pX = in.readDouble();
			double pY = in.readDouble();
			double Vx = in.readDouble();
			double Vy = in.readDouble();
			double mass = in.readDouble();
			String image = in.readString();
			allPlanets[index] = new Planet(pX, pY, Vx, Vy, mass, image);
			index += 1;
		}
		return allPlanets;
	}

	public static void main(String[] args) {
	 	double T = Double.parseDouble(args[0]);
	 	double dt = Double.parseDouble(args[1]);
	 	String filename = args[2];
	 	
	 	double radius = readRadius(filename);
	 	Planet[] planets = readPlanets(filename);
	 	
	 	StdAudio.play("audio/2001.mid");
	 	
	 	StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		
		int index = 0;
		while(index < planets.length) {
			planets[index].draw();
			index += 1;
		}
	 	
	 	double time = 0;
	 	while (time <= T) {
	 		double[] xForces = new double[planets.length];
	 		double[] yForces = new double[planets.length];
	 	
	 		index = 0;
	 		while (index < planets.length) {
	 			xForces[index] = planets[index].calcNetForceExertedByX(planets);
	 			yForces[index] = planets[index].calcNetForceExertedByY(planets);
	 			index += 1;
	 		
	 		}
	 		index = 0;
	 		while(index < planets.length) {
	 			planets[index].update(dt, xForces[index], yForces[index]);
	 			index += 1;
	 		}
	 		
	 		StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");
			
			index = 0;
			while(index < planets.length) {
				planets[index].draw();
				index += 1;
			}
			
			StdDraw.show(10);
			time += dt;
	 	}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
		}		

	 } 
}