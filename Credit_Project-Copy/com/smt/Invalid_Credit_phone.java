package com.smt;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collection;

import static com.credit.Automation.*;
import static com.credit.Basic.*;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class Invalid_Credit_phone {

    private final String BrowserType;
    private final int Month_Duration;
    private final String Product;

    public Invalid_Credit_phone(final String BrowserType, final int Month_Duration, final String Product) {
        this.BrowserType = BrowserType;
        this.Month_Duration = Month_Duration;
        this.Product = Product;
    }

    @Parameters(name = "{0}-{1}-{2}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {"Chrome", 27, "iPhone"}
        });
    }

    @Before
    public void setUp() {
        openBrowser(BrowserType, "www.credit.com");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void execute() {
        selectTypeOfGood("Phone");
        enterText("Product", Product);
        enterText("Amount", "1");
        enterText("Duration", String.valueOf(Month_Duration));
        checkCreditValidity("Invalid");
    }
}
