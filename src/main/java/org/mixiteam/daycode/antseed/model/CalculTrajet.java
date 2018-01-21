package org.mixiteam.daycode.antseed.model;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mixiteam.daycode.antseed.model.json.Annotations;
import org.mixiteam.daycode.antseed.model.json.Element;
import org.mixiteam.daycode.antseed.model.json.Intersections;
import org.mixiteam.daycode.antseed.model.json.Legs;
import org.mixiteam.daycode.antseed.model.json.Localisation;
import org.mixiteam.daycode.antseed.model.json.Routes;
import org.mixiteam.daycode.antseed.model.json.Steps;
public class CalculTrajet {
	
	public static List<Element> getNoeuds(String s)
	{
		List<Element> elements = new ArrayList<Element>();
		System.out.println(s);
		JSONObject obj = new JSONObject(s);
		JSONArray obj_elements =obj.getJSONArray("elements");
		for(int i=0 ; i< obj_elements.length(); i++){
			JSONObject obj4 = obj_elements.getJSONObject(i); 
			Element e = new Element();
			if (obj4.has("id")) e.setId(obj4.getInt("id"));
			if (obj4.has("lat")) e.setLat(obj4.getDouble("lat"));
			if (obj4.has("lon")) e.setLon(obj4.getDouble("lon"));
			if (obj4.has("type")) e.setType(obj4.getString("type"));
			if (obj4.has("nodes"))
			{
				List<String> list_nodes = new ArrayList<String>();
				JSONArray obj_nodes =obj4.getJSONArray("nodes");
				for(int j=0 ; j< obj_nodes.length(); j++){
				
					String obj_n = obj_nodes.get(j).toString();
					list_nodes.add(obj_n);
				}
				e.setNodes(list_nodes);
			}
			if (obj4.has("tags"))
			{
				HashMap<String, String> map = new HashMap<String, String>();
				Map<String,Object> obj_tags = obj4.getJSONObject("tags").toMap();
				for(Map.Entry<String, Object> entry : obj_tags.entrySet()) {
				    String key = entry.getKey();
				    String value = entry.getValue().toString();
				    map.put(key, value);
				}
				e.setTags(map);
			}
			elements.add(e);
		}
		return elements;
	}

	public static Routes getTrajet(String s)
	{
		Routes route = new Routes();
		try{
			JSONObject obj = new JSONObject(s);
			List<Legs> liste_legs = new ArrayList<Legs>();
			JSONArray obj_route =obj.getJSONArray("routes");

			for(int i=0 ; i< obj_route.length(); i++){   // iterate through jsonArray 
				JSONObject obj4 = obj_route.getJSONObject(i);  // get jsonObject @ i position 
				JSONArray obj_leg = (JSONArray) obj4.get("legs");

				for(int j=0 ; j< obj_leg.length(); j++){
					Legs legs = new Legs();
					JSONObject obj5 = obj_leg.getJSONObject(j);
					JSONObject obj_annot = (JSONObject) obj5.get("annotation");
					JSONArray obj_nodes = (JSONArray) obj_annot.get("nodes");
					Annotations annotation = new Annotations();
					List<String> n = new ArrayList<String>();
					for(int k=0 ; k< obj_nodes.length(); k++)
					{
						String obj_loc = obj_nodes.get(k).toString();
						n.add(obj_loc);
					}
					annotation.setNodes(n);
					legs.setAnnotations(annotation);
					List<Steps> steps = new ArrayList<Steps>();
					JSONArray obj_steps = (JSONArray) obj5.get("steps");
					for(int k=0 ; k< obj_steps.length(); k++)
					{
						Steps step = new Steps();
						JSONObject obj6 = obj_steps.getJSONObject(k);
						JSONArray obj_inter = (JSONArray) obj6.get("intersections");
						List<Intersections> listeInter = new ArrayList<Intersections>();
						for(int l=0 ; l< obj_inter.length(); l++)
						{
							Intersections intersection = new Intersections();
							JSONObject obj7 = obj_inter.getJSONObject(l);
							JSONArray obj_loc = (JSONArray) obj7.get("location");

							List<Localisation> listeloc = new ArrayList<Localisation>();
							Localisation localisations = new Localisation();
							localisations.setLatitude(obj_loc.get(0).toString());
							localisations.setLongitude(obj_loc.get(1).toString());
							listeloc.add(localisations);
							intersection.setLocalisations(listeloc);

							listeInter.add(intersection);
						}
						step.setIntersections(listeInter);
						Double obj_duration = (Double) obj6.get("duration");
						step.setDuration(obj_duration);
						steps.add(step);
					}

					legs.setSteps(steps);
					liste_legs.add(legs);
				}

			}
			route.setLegs(liste_legs);

		}catch(Exception pe){

			System.out.println(pe);
		}
		return route;
	}

}
