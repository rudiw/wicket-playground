package com.playground.view;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

	public HomePage(final PageParameters parameters) {
		super(parameters);
		LOG.info("Loading HomePage");

		queue(new Link<>("mylink") {
			@Override
			public void onClick() {
				final PageParameters params = new PageParameters();
				params.set("key", "value");
				setResponsePage(SecondPage.class, params);
			}
		});

		queue(new LoginForm("loginForm"));
	}
}
