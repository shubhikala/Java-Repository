package in.com.psi.dashboard.convertor;

import in.com.psi.dashboard.entity.VO.ResponseMessage;
import in.com.psi.dashboard.util.DashboardConstants;
import in.com.psi.dashboard.util.MessageReader;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonMessageConvertor.
 *
 * @param <T>
 *            the generic type
 */
@Component
public class JsonMessageConvertor<T> implements HttpMessageConverter<T> {

	/** The converter. */
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

	/**
	 * Sets the supported media types.
	 *
	 * @param mediaTypes
	 *            the new supported media types
	 */
	public void setSupportedMediaTypes(List<MediaType> mediaTypes) {
		converter.setSupportedMediaTypes(mediaTypes);
	}

	/**
	 * Instantiates a new json message convertor.
	 */
	public JsonMessageConvertor() {
		converter = new MappingJackson2HttpMessageConverter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.HttpMessageConverter#canRead(java.
	 * lang.Class, org.springframework.http.MediaType)
	 */
	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return converter.canRead(clazz, mediaType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.HttpMessageConverter#canWrite(java
	 * .lang.Class, org.springframework.http.MediaType)
	 */
	@Override
	public boolean canWrite(Class<?> arg0, MediaType arg1) {
		return converter.canWrite(arg0, arg1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.http.converter.HttpMessageConverter#
	 * getSupportedMediaTypes()
	 */
	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return converter.getSupportedMediaTypes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.HttpMessageConverter#read(java.lang
	 * .Class, org.springframework.http.HttpInputMessage)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T read(Class<? extends T> arg0, HttpInputMessage arg1)
			throws IOException, HttpMessageNotReadableException {
		return (T) converter.read(arg0, arg1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.http.converter.HttpMessageConverter#write(java.lang
	 * .Object, org.springframework.http.MediaType,
	 * org.springframework.http.HttpOutputMessage)
	 */
	@Override
	public void write(T obj, MediaType arg1, HttpOutputMessage arg2)
			throws IOException, HttpMessageNotWritableException {
		ResponseMessage message = new ResponseMessage();
		// Check if T is null
		if (obj == null) {
			message.setResponseMessage(MessageReader.getInstance().getProperty(
					DashboardConstants.EMPTY));
			message.setResponseCode(ResponseMessage.EMPTY);
		} else {
			if (obj instanceof String) {
				String response = MessageReader.getInstance().getProperty(
						obj.toString());
				if (response == null) {
					message.setResponseMessage(MessageReader.getInstance()
							.getProperty(DashboardConstants.SUCCESS));
					message.setResponseObject(obj.toString());
					message.setResponseCode(ResponseMessage.SUCCESS);
				} else {
					message.setResponseMessage(response);
					message.setResponseCode(ResponseMessage.SUCCESS);
					message.setResponseObject(obj);
				}

			} else if (obj instanceof List) {
				List<?> list = (List<?>) obj;
				if (list.isEmpty()) {
					message.setResponseMessage(MessageReader.getInstance()
							.getProperty(DashboardConstants.EMPTY));
					message.setResponseCode(ResponseMessage.EMPTY);
				} else {
					message.setResponseMessage(MessageReader.getInstance()
							.getProperty(DashboardConstants.SUCCESS));
					message.setResponseCode(ResponseMessage.SUCCESS);
					message.setResponseObject(obj);
				}
			} else {
				message.setResponseMessage(MessageReader.getInstance()
						.getProperty(DashboardConstants.SUCCESS));
				message.setResponseCode(ResponseMessage.SUCCESS);
				message.setResponseObject(obj);
			}
			converter.write(message, arg1, arg2);
		}
	}
}
