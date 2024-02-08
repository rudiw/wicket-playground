package com.playground.view;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WicketHomePage
public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

	public HomePage(final PageParameters parameters) {
		super(parameters);
		LOG.info("Loading HomePage");

		final Form form = new Form<Void>("form"){
			@Override
			protected void onSubmit() {
				setResponsePage(SecondPage.class);
			}
		};
		queue(form);

		add(new Link<Void>("mylink") {
			@Override
			public void onClick() {
				setResponsePage(SecondPage.class);
			}
		});

	}
}
