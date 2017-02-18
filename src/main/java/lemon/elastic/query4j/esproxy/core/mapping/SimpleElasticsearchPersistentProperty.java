/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lemon.elastic.query4j.esproxy.core.mapping;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import lemon.elastic.query4j.esproxy.mapping.Association;
import lemon.elastic.query4j.esproxy.mapping.PersistentEntity;
import lemon.elastic.query4j.esproxy.mapping.model.AnnotationBasedPersistentProperty;
import lemon.elastic.query4j.esproxy.mapping.model.SimpleTypeHolder;

/**
 * Elasticsearch specific {@link lemon.elastic.query4j.esproxy.mapping.PersistentProperty} implementation processing
 * 这个应该是persistentproperty协议的elasticsearch实现  
 * 基本都是通用的东西
 * 
 *
 * @author Rizwan Idrees
 * @author Mohsin Husen
 */
public class SimpleElasticsearchPersistentProperty extends AnnotationBasedPersistentProperty<ElasticsearchPersistentProperty> implements ElasticsearchPersistentProperty {

    private static final Set<Class<?>> SUPPORTED_ID_TYPES = new HashSet<Class<?>>();
    private static final Set<String> SUPPORTED_ID_PROPERTY_NAMES = new HashSet<String>();

    static {
        SUPPORTED_ID_TYPES.add(String.class);
        SUPPORTED_ID_PROPERTY_NAMES.add("id");
        SUPPORTED_ID_PROPERTY_NAMES.add("documentId");
    }

    public SimpleElasticsearchPersistentProperty(Field field, PropertyDescriptor propertyDescriptor, PersistentEntity<?, ElasticsearchPersistentProperty> owner, SimpleTypeHolder simpleTypeHolder) {
        super(field, propertyDescriptor, owner, simpleTypeHolder);
    }

    @Override
    public String getFieldName() {
        return field.getName();
    }

    @Override
    public boolean isIdProperty() {
        return super.isIdProperty() || (field != null ? SUPPORTED_ID_PROPERTY_NAMES.contains(getFieldName()) : false);
    }

    @Override
    protected Association<ElasticsearchPersistentProperty> createAssociation() {
        return null;
    }
}
