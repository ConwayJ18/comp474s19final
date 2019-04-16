package test;

import static org.junit.jupiter.api.Assertions.*;

import com.scorekeeper.model.graphics.QTextField;
import org.junit.jupiter.api.Test;

import javax.swing.text.PlainDocument;
import java.awt.*;

class QTextFieldTest {

	QTextField A = new QTextField();
	QTextField B = new QTextField("text");
	QTextField C = new QTextField(1);
	QTextField D = new QTextField("text", 2);
	QTextField E = new QTextField("text", 5, 5, 5, 5);
	QTextField F = new QTextField(3, 5, 5, 5, 5);
	QTextField H = new QTextField("text", 4, 5, 5, 5, 5);

	@Test
	void A_test() {
		assertEquals("", A.getText());

	}

	@Test
	void B_test() {
		assertEquals("text", B.getText());

	}

	@Test
	void C_test() {
		Color type1_background = new Color(243, 243, 243);
		assertEquals(type1_background, C.getBackground());     //test background color setting for type1
		assertEquals(QTextField.CENTER, C.getHorizontalAlignment());     //test horizontal alignment setting for type1
		assertNull(C.getBorder());     //test border setting
		assertTrue(C.isVisible());     //test visibility setting
		assertEquals("MarkerFelt-Wide", C.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, C.getFont().getStyle());     //test font style
		assertEquals(126, C.getFont().getSize());     //test font size
	}

	@Test
	void D_test() {
		Color type2_background = new Color(243, 243, 243);
		assertEquals(type2_background, D.getBackground());     //test background color setting for type2
		assertEquals(QTextField.CENTER, D.getHorizontalAlignment());     //test horizontal alignment setting for type2
		assertNull(D.getBorder());     //test border setting
		assertTrue(D.isVisible());     //test visibility setting
		assertEquals("text", D.getText());     //test text field setting
		assertEquals("MarkerFelt-Wide", D.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, D.getFont().getStyle());     //test font style
		assertEquals(256, D.getFont().getSize());     //test font size
	}

	@Test
	void E_test() {
		assertEquals("text", E.getText());     //test text field setting
		assertEquals(5, E.getX());
		assertEquals(5, E.getY());
		assertEquals(5, E.getWidth());
		assertEquals(5, E.getHeight());     //test position and dimension of QTextField
	}

	@Test
	void F_test() {
		Color type3_background = new Color(243, 243, 243);
		assertEquals(type3_background, F.getBackground());     //test background color setting for type3
		assertEquals(QTextField.CENTER, F.getHorizontalAlignment());     //test horizontal alignment setting for type3
		assertNull(F.getBorder());     //test border setting
		assertTrue(F.isVisible());     //test visibility setting
		assertEquals("MarkerFelt-Wide", F.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, F.getFont().getStyle());     //test font style
		assertEquals(48, F.getFont().getSize());     //test font size
		assertEquals(5, F.getX());
		assertEquals(5, F.getY());
		assertEquals(5, F.getWidth());
		assertEquals(5, F.getHeight());     //test position and dimension of QTextField
	}


	@Test
	void H_test() {

		Color type4_background = new Color(243, 243, 243);
		assertEquals(type4_background, H.getBackground());     //test background color setting for type4
		assertEquals(QTextField.CENTER, H.getHorizontalAlignment());     //test horizontal alignment setting for type4
		assertNull(H.getBorder());     //test border setting
		assertTrue(H.isVisible());     //test visibility setting
		assertEquals("text", H.getText());     //test text field setting
		assertEquals("MarkerFelt-Wide", H.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, H.getFont().getStyle());     //test font style
		assertEquals(72, H.getFont().getSize());     //test font size
		assertEquals(5, H.getX());
		assertEquals(5, H.getY());
		assertEquals(5, H.getWidth());
		assertEquals(5, H.getHeight());     //test position and dimension of QTextField

	}

	@Test
	void setBounds_test() {
		A.setBounds(5,5,5,5,5);
		assertEquals(5, A.getX());
		assertEquals(5, A.getY());
		assertEquals(5, A.getWidth());
		assertEquals(5, A.getHeight());
		assertEquals(5, A.getFont().getSize());
		E.setBounds(10,10,10,10);
		assertEquals(10, E.getX());
		assertEquals(10, E.getY());
		assertEquals(10, E.getWidth());
		assertEquals(10, E.getHeight());

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
		assertEquals("MarkerFelt-Wide", L.getFont().getName());     //test font name
		assertEquals(Font.PLAIN, L.getFont().getStyle());     //test font style
		assertEquals(24, L.getFont().getSize());     //test font size
		assertEquals(5, L.getX());
		assertEquals(5, L.getY());
		assertEquals(5, L.getWidth());
		assertEquals(5, L.getHeight());     //test position and dimension of QTextField
	}
}