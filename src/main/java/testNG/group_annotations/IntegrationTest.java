package testNG.group_annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface IntegrationTest {
    String value() default "Integration";
}