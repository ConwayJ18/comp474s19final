package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.scorekeeper.model.graphics.GraphicsImpl;

import javax.swing.*;
import java.awt.*;

class GraphicsTest {
	GraphicsImpl GH = new GraphicsImpl();

	@Test
	void frame_test() {
		GH.start();
		assertEquals("Quidditch Scorekeeper", GH.frame.getTitle());     //test frame title
		assertEquals(800, GH.frame.getHeight());     //test frame height
		assertEquals(1450, GH.frame.getWidth());     //test frame width
		Color frame_background;
		frame_background = new Color(153, 153, 153);
		assertEquals(frame_background, GH.frame.getContentPane().getBackground());     //test frame background color

	}

    @Test
	void timer_test() {
		GH.start();
		Color timer_background;
		timer_background = new Color(243, 243, 243);
		assertEquals(timer_background, GH.timer.getBackground());     //test timer background color
		assertEquals(425, GH.timer.getX());     //timer position test
		assertEquals(25, GH.timer.getY());     //timer position test
		assertEquals(600, GH.timer.getWidth());     //test timer width
		assertEquals(150, GH.timer.getHeight());     //test timer height

	}
}
