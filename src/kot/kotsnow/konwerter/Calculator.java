package kot.kotsnow.konwerter;

public class Calculator {

	private static final double DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN = 273.15;


	public static double convertCelsjusToKelvin(double celsjusTemperature){
		return celsjusTemperature +DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;

	}

	public static double convertCelsjusToFahrenheit(double celsjusTemperature){
		return (9.0/5.0)*celsjusTemperature + 32;
	}

	public static double convertKelvinToCelsjus(double kelvinTemperature){
		return kelvinTemperature-DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;

	}

	public static double convertKelvinToFahrenheit(double kelvinTemperature){
		return (9.0/5.0)*(convertKelvinToCelsjus(kelvinTemperature)) + 32;
	}

	public static double convertFahrenheitToCelsjus(double fahrenheitTemperature){
		return (fahrenheitTemperature-32)*(5.0/9.0);
	}

	public static double convertFahrenheitToKelvin(double fahrenheitTemperature){
		return convertFahrenheitToCelsjus(fahrenheitTemperature) + DIFFERENCE_BEETWEEN_CELSJUS_AND_KELVIN;
	}
}
