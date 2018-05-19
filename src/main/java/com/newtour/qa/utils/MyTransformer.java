package com.newtour.qa.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}
	
	

}

// Note: this IAnnotationTransformer interface is use to retry the failed testcases at RUNTIME defined in testng.xml file, and it uses the RetryAnalyzer class also
