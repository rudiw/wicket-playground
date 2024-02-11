package com.playground.view;

import com.playground.model.MessageModel;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessagePanel extends Panel {
    private static final Logger LOG = LoggerFactory.getLogger(MessagePanel.class);

    private final IModel<String> msgModel = new Model<>("");
    private final Label msgLbl;

    public MessagePanel(String id) {
        super(id);

        setOutputMarkupId(true);

        msgLbl = new Label("msgLbl", msgModel);
        queue(msgLbl);
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        msgLbl.setVisible(!msgModel.getObject().isEmpty());
    }

    @Override
    public void onEvent(IEvent<?> event) {
        super.onEvent(event);
        if (event.getPayload() instanceof MessageModel) {
            final MessageModel msg = (MessageModel) event.getPayload();
            LOG.info("got event's msg: {}", msg.getMessage());
            msgModel.setObject(msg.getMessage());

            msg.getTarget().add(MessagePanel.this);
        }
    }
}
