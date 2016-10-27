package com.newlec.web.model;

import com.newlec.web.entities.Notice;

public class NoticeModel extends Notice{
	private int cmtcnt;

	public int getCmtcnt() {
		return cmtcnt;
	}

	public void setCmtcnt(int cmtcnt) {
		this.cmtcnt = cmtcnt;
	}
}