package com.playground.view;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginForm extends Form<Void> {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    final IModel<String> usernameModel = new Model<>("");
    final IModel<String> passwordModel = new Model<>("");
    public LoginForm(String id) {
        super(id);

        final TextField<String> usernameField = new TextField<>("username", usernameModel);
        add(usernameField);
        final PasswordTextField passwordField = new PasswordTextField("password", passwordModel);
        add(passwordField);
    }

    @Override
    protected void onSubmit() {
        super.onSubmit();
        LOG.info("Submiting for username '{}' and password '{}'", usernameModel.getObject(), passwordModel.getObject());
    }
}
