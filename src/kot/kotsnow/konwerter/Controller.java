package kot.kotsnow.konwerter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.lang.Double;
import java.text.DecimalFormat;

public class Controller {

	@FXML
	private TextField tempValue;
	@FXML
	private ChoiceBox<String> tempUnit;

	@FXML
	private Text resultC;
	@FXML
	private Text resultK;
	@FXML
	private Text resultF;
	@FXML
	private Text alert;


	private final String DEGREE = "\u00b0";
	private final String BADVALUE = "---";
	private final double DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN = 273.15;

	public Controller() {

	}

	private void setResultC(double tempC){
		resultC.setText(new DecimalFormat("##.##").format((tempC)));
	}

	private void setResultK(double tempK){
		resultK.setText(new DecimalFormat("##.##").format((tempK)));
	}

	private void setResultF(double tempF){
		resultF.setText(new DecimalFormat("##.##").format((tempF)));
	}

	private void setResultsForBadInput(){
		resultC.setText(BADVALUE);
		resultK.setText(BADVALUE);
		resultF.setText(BADVALUE);
	}

	private void getTemperatureToConvert(){
		try{
			double tempToConvert = Double.parseDouble(tempValue.getText().replace(',', '.'));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}



	@FXML
	private void calculateTemperature(ActionEvent event){

		double tempToConvert;
		double tempC = 0;
		double tempK = 0;
		double tempF = 0;

			alert.setText("");

			/*Mo¿e wyst¹pic wyjatek gdy nie zostanie wpisana liczba */
			try{

				/*konwersja Text na double*/
				tempToConvert = Double.parseDouble(tempValue.getText().replace(',', '.'));

				/*Obliczanie*/

				/*Celsjusze*/
				if(tempUnit.getValue().equals(DEGREE+"C")){
					if(tempToConvert>=-273.15){

						tempC = tempToConvert;
						tempK = tempC+DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;
						tempF = (9.0/5.0)*tempC + 32 ;

					} else{
						alert.setText("Temperatura nie mo¿e byc ni¿sza ni¿ -273.15"+DEGREE+"C !");
					}
				}

				/* Kelviny*/
				else if(tempUnit.getValue().equals("K")){
					if(tempToConvert>=0){

						tempK=tempToConvert;
						tempC = tempK-DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;
						tempK = tempC + DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;
						tempF = (9.0/5.0)*tempC + 32 -273.15;


					} else{
						alert.setText("Temperatura nie mo¿e byc ni¿sza ni¿ 0K !");
					}
				}

				/*Farenheity*/
				else
				{
					if(tempToConvert>=-459.67){

						tempF=tempToConvert;
						tempC=(tempF-32)*(5.0/9.0);
						tempK=tempC + DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;

					} else{
						alert.setText("Temperatura nie mo¿e byc ni¿sza ni¿ -459.67"+DEGREE+"F !");
					}


				}

			} catch(Exception e){
				alert.setText("Nieprawid³owe dane - podaj liczbê !");
			}

			/* ustawienie wyników*/
			if(alert.getText()!=""){
				setResultsForBadInput();
			} else{
				setResultC(tempC);
				setResultF(tempF);
				setResultK(tempK);
			}

	}

	private String getTemperatureUnit(){
		return tempUnit.getValue();
	}

}
