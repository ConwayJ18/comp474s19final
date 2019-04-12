package test;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.QTextField;
import org.junit.jupiter.api.Test;

import javax.swing.text.PlainDocument;
import java.awt.*;

class QTextFieldTest {
	QTextField TX = new QTextField();

	@Test
	void type1_test() {
		QTextField H = new QTextField("text", 1, 5, 5, 5, 5);
		Color type1_background = new Color(243, 243, 243);
		assertEquals(type1_background, H.getBackground());     //test background color setting for type1
		assertEquals(QTextField.CENTER, H.getHorizontalAlignment());     //test horizontal alignment setting for type1
		assertNull(H.getBorder());     //test border setting
		assertTrue(H.isVisible());     //test visibility setting
		assertEquals("text", H.getText());     //test text field setting
		assertEquals("Dialog",  H.getFont().getFamily());     //test font family
		assertEquals("MarkerFelt-Wide", H.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, H.getFont().getStyle());     //test font style
		assertEquals(126, H.getFont().getSize());     //test font size
		assertEquals(5, H.getX());
		assertEquals(5, H.getY());
		assertEquals(5, H.getWidth());
		assertEquals(5, H.getHeight());     //test position and dimension of QTextField

	}

	@Test
	void type2_test() {
		QTextField I = new QTextField("text", 2, 5, 5, 5, 5);
		Color type2_background = new Color(243, 243, 243);
		assertEquals(type2_background, I.getBackground());     //test background color setting for type2
		assertEquals(QTextField.CENTER, I.getHorizontalAlignment());     //test horizontal alignment setting for type2
		assertNull(I.getBorder());     //test border setting
		assertTrue(I.isVisible());     //test visibility setting
		assertEquals("text", I.getText());     //test text field setting
		assertEquals("Dialog",  I.getFont().getFamily());     //test font family
		assertEquals("MarkerFelt-Wide", I.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, I.getFont().getStyle());     //test font style
		assertEquals(256, I.getFont().getSize());     //test font size
		assertEquals(5, I.getX());
		assertEquals(5, I.getY());
		assertEquals(5, I.getWidth());
		assertEquals(5, I.getHeight());     //test position and dimension of QTextField
	}

	@Test
	void type3_test() {
		QTextField J = new QTextField("text", 3, 5, 5, 5, 5);
		Color type3_background = new Color(243, 243, 243);
		assertEquals(type3_background, J.getBackground());     //test background color setting for type3
		assertEquals(QTextField.CENTER, J.getHorizontalAlignment());     //test horizontal alignment setting for type3
		assertNull(J.getBorder());     //test border setting
		assertTrue(J.isVisible());      //test visibility setting
		assertEquals("text", J.getText());     //test text field setting
		assertEquals("Dialog",  J.getFont().getFamily());     //test font family
		assertEquals("MarkerFelt-Wide", J.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, J.getFont().getStyle());     //test font style
		assertEquals(48, J.getFont().getSize());     //test font size
		assertEquals(5, J.getX());
		assertEquals(5, J.getY());
		assertEquals(5, J.getWidth());
		assertEquals(5, J.getHeight());     //test position and dimension of QTextField
	}

	@Test
	void type4_test() {
		QTextField K = new QTextField("text", 4, 5, 5, 5, 5);
		Color type4_background = new Color(243, 243, 243);
		assertEquals(type4_background, K.getBackground());     //test background color setting for type4
		assertEquals(QTextField.CENTER, K.getHorizontalAlignment());     //test horizontal alignment setting for type4
		assertNull(K.getBorder());     //test border setting
		assertTrue(K.isVisible());     //test visibility setting
		assertEquals("text", K.getText());     //test text field setting
		assertEquals("Dialog",  K.getFont().getFamily());     //test font family
		assertEquals("MarkerFelt-Wide", K.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, K.getFont().getStyle());     //test font style
		assertEquals(72, K.getFont().getSize());     //test font size
		assertEquals(5, K.getX());
		assertEquals(5, K.getY());
		assertEquals(5, K.getWidth());
		assertEquals(5, K.getHeight());     //test position and dimension of QTextField
	}

	@Test
	void type5_test() {
		QTextField L = new QTextField("text", 5, 5, 5, 5, 5);
		Color type5_background = new Color(243, 243, 243);
		assertEquals(type5_background, L.getBackground());     //test background color setting for type5
		assertEquals(QTextField.CENTER, L.getHorizontalAlignment());     //test horizontal alignment setting for type5
		assertNull(L.getBorder());     //test border setting
		assertTrue(L.isVisible());     //test visibility setting
		assertEquals("text", L.getText());     //test text field setting
		assertEquals("Dialog",  L.getFont().getFamily());     //test font family
		assertEquals("MarkerFelt-Wide", L.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, L.getFont().getStyle());     //test font style
		assertEquals(24, L.getFont().getSize());     //test font size
		assertEquals(5, L.getX());
		assertEquals(5, L.getY());
		assertEquals(5, L.getWidth());
		assertEquals(5, L.getHeight());     //test position and dimension of QTextField
	}
}
