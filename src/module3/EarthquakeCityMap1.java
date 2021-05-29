package module3;

import java.util.List;
import java.util.ArrayList;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap1 extends PApplet
{
private UnfoldingMap map;// Private variable map of type UnfoldingMap

public void setup() {
	size(950,600,OPENGL);// Size of the canvas, with width 950 and height 600 pixels
	map=new UnfoldingMap (this,125,50,700,500,new Google.GoogleMapProvider());//parameter information, size(width-700, height-500)
	//Since map is located on the canvas , we need to provide the coordinates, x and y, last parameter says from where the map learns the data or information about various countries
	//it is  a map provider
	map.zoomLevel(2);
	MapUtils.createDefaultEventDispatcher(this, map);

	
	List<PointFeature> bigEqs = new ArrayList<PointFeature>();
	 Location valLoc = new Location(-38.14f,-73.03f);   
	 Feature valEq = new PointFeature(valLoc);
	 bigEqs.add((PointFeature) valEq);
	 valEq.addProperty("title", "Valvidivia,Chile");
	 valEq.addProperty("magnitude","9.5");
	 valEq.addProperty("date", "May 22,1960");
	 valEq.addProperty("year", "1960");
	      
	 Location valLoc1 = new Location(60.59f,-147.848f);
	 Feature alaskaEq = new PointFeature(valLoc1);
	 bigEqs.add((PointFeature) alaskaEq);
	 alaskaEq.addProperty("title", "Prince William Sound ,Southern Alaska");
	 alaskaEq.addProperty("magnitude","9.2");
	 alaskaEq.addProperty("date", "March 28,1964");
	 alaskaEq.addProperty("year", "1964");
	   
	 Location valLoc2 = new Location(3.30f,95.98f);
	 Feature sumantraEq = new PointFeature(valLoc2);
	 bigEqs.add((PointFeature) sumantraEq);
	 sumantraEq.addProperty("title", "Sumatra-Andaman Islands ");
	 sumantraEq.addProperty("magnitude", " 9.1");
	 sumantraEq.addProperty("date", " December 26,2004");
	 sumantraEq.addProperty("year", " 2004");
	   
	   
	 Location valLoc3 = new Location(38.30f,142.37f);
	 Feature japanEq = new PointFeature(valLoc3);
	 bigEqs.add((PointFeature) japanEq);
	 japanEq.addProperty("title", "Tohuku(Eastern coast of Honshu) ,Japan");
	 japanEq.addProperty("magnitude", " 9.1");
	 japanEq.addProperty("date", "November 3 , 2011 ");
	 japanEq.addProperty("year", "2011 ");
	   
	 Location valLoc4 = new Location(52.62f,159.78f);
	 Feature kamchatkaEq = new PointFeature(valLoc4);
	 bigEqs.add((PointFeature) kamchatkaEq);
	 kamchatkaEq.addProperty("title", "Kamchatka,Russia ");
	 kamchatkaEq.addProperty("magnitude", " 9.0");
	 kamchatkaEq.addProperty("date", "April 24,1952 ");
	 kamchatkaEq.addProperty("year", " 1952");
	 
	 List<Marker> markers = new ArrayList<Marker>();
	 for(PointFeature eq:bigEqs) {
	       markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
	       
	  }  
	     int yellow = color(255,255,0);
		 int gray = color(150,150,150);
		 for(Marker mk:markers) {
			  if((int) mk.getProperty("magitude") > 9.0) {
		         mk.setColor(color(255,255,0));
		     }
			  else {
		         mk.setColor(color(150,150,150));
		     }
		     map.addMarker(mk);
		 }
	 for(Marker mk:markers) {
		 map.addMarker(mk);
	 }
}

public void draw() {
	background(225);
	map.draw();
	addkey();
	
}

private void addkey() {
	// TODO Auto-generated method stub
	
}

	/*public class ParseFeed{
		public static List<PointFeature>parseEarthquake (PApplet p, String significant_month.atom){
			
		}
	}*/
}
