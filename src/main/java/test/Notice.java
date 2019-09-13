package test;

import java.util.Date;

public class Notice {
  int id;
  int noticeId;
  String UCID;
  int read;
  int eject;
  String mtime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNoticeId() {
    return noticeId;
  }

  public void setNoticeId(int noticeId) {
    this.noticeId = noticeId;
  }

  public String getUCID() {
    return UCID;
  }

  public void setUCID(String UCID) {
    this.UCID = UCID;
  }

  public int getRead() {
    return read;
  }

  public void setRead(int read) {
    this.read = read;
  }

  public int getEject() {
    return eject;
  }

  public void setEject(int eject) {
    this.eject = eject;
  }

  public String getMtime() {
    return mtime;
  }

  public void setMtime(String mtime) {
    this.mtime = mtime;
  }

  public Notice() {
  }

  @Override
  public String toString() {
    return "Notice{" +
      "id=" + id +
      ", noticeId=" + noticeId +
      ", UCID='" + UCID + '\'' +
      ", read=" + read +
      ", eject=" + eject +
      ", mtime='" + mtime + '\'' +
      '}';
  }
}
