package com.playground.view;

import com.playground.WicketWebApplication;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WicketWebApplication.class)
public class HomePageTest {

    private WicketTester tester;

    @Autowired
    private WebApplication wicketApplication;

    @Autowired
    private ApplicationContext applicationContextMock;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(wicketApplication, "applicationContext", applicationContextMock);
        tester = new WicketTester(wicketApplication);
    }


    @Test
    public void testLink() {
        tester.startPage(HomePage.class);
        tester.clickLink("mylink");
        tester.assertRenderedPage(SecondPage.class);
    }

    @Test
    public void testFormSubmit() {
        tester.startPage(HomePage.class);

        final FormTester loginForm = tester.newFormTester("loginForm");
        loginForm.setValue("username", "input 123");
        loginForm.setValue("password", "random");

        loginForm.submit();
        tester.assertRenderedPage(SecondPage.class);
        tester.assertLabel("key", "input 123");
    }

}
