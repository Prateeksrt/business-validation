package org.validation.config;

public final class ValidationContext {
	private boolean fieldValidation;
	private boolean accessDatabase;
	private static ValidationContext validationContext=null;
	
	private ValidationContext(){
		fieldValidation=false;
		accessDatabase=false;
	}
	
	public static ValidationContext getValidationContext(){
		if(validationContext==null){
			validationContext=new ValidationContext();
		}
		return validationContext;
	}

	public boolean isFieldValidation() {
		return fieldValidation;
	}

	public void setFieldValidation(boolean flag) {
		this.fieldValidation = flag;
	}

	public boolean isAccessDatabase() {
		return accessDatabase;
	}

	public void setAccessDatabase(boolean flag) {
		this.accessDatabase = flag;
	}
}
