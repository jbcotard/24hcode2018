package org.mixiteam.daycode.antseed.model;

import org.junit.Test;
import org.mixiteam.daycode.antseed.Position;

import java.io.IOException;

public class GetOverPassTest {

    @Test
    public void test() {
       Position depart=new Position("47.9844782", "0.2415538", null);

		Position arrivee=new Position( "47.99026", "0.23991", null);

        try {
            System.out.printf("" +  GetOverPass.auth(depart, arrivee) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
