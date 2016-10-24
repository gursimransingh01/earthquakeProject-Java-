package week2;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap extends PApplet{
	
	private UnfoldingMap map;
	
	public void setup() {
		size(950,600,OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.RoadProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		Location loc = new Location(-38.14f, -73.03f);
		
		Feature ftr = new PointFeature(loc);
		ftr.addProperty("title", "Valdivia, Chile");
		ftr.addProperty("magnitude", "9.5");
		ftr.addProperty("date", "May 22, 1960");
		ftr.addProperty("year", "1960");
		
		System.out.println(ftr.getProperties());
		
		Marker marker = new SimplePointMarker(loc, ftr.getProperties());
		
		int red = color(255,0,0);
		marker.setColor(red);
		map.addMarker(marker);
	}
	
	public void draw() {
		background(10);
		map.draw();
		
	}

}
