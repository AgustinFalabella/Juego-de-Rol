package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Dado {

	private JLabel lblAtributoVida;
	private JLabel lblAtributoDaño;
	private JLabel lblAtributoEspecial;
	private JLabel lblAtributoDebil;
	private JLabel lblAtributoVidaE;
	private JLabel lblAtributoDañoE;
	private JLabel lblAtributoEspecialE;
	private JLabel lblAtributoDebilE;
	private JLabel lblNombreEnemigo;
	private JLabel lblImagenE;

	private boolean presionado = false;

	String ruta = "src/imagenes/";
	String rutap = "src/personajes/";
	String rutae = "src/enemigos/";
	String danio = "50";

	int tiro;
	int tiroE;
	int daño = 50;

	public JFrame frame;

	public void mago() {

		String vida = "3500";
		String especialidad = "magico";
		String debilidad = "fisico";

		lblAtributoVida.setText(vida);
		lblAtributoDaño.setText(danio);
		lblAtributoEspecial.setText(especialidad);
		lblAtributoDebil.setText(debilidad);

	}

	public void bestia() {

		String vida = "3500";
		String especialidad = "animal";
		String debilidad = "magico";

		lblAtributoVida.setText(vida);
		lblAtributoDaño.setText(danio);
		lblAtributoEspecial.setText(especialidad);
		lblAtributoDebil.setText(debilidad);

	}

	public void guerrero() {

		String vida = "3500";
		String especialidad = "fisico";
		String debilidad = "animal";

		lblAtributoVida.setText(vida);
		lblAtributoDaño.setText(danio);
		lblAtributoEspecial.setText(especialidad);
		lblAtributoDebil.setText(debilidad);
	}

	public void orco() {
		String nombre = "Orco";
		String vida = "500";
		String especialidad = "-";
		String debilidad = "-";

		lblNombreEnemigo.setText(nombre);
		lblAtributoVidaE.setText(vida);
		lblAtributoDañoE.setText(danio);
		lblAtributoEspecialE.setText(especialidad);
		lblAtributoDebilE.setText(debilidad);
	}

	public void jefe() {
		String nombre = "Jefe Final";
		String vida = "4500";

		
		String especialidad = null;
		String debilidad= null;
		
		if (lblAtributoEspecial.getText().equals("magico")) {
			especialidad = "fisico";
			debilidad = "fisico";
		}
		if (lblAtributoEspecial.getText().equals("fisico")) {
			especialidad = "animal";
			debilidad = "animal";

		}
		if (lblAtributoEspecial.getText().equals("animal")) {
			especialidad = "magico";
			debilidad = "magico";
		} else {

		}

		lblNombreEnemigo.setText(nombre);
		lblAtributoVidaE.setText(vida);
		lblAtributoDañoE.setText(danio);
		lblAtributoEspecialE.setText(especialidad);
		lblAtributoDebilE.setText(debilidad);
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dado windows = new Dado();
					windows.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		  JOptionPane.showMessageDialog(frame,
		  "Bienvenido al juego de rol. Las reglas son las siguientes:\n" +
		  "Deberas elegir un personaje con el que derrotar un enemigo comun para poder llegar al Jefe Final.\n"
		  + "-El Mago activa su poder especial con el número 1.\n" +
		  "-El Guerrero activa su poder especial con el número 3.\n" +
		  "-La Bestia activa su poder especial con el número 5.\n" +
		  "-El Jefe Final es inmune a ataques especiales y golpea siempre con la debilidad de tu personaje"
		  );
		  
		  JOptionPane.showMessageDialog(
		  frame,"Elige un personaje y avanza en tu aventura");
		

		frame = new JFrame();
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setBounds(700, 300, 766, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel tirar = new JLabel("");
		tirar.setBorder(new LineBorder(new Color(0, 0, 0)));
		tirar.setBounds(273, 179, 44, 41);
		frame.getContentPane().add(tirar);

		JButton btnTurno = new JButton("Tirar");
		btnTurno.setEnabled(false);
		btnTurno.setBounds(249, 231, 89, 23);
		frame.getContentPane().add(btnTurno);

		JLabel lblVidaBatalla = new JLabel();
		lblVidaBatalla.setFont(new Font("Verdana", Font.BOLD, 15));
		lblVidaBatalla.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVidaBatalla.setBounds(249, 32, 89, 34);
		frame.getContentPane().add(lblVidaBatalla);

		JLabel lblDanioOcasionado = new JLabel("");
		lblDanioOcasionado.setFont(new Font("Verdana", Font.BOLD, 15));
		lblDanioOcasionado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDanioOcasionado.setBounds(249, 77, 89, 34);
		frame.getContentPane().add(lblDanioOcasionado);

		JButton btnTurnoE = new JButton("OK");
		btnTurnoE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tirar.setIcon(null);
				btnTurno.setEnabled(true);
				btnTurnoE.setEnabled(false);
			}
		});
		btnTurnoE.setEnabled(false);
		btnTurnoE.setBounds(415, 231, 89, 23);
		frame.getContentPane().add(btnTurnoE);

		JLabel lblVidaEnemigo = new JLabel("");
		lblVidaEnemigo.setFont(new Font("Verdana", Font.BOLD, 15));
		lblVidaEnemigo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVidaEnemigo.setBounds(415, 32, 89, 34);
		frame.getContentPane().add(lblVidaEnemigo);

		JLabel lblDanioOcasionadoE = new JLabel("");
		lblDanioOcasionadoE.setFont(new Font("Verdana", Font.BOLD, 15));
		lblDanioOcasionadoE.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDanioOcasionadoE.setBounds(415, 77, 89, 34);
		frame.getContentPane().add(lblDanioOcasionadoE);

		lblNombreEnemigo = new JLabel("");
		lblNombreEnemigo.setBorder(null);
		lblNombreEnemigo.setBounds(640, 2, 98, 30);
		frame.getContentPane().add(lblNombreEnemigo);

		JLabel tirarE = new JLabel("");
		tirarE.setBorder(new LineBorder(new Color(0, 0, 0)));
		tirarE.setBounds(437, 179, 44, 41);
		frame.getContentPane().add(tirarE);

		JLabel lblImagenP = new JLabel("");
		lblImagenP.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagenP.setBounds(25, 123, 98, 106);
		frame.getContentPane().add(lblImagenP);

		JButton btnMago = new JButton("Mago");
		btnMago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon(rutap + "mago.jpg");

				Icon i = new ImageIcon(image.getImage().getScaledInstance(lblImagenP.getWidth(), lblImagenP.getHeight(),
						Image.SCALE_DEFAULT));

				lblImagenP.setIcon(i);

				mago();

				presionado = true;

			}
		});
		btnMago.setBounds(31, 32, 89, 23);
		frame.getContentPane().add(btnMago);

		JButton btnGuerrero = new JButton("Guerrero");
		btnGuerrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon(rutap + "guerrero.jpg");

				Icon i = new ImageIcon(image.getImage().getScaledInstance(lblImagenP.getWidth(), lblImagenP.getHeight(),
						Image.SCALE_DEFAULT));

				lblImagenP.setIcon(i);

				guerrero();
				presionado = true;
			}
		});
		btnGuerrero.setBounds(31, 59, 89, 23);
		frame.getContentPane().add(btnGuerrero);

		JButton btnBestia = new JButton("Bestia");
		btnBestia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon image = new ImageIcon(rutap + "bestia.jpg");

				Icon i = new ImageIcon(image.getImage().getScaledInstance(lblImagenP.getWidth(), lblImagenP.getHeight(),
						Image.SCALE_DEFAULT));

				lblImagenP.setIcon(i);

				bestia();
				presionado = true;
			}
		});
		btnBestia.setBounds(31, 85, 89, 23);
		frame.getContentPane().add(btnBestia);

		JLabel lblElige = new JLabel("Elige tu personaje");
		lblElige.setBorder(null);
		lblElige.setBounds(25, 2, 128, 30);
		frame.getContentPane().add(lblElige);

		JLabel lblVida = new JLabel("PH");
		lblVida.setFont(new Font("Verdana", Font.BOLD, 15));
		lblVida.setBounds(185, 47, 38, 14);
		frame.getContentPane().add(lblVida);

		JButton btnElegir = new JButton("Confirmar");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (presionado == true) {

					btnBestia.setEnabled(false);
					btnGuerrero.setEnabled(false);
					btnMago.setEnabled(false);
					btnTurno.setEnabled(true);

					btnElegir.setEnabled(false);

					JOptionPane.showMessageDialog(btnElegir, "¡Mucha suerte!");
				} else {
					JOptionPane.showMessageDialog(btnElegir, "No has seleccionado un personaje.");
				}

				lblVidaBatalla.setText(String.valueOf(lblAtributoVida.getText()));

				ImageIcon image = new ImageIcon(rutae + "orco.jpg");

				Icon i = new ImageIcon(image.getImage().getScaledInstance(lblImagenE.getWidth(), lblImagenE.getHeight(),
						Image.SCALE_DEFAULT));

				lblImagenE.setIcon(i);

				orco();
				lblVidaEnemigo.setText(String.valueOf(lblAtributoVidaE.getText()));

			}
		});
		btnElegir.setBounds(25, 240, 108, 23);
		frame.getContentPane().add(btnElegir);

		JLabel lblAtributo = new JLabel("Vida");
		lblAtributo.setBounds(133, 123, 33, 14);
		frame.getContentPane().add(lblAtributo);

		JLabel lblDaño = new JLabel("Da\u00F1o");
		lblDaño.setBounds(133, 148, 33, 14);
		frame.getContentPane().add(lblDaño);

		JLabel lblEspecialidad = new JLabel("Especial");
		lblEspecialidad.setBounds(133, 173, 80, 14);
		frame.getContentPane().add(lblEspecialidad);

		JLabel lblDebilidad = new JLabel("Debil");
		lblDebilidad.setBounds(133, 198, 62, 14);
		frame.getContentPane().add(lblDebilidad);

		lblAtributoVida = new JLabel("");
		lblAtributoVida.setBounds(176, 123, 38, 14);
		frame.getContentPane().add(lblAtributoVida);

		lblAtributoDaño = new JLabel("");
		lblAtributoDaño.setBounds(176, 148, 38, 14);
		frame.getContentPane().add(lblAtributoDaño);

		lblAtributoEspecial = new JLabel("");
		lblAtributoEspecial.setBounds(185, 173, 62, 14);
		frame.getContentPane().add(lblAtributoEspecial);

		lblAtributoDebil = new JLabel("");
		lblAtributoDebil.setBounds(185, 198, 62, 14);
		frame.getContentPane().add(lblAtributoDebil);

		JLabel lblHit = new JLabel("Da\u00F1o");
		lblHit.setFont(new Font("Verdana", Font.BOLD, 15));
		lblHit.setBounds(185, 81, 62, 30);
		frame.getContentPane().add(lblHit);

		lblImagenE = new JLabel("");
		lblImagenE.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagenE.setBounds(640, 114, 98, 106);
		frame.getContentPane().add(lblImagenE);

		JLabel lblAtributo_1 = new JLabel("Vida");
		lblAtributo_1.setBounds(597, 123, 33, 14);
		frame.getContentPane().add(lblAtributo_1);

		JLabel lblDaño_1 = new JLabel("Da\u00F1o");
		lblDaño_1.setBounds(597, 148, 33, 14);
		frame.getContentPane().add(lblDaño_1);

		JLabel lblEspecialidad_1 = new JLabel("Especial");
		lblEspecialidad_1.setBounds(589, 173, 54, 14);
		frame.getContentPane().add(lblEspecialidad_1);

		JLabel lblDebilidad_1 = new JLabel("Debil");
		lblDebilidad_1.setBounds(597, 198, 62, 14);
		frame.getContentPane().add(lblDebilidad_1);

		lblAtributoVidaE = new JLabel("");
		lblAtributoVidaE.setBounds(549, 123, 38, 14);
		frame.getContentPane().add(lblAtributoVidaE);

		lblAtributoDañoE = new JLabel("");
		lblAtributoDañoE.setBounds(549, 148, 38, 14);
		frame.getContentPane().add(lblAtributoDañoE);

		lblAtributoEspecialE = new JLabel("");
		lblAtributoEspecialE.setBounds(549, 173, 62, 14);
		frame.getContentPane().add(lblAtributoEspecialE);

		lblAtributoDebilE = new JLabel("");
		lblAtributoDebilE.setBounds(549, 198, 62, 14);
		frame.getContentPane().add(lblAtributoDebilE);
		
		JLabel vs = new JLabel("vs");
		vs.setFont(new Font("Verdana", Font.BOLD, 15));
		vs.setBounds(370, 122, 46, 14);
		frame.getContentPane().add(vs);

		btnTurno.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Integer ph = Integer.parseInt(lblVidaEnemigo.getText());
				Integer phe = Integer.parseInt(lblVidaBatalla.getText());

				lblAtributoEspecial.getText();

				// tiro personaje
				tiro = 1 + (int) (Math.random() * 6);
				

				ImageIcon image = new ImageIcon(ruta + tiro + ".png");

				Icon icon = new ImageIcon(
						image.getImage().getScaledInstance(tirar.getWidth(), tirar.getHeight(), Image.SCALE_DEFAULT));

				tirar.setIcon(icon);
				tirarE.setIcon(null);

				int normal = tiro * daño;
				

				switch (lblAtributoEspecial.getText()) {

				case "magico":

					switch (tiro) {

					case 1:

						if (lblNombreEnemigo.getText().equals("Jefe Final")) {
							lblDanioOcasionado.setText(Integer.toString(normal));
							lblVidaEnemigo.setText(Integer.toString(ph - normal));
						}else {
							lblDanioOcasionado.setText(Integer.toString(500));
							lblVidaEnemigo.setText(Integer.toString(ph - 500));
						
						}
						break;

					case 2:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 3:
						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 4:
						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 5:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 6:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					}

					break;

				case "fisico":

					switch (tiro) {

					case 1:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));
						break;

					case 2:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 3:
						if (lblNombreEnemigo.getText().equals("Jefe Final")) {
							lblDanioOcasionado.setText(Integer.toString(normal));
							lblVidaEnemigo.setText(Integer.toString(ph - normal));
						}else {
							lblDanioOcasionado.setText(Integer.toString(500));
							lblVidaEnemigo.setText(Integer.toString(ph - 500));
						
						}

						break;
					case 4:
						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 5:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 6:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					}

					break;

				case "animal":
					switch (tiro) {

					case 1:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));
						break;

					case 2:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 3:
						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 4:
						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					case 5:

						if (lblNombreEnemigo.getText().equals("Jefe Final")) {
						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));
					}else {
						lblDanioOcasionado.setText(Integer.toString(500));
						lblVidaEnemigo.setText(Integer.toString(ph - 500));
					
					}

						break;
					case 6:

						lblDanioOcasionado.setText(Integer.toString(normal));
						lblVidaEnemigo.setText(Integer.toString(ph - normal));

						break;
					}

					break;
				}

				btnTurno.setEnabled(false);
				
				try {
					tiroE = 1 + (int) (Math.random() * 6);
					

					ImageIcon imagen = new ImageIcon(ruta + tiroE + ".png");

					Icon ic = new ImageIcon(imagen.getImage().getScaledInstance(tirarE.getWidth(), tirarE.getHeight(),
							Image.SCALE_DEFAULT));

					tirarE.setIcon(ic);

					// Thread.sleep(2*1000);
				} catch (Exception e1) {
					System.out.println(e1);
				}

				btnTurnoE.setEnabled(true);

				int normalE = tiroE * daño;
				if (lblNombreEnemigo.getText().equals("orco")) {
					switch (tiroE) {

					case 1:

						lblDanioOcasionadoE.setText(Integer.toString(normalE));
						lblVidaBatalla.setText(Integer.toString(phe - normalE));
						break;

					case 2:

						lblDanioOcasionadoE.setText(Integer.toString(normalE));
						lblVidaBatalla.setText(Integer.toString(phe - normalE));

						break;
					case 3:
						lblDanioOcasionadoE.setText(Integer.toString(normalE));
						lblVidaBatalla.setText(Integer.toString(phe - normalE));

						break;
					case 4:
						lblDanioOcasionadoE.setText(Integer.toString(normalE));
						lblVidaBatalla.setText(Integer.toString(phe - normalE));

						break;
					case 5:

						lblDanioOcasionadoE.setText(Integer.toString(normalE));
						lblVidaBatalla.setText(Integer.toString(phe - normalE));

						break;
					case 6:

						lblDanioOcasionadoE.setText(Integer.toString(normalE));
						lblVidaBatalla.setText(Integer.toString(phe - normalE));

						break;
					}
				} else {
					switch (lblAtributoEspecial.getText()) {

					case "magico":

						switch (tiroE) {

						case 1:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));
							break;

						case 2:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 3:
							lblDanioOcasionadoE.setText(Integer.toString(500));
							lblVidaBatalla.setText(Integer.toString(phe - 500));

							break;
						case 4:
							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 5:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 6:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						}

						break;

					case "fisico":

						switch (tiroE) {

						case 1:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));
							break;

						case 2:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 3:
							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 4:
							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 5:

							lblDanioOcasionadoE.setText(Integer.toString(500));
							lblVidaBatalla.setText(Integer.toString(phe - 500));

							break;
						case 6:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						}

						break;

					case "animal":
						switch (tiroE) {

						case 1:

							lblDanioOcasionadoE.setText(Integer.toString(500));
							lblVidaBatalla.setText(Integer.toString(phe - 500));
							break;

						case 2:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 3:
							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 4:
							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 5:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						case 6:

							lblDanioOcasionadoE.setText(Integer.toString(normalE));
							lblVidaBatalla.setText(Integer.toString(phe - normalE));

							break;
						}

						break;
					}

				}

				if (ph <= 0) {

					int contador = 3;

					for (int j = 1; j < contador; j++) {

						

						orco();
						lblVidaEnemigo.setText(String.valueOf(lblAtributoVidaE.getText()));
						
						jefe();
						lblVidaEnemigo.setText(String.valueOf(lblAtributoVidaE.getText()));
						ImageIcon jefe = new ImageIcon(rutae + "jefe.jpg");

						Icon iz = new ImageIcon(jefe.getImage().getScaledInstance(lblImagenE.getWidth(), lblImagenE.getHeight(),
								Image.SCALE_DEFAULT));

						lblImagenE.setIcon(iz);
					}
					JOptionPane.showMessageDialog(frame, "Bien hecho, ahora enfréntate al próximo enemigo");

	

				} else if (phe <= 0) {
					JOptionPane.showMessageDialog(frame,
							"Te has quedado sin puntos de vida, por lo que tu personaje no puede continuar.");
					JOptionPane.showMessageDialog(frame, "No te preocupes, lo harás mejor la próxima vez");

					System.exit(phe);

				}
			}

		});

	}
}