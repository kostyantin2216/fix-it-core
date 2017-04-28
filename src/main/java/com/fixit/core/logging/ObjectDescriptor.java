package com.fixit.core.logging;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kostyantin on 7/23/2016.
 */
public class ObjectDescriptor {

    private static final List<Class<?>> BASIC_TYPES = Arrays.asList(
            Boolean.class, Character.class, Byte.class, Short.class,
            Integer.class, Long.class, Float.class, Double.class, Void.class,
            String.class
    );

  //  private Set<Object> visited;
    private StringBuilder sb;

    private Class<?> clazz;

    private boolean descriptionError;

    public ObjectDescriptor() {
  //      this.visited = new HashSet<>();
        this.sb = new StringBuilder();
        this.descriptionError = false;
    }

    public String getDescription(Object obj) {
        fillDetails(obj, "");

        clazz = null;
    //    visited.clear();

        if(!descriptionError) {
            String result = sb.toString();
            sb.setLength(0);
            return result;
        } else {
            sb.setLength(0);
            descriptionError = false;
            return "";
        }
    }

    private void fillDetails(Object obj, String tabs) {
        if(!descriptionError) {
            if(obj != null) {
                clazz = obj.getClass();
                if(clazz.isPrimitive() || BASIC_TYPES.contains(clazz)) {
                    fillPrimitive(obj, tabs);
                } else if(Collection.class.isAssignableFrom(clazz)) {
                    fillCollectionDetails(obj, tabs);
                } else if(clazz.isArray()) {
                    fillArrayDetails(obj, tabs);
                } else {
                    fillObject(obj, tabs);
                }
            } else  {
                sb.append("null");
            }
        }
    }

    private void fillPrimitive(Object obj, String tabs) {
        if(clazz.getName().equals("java.lang.String")) {
            sb.append("\"").append(obj).append("\"");
        } else {
            sb.append(obj);
        }
    }

    private void fillObject(Object obj, String tabs) {
        sb.append(tabs).append("Object of Class \"").append(clazz.getSimpleName()).append("\"\n")
                .append(tabs).append("-------------------------------\n");

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                if(!field.isAccessible()) {
                    field.setAccessible(true);
                }

                String name = field.getName();
                Object value = field.get(obj);

                if(field.getType().isPrimitive() || BASIC_TYPES.contains(field.getType()) || value == null) {
                    if(field.getType().getName().equals("java.lang.String")) {
                        sb.append(tabs + name).append(" = \"").append(value).append("\"\n");
                    } else {
                        sb.append(tabs + name).append(" = ").append(value).append("\n");
                    }
                } else { //if(!visited.contains(field.get(obj))) {
                 //   visited.add(value);
                    sb.append(tabs + name).append(" = \n");

                    fillDetails(value, tabs + "\t");

                    sb.append("\n");
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                /*if(callback != null) {
                    callback.onError("Error while describing " + obj, e);
                }*/
                descriptionError = true;
                return;
            }
        }
    }

    private void fillCollectionDetails(Object collectionObj, String tabs) {
        Collection<?> collection = (Collection<?>) collectionObj;

        int count = 0;
        boolean titleShown = false;
        Iterator<?> itr = collection.iterator();
        while(itr.hasNext()) {
            Object obj = itr.next();

            if(!titleShown) {
                String type = clazz.getSimpleName();

                sb.append(tabs).append("Collection Of Type \"").append(type).append("\"\n")
                        .append(tabs).append("-------------------------------\n\n");

                tabs += "\t";

                titleShown = true;
            }

            sb.append(tabs).append("[").append(count++).append("] = ");

            fillDetails(obj, tabs);
            sb.append("\n");
        }
    }

    private void fillArrayDetails(Object arr, String tabs) {
        int length = Array.getLength(arr);
        if(length > 0) {
            String type = Array.get(arr, 0).getClass().getSimpleName();

            sb.append(tabs).append("Array Of Type \"").append(type).append("\"\n")
                    .append(tabs).append("-------------------------------\n\n");

            tabs += "\t";

            for (int i = 0; i < length; i ++) {
                sb.append(tabs).append("[").append(i).append("] = ");

                Object arrayElement = Array.get(arr, i);
                fillDetails(arrayElement, tabs);
                sb.append("\n");
            }
        }
    }

}

