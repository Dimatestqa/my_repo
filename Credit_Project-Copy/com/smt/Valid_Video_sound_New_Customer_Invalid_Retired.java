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
public class Valid_Video_sound_New_Customer_Invalid_Retired {

    private final String BrowserType;
    private final String DateOfBirth;
    private final int Month_Duration;
    private final String Name;
    private final String Product;

    public Valid_Video_sound_New_Customer_Invalid_Retired(final String BrowserType, final String DateOfBirth, final int Month_Duration, final String Name, final String Product) {
        this.BrowserType = BrowserType;
        this.DateOfBirth = DateOfBirth;
        this.Month_Duration = Month_Duration;
        this.Name = Name;
        this.Product = Product;
    }

    @Parameters(name = "{0}-{1}-{2}-{3}-{4}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {"Chrome", "12/08/1929", 6, "Georg Sanders", "MP3 Player"}
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
        selectTypeOfGood("Video, sound");
        enterText("Product", Product);
        enterText("Amount", "201");
        enterText("Duration", String.valueOf(Month_Duration));
        checkCreditValidity("Valid");
        createCustomer();
        enterText("Name", Name);
        enterDateOfBirth(DateOfBirth);
        enterText("Name", Name);
        enterDateOfBirth(DateOfBirth);
        checkCustomerValidity("Invalid");
    }
}
