import java.awt.*;
import java.awt.event.*;

public class TempConverter extends KeyAdapter{

	/**
	 * 
	 */
	public TempConverter(){
		Frame f1 = new Frame("Temperature Converter");

		/*Considered using buttons for user to click to trigger conversion from
		 * associated temperature unit to other units. Then considered having a single convert
		 * buttong. Then decided to just trigger the conversion dynamically based on changing
		 * text in each field.  

        //Button btnFarenheit = new Button("Farenheit");
        //Button btnCelsius = new Button("Celsius");
        //Button btnKelvinButton = new Button("Kelvin");
        //Button btnConvert = new Button("Convert");
		 */
		TextField tfFarenheit = new TextField("32");
		TextField tfCelsius = new TextField("0");
		TextField tfKelvin = new TextField("273.15");
		Label lblFarenheit = new Label("°F", Label.LEFT);
		Label lblCelcius = new Label("°C", Label.LEFT);
		Label lblKelvin = new Label("°K", Label.LEFT); 

		//event listeners for text fields that trigger on key releases to ensure the text is read after the key is pressed, not before
		tfFarenheit.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){

				tfCelsius.setText(FarenheitToCelcius(tfFarenheit.getText()));
				tfKelvin.setText(CelsiustoKelvin(tfCelsius.getText()));
			}
		});

		tfCelsius.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){

				tfFarenheit.setText(CelsiustoFarenheit(tfCelsius.getText()));
				tfKelvin.setText(CelsiustoKelvin(tfCelsius.getText()));
			}
		});

		tfKelvin.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){

				tfCelsius.setText(KelvintoCelcius(tfKelvin.getText()));
				tfFarenheit.setText(CelsiustoFarenheit(tfCelsius.getText()));
			}
		});

		//Window event listener to close the application
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f1.dispose();
			};
		});

		//set size and positions of components in frame
		tfFarenheit.setBounds(40, 50, 100, 25);
		lblFarenheit.setBounds(141, 50, 50, 25);
		tfCelsius.setBounds(40, 85, 100, 25);
		lblCelcius.setBounds(141, 85, 50, 25);
		tfKelvin.setBounds(40, 120, 100, 25);
		lblKelvin.setBounds(141, 120, 50, 25);


		f1.add(tfFarenheit,0);
		f1.add(lblFarenheit);
		f1.add(tfCelsius,1);
		f1.add(lblCelcius);
		f1.add(tfKelvin,2);
		f1.add(lblKelvin);

		f1.setSize(300, 300);
		f1.setBackground(Color.lightGray);
		f1.setLayout(null);
		f1.setVisible(true);
	}


	private String FarenheitToCelcius(String Farenheit){

		if (Farenheit.isBlank()) return "";
		double C = 0;
		try {
			//only convert if there is a Farenheit isn't blank
			//if(!Farenheit.isBlank()) {
			double F = Double.valueOf(Farenheit);
			C = (F - 32) * (5.0/9.0);
			//}

		} catch (NumberFormatException e) {
			//need to write error message popup at some point
			System.err.println(e.getMessage());
		}

		return Double.toString(C);
	}


	private String CelsiustoFarenheit(String Celsius){

		if (Celsius.isBlank()) return "";
		double F = 0;
		try {
			//if (!Celsius.isBlank()) {
			double C = Double.valueOf(Celsius);
			F = (9.0/5.0) * C + 32;
			//}

		} catch (NumberFormatException e) {
			//need to write error message popup at some point
			System.err.println(e.getMessage());
		}

		return Double.toString(F);
	}


	private String CelsiustoKelvin(String Celsius){

		if (Celsius.isBlank()) return "";
		double K = 273.15;
		try {
			//if (!Celsius.isBlank()){
			double C = Double.valueOf(Celsius);
			K = C + 273.15;
			//}

		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			//need to write popup
		}

		return Double.toString(K);
	}


	private String KelvintoCelcius(String Kelvin){

		//catch empty string values when deleting values and return 0
		if (Kelvin.isBlank()) return "";

		double C = 0;
		try {
			double K = Double.valueOf(Kelvin);
			C = K - 273.15;
		}
		catch (NumberFormatException e){
			System.err.println(e.getMessage());
		}

		//if (Double.toString(C).isEmpty()) {
		//	return "0";
		//}
		return Double.toString(C);

	}


	public static void main(String[] args) throws Exception {
		new TempConverter();
		//need to learn how to exit out of GUI by clicking x

	}

}
