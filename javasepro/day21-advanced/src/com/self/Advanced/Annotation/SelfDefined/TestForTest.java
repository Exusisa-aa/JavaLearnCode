package com.self.Advanced.Annotation.SelfDefined;

public @interface TestForTest {
    String name();
    int age();
    String gender();
    String more() default "null";
}
