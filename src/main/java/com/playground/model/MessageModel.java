package com.playground.model;

import org.apache.wicket.ajax.AjaxRequestTarget;

public class MessageModel {
    private String message;
    private AjaxRequestTarget target;

    public MessageModel(String message, AjaxRequestTarget target) {
        this.message = message;
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AjaxRequestTarget getTarget() {
        return target;
    }

    public void setTarget(AjaxRequestTarget target) {
        this.target = target;
    }
}
