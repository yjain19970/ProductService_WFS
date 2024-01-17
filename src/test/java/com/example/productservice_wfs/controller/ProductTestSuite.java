package com.example.productservice_wfs.controller;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test cases related to Product usecase")
@SelectClasses({ProductControllerTest.class,ProductControllerMVCTest.class})
public class ProductTestSuite {
}
