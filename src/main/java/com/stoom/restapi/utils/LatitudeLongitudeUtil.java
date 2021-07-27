package com.stoom.restapi.utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.stoom.restapi.model.Endereco;

 public class LatitudeLongitudeUtil {
	
	static Logger logger = LogManager.getLogger(LatitudeLongitudeUtil.class);

	public Endereco preencheLatitudeLongitude(Endereco endereco) {
		GeoApiContext context = new GeoApiContext.Builder()
			    .apiKey("AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw")
			    .build();
		GeocodingResult[] results =  null;
		try {
			results = GeocodingApi.geocode(context,
				    endereco.getStreetName().concat(", ").concat(endereco.getCity())).await();
		}catch(IOException e) {
			logger.error("Erro de entrada e saída de dados...");
		}catch(InterruptedException e) {
			logger.error("Erro de interrupçao nao esperada...");
		}catch(ApiException e) {
			logger.error("Erro de consulta da API...");
		}
		if(results != null && results[0] != null && results[0].geometry != null 
				&& results[0].geometry.location != null && results[0].geometry.location.lat != 0)
			endereco.setLatitude(String.valueOf(results[0].geometry.location.lat));
		if(results != null && results[0] != null && results[0].geometry != null 
				&& results[0].geometry.location != null && results[0].geometry.location.lng != 0)
			endereco.setLongitude(String.valueOf(results[0].geometry.location.lng));
		return endereco;
	}
}
