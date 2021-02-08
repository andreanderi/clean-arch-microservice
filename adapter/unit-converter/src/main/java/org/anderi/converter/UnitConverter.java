package org.anderi.converter;

import lombok.extern.slf4j.Slf4j;
import org.anderi.usecase.dog.port.Converter;

@Slf4j
public class UnitConverter implements Converter {

	@Override public long centimeterToInch(long centimeter) {
		var oneCentimeterInInches = 0.39370;
		log.info(String.valueOf((centimeter * oneCentimeterInInches)));
		return (long) (centimeter * oneCentimeterInInches);
	}

	@Override public long kilogramToPound(long kilogram) {
		var oneKilogramInPounds = 2.205;
		return (long) (kilogram * oneKilogramInPounds);
	}
}
