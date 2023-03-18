package java.lang.annotation;

public interface Annotation {

    boolean equals(Object obj);

    int hashCode();

    Class<? extends Annotation> annotationType();
}
