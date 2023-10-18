package utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {
	
	private static Random rnd = new Random();
	
	public static <T> T extraire (List <T> liste) {
		int randomElem = rnd.nextInt(liste.size());
		return liste.remove(randomElem);
	}
	
	public static <T> T extraireIterator (List <T> liste) {
		int randomI = rnd.nextInt(liste.size());
		ListIterator <T> iter = liste.listIterator(randomI);
		T elem = iter.next();
		iter.remove();
		return elem;
	}
	
	public static <T> List <T> melanger (List <T> liste) {
		List <T> listeMelange = new LinkedList<>();
		while (!liste.isEmpty()) {
			listeMelange.add(extraire(liste));
		}
		return listeMelange;
	}
	
	public static <T> boolean verifierMelange (List <T> liste1, List <T> liste2) {
		for (T elem : liste1) {
			if (Collections.frequency(liste1, elem) != Collections.frequency(liste2, elem)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List <T> rassembler (List <T> liste) {
		return liste.stream().sorted().toList();
	}
	
	public static <T> boolean verifierRassemblement(List <T> liste) {
		List <T> parcours = new LinkedList<>();
		Iterator <T> iter = liste.iterator();
		if (!iter.hasNext()) return true;
		
		T dernier = iter.next();
		while (iter.hasNext()) {
			T nextElem = iter.next();
			
			if (parcours.contains(nextElem)) {
				return false;
			}
			
			if (!nextElem.equals(dernier)) {
				parcours.add(dernier);
				dernier = nextElem;
			}
		}
		return true;
	}
		
}
