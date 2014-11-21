package org.validation;

public interface RuleValidator<T> {
	public void validate(T t);
}
