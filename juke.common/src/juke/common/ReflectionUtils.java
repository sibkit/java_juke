package juke.common; /**
 * Created by IntelliJ IDEA.
 * User: chelovek
 * Date: 04.09.11
 * Time: 16:42
 * To change this juke.orm.sqliteAndroid.templating use File | Settings | File Templates.
 */

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Stack;

/**
 * Alex Tracer © 2009
 */
public class ReflectionUtils {

    
    /**
     * Для некоторого класса определяет каким классом был параметризован один из его предков с generic-параметрами.
     *
     * @param actualClass    анализируемый класс
     * @param genericClass   класс, для которого определяется значение параметра
     * @param parameterIndex номер параметра
     * @return класс, являющийся параметром с индексом parameterIndex в genericClass
     */
    public static Class getGenericParameterClass(final Class actualClass, final Class genericClass, final int parameterIndex) {
        if (!genericClass.isAssignableFrom(actualClass.getSuperclass())) {
            throw new IllegalArgumentException("Class " + genericClass.getName() + " is not a superclass of " + actualClass.getName() + ".");
        }

        Stack<ParameterizedType> genericClasses = new Stack<ParameterizedType>();

        Class clazz = actualClass;

        while (true) {
            Type genericSuperclass = clazz.getGenericSuperclass();
            boolean isParameterizedType = genericSuperclass instanceof ParameterizedType;
            if (isParameterizedType) {
                genericClasses.push((ParameterizedType) genericSuperclass);
            } else {
                genericClasses.clear();
            }
            Type rawType = isParameterizedType ? ((ParameterizedType) genericSuperclass).getRawType() : genericSuperclass;
            if (!rawType.equals(genericClass)) {
                clazz = clazz.getSuperclass();
            } else {
                break;
            }
        }

        Type result = genericClasses.pop().getActualTypeArguments()[parameterIndex];

        while (result instanceof TypeVariable && !genericClasses.empty()) {
            int actualArgumentIndex = getParameterTypeDeclarationIndex((TypeVariable) result);
            ParameterizedType type = genericClasses.pop();
            result = type.getActualTypeArguments()[actualArgumentIndex];
        }

        if (result instanceof TypeVariable) {
            throw new IllegalStateException("Unable to resolve type variable " + result + "." + " Try to replace instances of parametrized class with its non-parameterized subtype.");
        }

        if (result instanceof ParameterizedType) {
            result = ((ParameterizedType) result).getRawType();
        }

        if (result == null) {
            // Should never happen. :)
            throw new IllegalStateException("Unable to determine actual parameter type for " + actualClass.getName() + ".");
        }

        if (!(result instanceof Class)) {
            throw new IllegalStateException("Actual parameter type for " + actualClass.getName() + " is not a Class.");
        }

        return (Class) result;
    }

    public static int getParameterTypeDeclarationIndex(final TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();

        TypeVariable[] typeVariables = genericDeclaration.getTypeParameters();
        Integer actualArgumentIndex = null;
        for (int i = 0; i < typeVariables.length; i++) {
            if (typeVariables[i].equals(typeVariable)) {
                actualArgumentIndex = i;
                break;
            }
        }
        if (actualArgumentIndex != null) {
            return actualArgumentIndex;
        } else {
            throw new IllegalStateException("Argument " + typeVariable.toString() + " is not found in " + genericDeclaration.toString() + ".");
        }
    }
}
