package it.csi.iscritto.serviscritto.business.integration.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultDao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private List<String> messages;

	public ResultDao(Integer status) {
		this.status = status;
	}

	public ResultDao(Integer status, List<String> messages) {
		this.status = status;
		this.messages = messages;
	}

	public ResultDao addMessage(String message) {

		if (this.messages == null) {
			this.messages = new ArrayList<>();
		}

		this.messages.add(message);
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
