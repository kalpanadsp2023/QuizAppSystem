package com.kalpa.quiz.classes;

import java.util.Objects;

public class QUnique
{
	private int qID;
	private Language lg;
	private Complexity cp;
	public QUnique(int qID, Language lg, Complexity cp) {
		super();
		this.qID = qID;
		this.lg = lg;
		this.cp = cp;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cp, lg, qID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QUnique other = (QUnique) obj;
		return cp == other.cp && lg == other.lg && qID == other.qID;
	}

	public int getqID() {
		return qID;
	}
	public void setqID(int qID) {
		this.qID = qID;
	}
	public Language getLg() {
		return lg;
	}
	public void setLg(Language lg) {
		this.lg = lg;
	}
	public Complexity getCp() {
		return cp;
	}
	public void setCp(Complexity cp) {
		this.cp = cp;
	}
}