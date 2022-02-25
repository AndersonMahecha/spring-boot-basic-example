package crudbasic.test.rest.handler;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ErrorResponse {

	private List<Error> errors;

	public ErrorResponse() {

		super();
	}

	public ErrorResponse(List<Error> errors) {

		this.errors = errors;
	}

	@JsonInclude(NON_NULL)
	public static class Error {

		private int code;
		private String property;
		private String description;
		private String invalidValue;

		public Error(int code, String description) {

			this.code = code;
			this.description = description;
		}

		public Error(String property, String description, String invalidValue) {

			this.property = property;
			this.description = description;
			this.invalidValue = invalidValue;
		}

		public Error(int code, String property, String description, String invalidValue) {

			super();
			this.code = code;
			this.property = property;
			this.description = description;
			this.invalidValue = invalidValue;
		}

		public int getCode() {

			return code;
		}

		public void setCode(int code) {

			this.code = code;
		}

		public String getProperty() {

			return property;
		}

		public void setProperty(String property) {

			this.property = property;
		}

		public String getDescription() {

			return description;
		}

		public void setDescription(String description) {

			this.description = description;
		}

		public String getInvalidValue() {

			return invalidValue;
		}

		public void setInvalidValue(String invalidValue) {

			this.invalidValue = invalidValue;
		}

	}

	public List<Error> getErrors() {

		return errors;
	}

	public void setErrors(List<Error> errors) {

		this.errors = errors;
	}

}