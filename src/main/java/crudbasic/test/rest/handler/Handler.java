package crudbasic.test.rest.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import crudbasic.test.rest.handler.ErrorResponse.Error;

public class Handler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {

		logger.error(exception.getMessage(), exception);

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse
				.setErrors(Collections
						.singletonList(new Error(503, exception.getMessage())));

		return new ResponseEntity<>(errorResponse, status);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception,
																			HttpServletRequest request) {

		logger.error(exception.getMessage(), exception);

		MediaType accept = null;

		try {
			accept = MediaType.parseMediaType(request.getHeader(HttpHeaders.ACCEPT));
		} catch (InvalidMediaTypeException ignored) {
			// Ignored
		}

		if (!APPLICATION_JSON.isCompatibleWith(accept)) {
			return new ResponseEntity<>(BAD_REQUEST);
		}

		ErrorResponse errorResponse = new ErrorResponse();
		List<Error> details = exception.getConstraintViolations().stream()
				.map(cv -> new Error(cv.getPropertyPath().toString(), cv.getMessage(),
						String.valueOf(cv.getInvalidValue())))
				.collect(Collectors.toList());
		errorResponse.setErrors(details);

		return new ResponseEntity<>(errorResponse, BAD_REQUEST);
	}

}
