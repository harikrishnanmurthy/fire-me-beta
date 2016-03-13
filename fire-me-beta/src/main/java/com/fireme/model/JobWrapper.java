package com.fireme.model;

import java.util.List;

public class JobWrapper {

	List<Job> jblst;

	public List<Job> getJblst() {
		return jblst;
	}

	public void setJblst(List<Job> jblst) {
		this.jblst = jblst;
	}

	@Override
	public String toString() {
		return "JobWrapper [jblst=" + jblst + "]";
	}

	public JobWrapper(List<Job> jblst) {
		super();
		this.jblst = jblst;
	}

}
