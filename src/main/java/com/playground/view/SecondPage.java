package com.playground.view;

import com.playground.model.MessageModel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondPage extends BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(SecondPage.class);

    public SecondPage(PageParameters parameters) {
        super(parameters);
        final String value = parameters.get("key").toString();
        queue(new Label("key", value));

        queue(new Form<>("myform"));
        queue(new AjaxButton("mybtn") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                send(getPage(), Broadcast.BREADTH, new MessageModel("helooo", target));
                LOG.info("submitted from second page...");
            }
        });

        queue(new MessagePanel("messagePanel"));
    }
}
