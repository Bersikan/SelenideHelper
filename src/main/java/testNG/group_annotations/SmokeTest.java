package testNG.group_annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SmokeTest {
    String value() default "Smoke";
}