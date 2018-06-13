package com.tactfactory.appconception.service;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.tactfactory.appconception.service.model.assembler.FieldAssembler;
import com.tactfactory.appconception.service.model.dto.FieldDTO;

public class SocketReader {

	BufferedInputStream reader;

	public SocketReader(BufferedInputStream reader) {
		this.reader = reader;
	}

	public String readToString() throws IOException {
		String response = "";
		int stream;
		byte[] b = new byte[4096];
		stream = reader.read(b);
		if (stream != -1) {
			response = new String(b, 0, stream);
		}
		return response;
	}
	
	public Object readToObject() throws IOException {
		Object result = null;
		
		String response = "";
		int stream;
		byte[] b = new byte[4096];
		stream = reader.read(b);
		if (stream != -1) {
			response = new String(b, 0, stream);
			
			switch (response.split(UrlAcces.URL_SEPARATOR)[0]) {
			case UrlAcces.MODEL_FIELD:
				result = new FieldAssembler()
					.DTOToField(
							new FieldDTO().fromStringElement(
									response.split(UrlAcces.URL_SEPARATOR)[1]));
				break;

			default:
				break;
			}
		}
		
		return result;
	}
}
