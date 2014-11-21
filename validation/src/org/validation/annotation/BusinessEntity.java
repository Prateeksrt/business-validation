package org.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.validation.RuleValidator;
import org.validation.internal.NoRule;

@Target({ElementType.TYPE,ElementType.PARAMETER})
public @interface BusinessEntity {
	@SuppressWarnings("rawtypes")
	Class<? extends RuleValidator> rule() default NoRule.class;
}
