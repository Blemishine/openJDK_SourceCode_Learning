package sun.reflect.generics.factory;

import sun.reflect.generics.tree.FieldTypeSignature;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

public interface GenericsFactory {

    TypeVariable<?> makeTypeVariable(String name, FieldTypeSignature[] bounds);

    ParameterizedType makeParameterizedType(Type declaration, Type[] typeArgs, Type owner);

    TypeVariable<?> findTypeVariable(String name);

    WildcardType makeWildcard(FieldTypeSignature[] ubs, FieldTypeSignature[] lbs);

    Type makeNamedType(String name);

    Type makeArrayType(Type componentType);

    Type makeByte();

    Type makeBool();

    Type makeShort();

    Type makeChar();

    Type makeInt();

    Type makeLong();

    Type makeFloat();

    Type makeDouble();

    Type makeVoid();
}
