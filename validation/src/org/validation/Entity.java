package org.validation;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.validation.annotation.BusinessEntity;

public class Entity {

	private static final Class<BusinessEntity> indentifier = BusinessEntity.class;

	private Object entity;
	private Class<?> entityClass;
	private Set<Entity> subEntities;
	private Class<? extends RuleValidator> ruleValidator;

	private Entity(Object entity) {
		this.entity = entity;
		this.entityClass = entity.getClass();
		this.subEntities = new HashSet<Entity>();
		try {
			populateSubEntities();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void populateSubEntities() throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			fetchSubEntities(field.get(this.entity), subEntities);
		}
	}

	public static void fetchSubEntities(Object fieldValue, Collection<Entity> subEntities) {
		if (isEntity(fieldValue.getClass())) {
				subEntities.add(new Entity(fieldValue));
		}
	}

	public static boolean isEntity(Class<?> objClass) {
		return objClass.isAnnotationPresent(indentifier);
	}

	public static Entity getEntity(Object object) {
		if (object == null) {
			return null;
		}
		if (!isEntity(object.getClass())) {
			return null;
		}
		return new Entity(object);
	}
	
	public static Entity getEntity(Object object, Class<? extends RuleValidator> ruleClass) {
		if(isValidRule(ruleClass, object.getClass())){
			
		}
		return null;
	}

	private static boolean isValidRule(Class<? extends RuleValidator> ruleClass, Class<?> entityClass) {
		for(Class<?> cls:ruleClass.getInterfaces()) {
			for(TypeVariable<?> t:ruleClass.getTypeParameters()) {
				System.out.println(t.getTypeName());
			}
		}
		return false;
	}
}