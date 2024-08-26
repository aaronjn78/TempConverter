import java.awt.*;

public class TempConverter {

    public TempConverter(){
        Frame f1 = new Frame("Temperature Converter");
        //for some reason was considering using multiple buttons for a user to click in order to trigger the event to calculate the other temperatures. 
        
        //Button btnFarenheit = new Button("Farenheit");
        //Button btnCelsius = new Button("Celsius");
        //Button btnKelvinButton = new Button("Kelvin");
       // Button btnConvert = new Button("Convert");
        TextField tfFarenheit = new TextField("32");
        TextField tfCelsius = new TextField("0");
        TextField tfKelvin = new TextField("273.15");
        Label lblFarenheit = new Label("°F", Label.LEFT);
        Label lblCelcius = new Label("°C", Label.LEFT);
        Label lblKelvin = new Label("°F", Label.LEFT);
        

        tfFarenheit.setBounds(40, 50, 100, 25);
        tfCelsius.setBounds(40, 85, 100, 25);
        tfKelvin.setBounds(40, 120, 100, 25);

  
        f1.add(tfFarenheit,0);
        f1.add(tfCelsius,1);
        f1.add(tfKelvin,2);

        f1.setSize(300, 300);
        f1.setBackground(Color.lightGray);
        f1.setLayout(null);
        f1.setVisible(true);

    }

    private String FarenheitToCelcius(String Farenheit){
        
        double C = 0;
        try {
            double F = Double.valueOf(Farenheit);
            C = (F - 32) * (5/9);

        } catch (NumberFormatException e) {
            //need to write error message popup at some point
            System.err.println(e.getMessage());
        }
        return Double.toString(C);
    }

    private String CelsiustoFarenheit(String Celsius){
        
        double F = 32;
        try {
            double C = Double.valueOf(Celsius);
             F = (C *(5/9)) + 32;

        } catch (NumberFormatException e) {
            //need to write error message popup at some point
            System.err.println(e.getMessage());
        }
        return Double.toString(F);
    }

    private String CelsiustoKelvin(String Celsius){
        double K = 273.15;
        try {
            double C = Double.valueOf(Celsius);
            K = C + 273.15;
            
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            //need to write popup
        }
        return Double.toString(K);

    }


    public static void main(String[] args) throws Exception {
        new TempConverter();
        //need to learn how to exit out of GUI by clicking x

    }

}
