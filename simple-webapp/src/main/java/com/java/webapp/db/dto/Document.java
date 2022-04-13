package com.java.webapp.db.dto;

public class Document {
	private int id;
	private int ownerCardId;
	private String expiry;
	private String issuedBy;
	private String dateIssued;
	private String documentNumber;
	
	public Document() {}
	
	public Document (int id, int owner_card_id, String expiry, String issued_by, String date_issued, String document_number) {
		this.id = id;
		this.ownerCardId = owner_card_id;
		this.expiry = expiry;
		this.issuedBy = issued_by;
		this.dateIssued = date_issued;
		this.documentNumber = document_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwnerCardId() {
		return ownerCardId;
	}

	public void setOwnerCardId(int ownerCardId) {
		this.ownerCardId = ownerCardId;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", ownerCardId=" + ownerCardId + ", expiry=" + expiry + ", issuedBy=" + issuedBy
				+ ", dateIssued=" + dateIssued + ", documentNumber=" + documentNumber + "]";
	}
	
}
