package org.mixiteam.daycode.antseed.model;

import org.junit.Test;
import org.mixiteam.daycode.antseed.Position;

import java.io.IOException;

public class GetOverPassTest {

    @Test
    public void test() {
    	Position positionFourmis = new Position("47.9843764", "0.2416894");
		Position positionGraine = new Position("47.9878235", "0.2475570");
		
        try {
            System.out.printf("" +  GetOverPass.getWayOverPass(positionFourmis, positionGraine) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
