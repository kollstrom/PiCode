package c3pio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimulatorTest {

    @Test
    public void testCalculatePermille() throws Exception {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("ert");
        stringArrayList.add("wer 34 wer");
        stringArrayList.add("94 wer");
        stringArrayList.add("95");
        stringArrayList.add("-45 45");
        stringArrayList.add("-45 96");
        double permille = Simulator.calculatePermille(stringArrayList);
        assertEquals(0.0095, permille, 0.0000000001);
    }

    @Test
    public void testParseToInt() throws Exception {
        assertEquals(94, Simulator.parseToInt("94 wer"));
        assertEquals(95, Simulator.parseToInt("95"));
        assertEquals(45, Simulator.parseToInt(",45"));
        assertEquals(-1, Simulator.parseToInt("-45 96"));
        assertEquals(34, Simulator.parseToInt("wer 34 wer"));
        assertEquals(-1, Simulator.parseToInt("ert"));
    }
}