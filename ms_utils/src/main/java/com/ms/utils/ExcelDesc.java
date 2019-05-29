package com.ms.utils;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExcelDesc {
    String value();
    String orderBy();
    boolean display() default true;
}

