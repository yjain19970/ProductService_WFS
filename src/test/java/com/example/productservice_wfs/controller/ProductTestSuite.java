package com.example.productservice_wfs.controller;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Test cases related to Product usecase")
@SelectClasses({ProductControllerTest.class, ProductControllerMVCTest.class})
public class ProductTestSuite {
}
