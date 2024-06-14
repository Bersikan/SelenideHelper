package testNG;

import testNG.group_annotations.IntegrationTest;
import testNG.group_annotations.RegressionTest;
import testNG.group_annotations.SmokeTest;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        List<String> allAnnotations = new ArrayList<>(List.of(annotation.getGroups()));
        if (testMethod.isAnnotationPresent(SmokeTest.class)) {
            allAnnotations.add("Smoke");
            annotation.setGroups(allAnnotations.toArray(new String[0]));
        }
        if (testMethod.isAnnotationPresent(IntegrationTest.class)) {
            allAnnotations.add("Integration");
            annotation.setGroups(allAnnotations.toArray(new String[0]));
        }
        if (testMethod.isAnnotationPresent(RegressionTest.class)) {
            allAnnotations.add("Regression");
            annotation.setGroups(allAnnotations.toArray(new String[0]));
        }
        List<String> groupNames = Arrays.asList(annotation.getGroups());
    }
}

