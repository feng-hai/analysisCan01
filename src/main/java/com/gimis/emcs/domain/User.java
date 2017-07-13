
package com.gimis.emcs.domain;

import java.util.Date;

import com.gimis.emcs.domain.emums.UserState;

public class User
{
    private Integer id;

    private String loginName;

    private String password;

    private UserState userState;

    private Boolean allowEdit;

    private String userName;

    private String mobilePhone;

    private String telephone;

    private Short type;

    private String email;

    private Integer extendId;

    private Short extendTypeId;

    private Integer errorTimes;

    private Date unlockTime;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String description;

    //以下字段2012-09-10新增 zhangchen
    /**
     * 手机号是否绑定
     * 0 未绑定    
     * 1 绑定
     */
    private Byte mobileValid;

    /**
     * 手机号是否可以登录
     * 0 不可以
     * 1 可以
     */
    private Byte mobileLoginValid;

    /**
     * 手机客户端是否可以登录
     * 0 不可以
     * 1 可以
     */
    private Byte mobileClientValid;

    /**
     * 用户是否检查session超时
     * 0 检查
     * 1 不检查
     */
    private Byte sessionTimeOutValid;

    /**
     * 手机设备标识号（IMEI）
     */
    private String mobileIMEI;

    /**
     * @return the type
     */
    public Short getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Short type)
    {
        this.type = type;
    }

    public User()
    {
        super();
    }

    public User(Integer id)
    {
        super();
        this.id = id;
    }

    /**
     * @param userName
     * @param mobilePhone
     * @param telephone
     * @param email
     */
    public User(String userName, String mobilePhone, String telephone, String email)
    {
        super();
        this.userName = userName;
        this.mobilePhone = mobilePhone;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public UserState getUserState()
    {
        return userState;
    }

    public void setUserState(UserState userState)
    {
        this.userState = userState;
    }

    public Boolean getAllowEdit()
    {
        return allowEdit;
    }

    public void setAllowEdit(Boolean allowEdit)
    {
        this.allowEdit = allowEdit;
    }

    public Integer getErrorTimes()
    {
        return errorTimes;
    }

    public void setErrorTimes(Integer errorTimes)
    {
        this.errorTimes = errorTimes;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Date getUnlockTime()
    {
        return unlockTime;
    }

    public void setUnlockTime(Date unlockTime)
    {
        this.unlockTime = unlockTime;
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp()
    {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp)
    {
        this.lastLoginIp = lastLoginIp;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getExtendId()
    {
        return extendId;
    }

    public void setExtendId(Integer extendId)
    {
        this.extendId = extendId;
    }

    public Short getExtendTypeId()
    {
        return extendTypeId;
    }

    public void setExtendTypeId(Short extendTypeId)
    {
        this.extendTypeId = extendTypeId;
    }

    public Byte getMobileValid()
    {
        return mobileValid;
    }

    public void setMobileValid(Byte mobileValid)
    {
        this.mobileValid = mobileValid;
    }

    public Byte getMobileLoginValid()
    {
        return mobileLoginValid;
    }

    public void setMobileLoginValid(Byte mobileLoginValid)
    {
        this.mobileLoginValid = mobileLoginValid;
    }

    public Byte getMobileClientValid()
    {
        return mobileClientValid;
    }

    public void setMobileClientValid(Byte mobileClientValid)
    {
        this.mobileClientValid = mobileClientValid;
    }

    public Byte getSessionTimeOutValid()
    {
        return sessionTimeOutValid;
    }

    public void setSessionTimeOutValid(Byte sessionTimeOutValid)
    {
        this.sessionTimeOutValid = sessionTimeOutValid;
    }

    public String getMobileIMEI()
    {
        return mobileIMEI;
    }

    public void setMobileIMEI(String mobileIMEI)
    {
        this.mobileIMEI = mobileIMEI;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password="
				+ password + ", userState=" + userState + ", allowEdit="
				+ allowEdit + ", userName=" + userName + ", mobilePhone="
				+ mobilePhone + ", telephone=" + telephone + ", type=" + type
				+ ", email=" + email + ", extendId=" + extendId
				+ ", extendTypeId=" + extendTypeId + ", errorTimes="
				+ errorTimes + ", unlockTime=" + unlockTime
				+ ", lastLoginTime=" + lastLoginTime + ", lastLoginIp="
				+ lastLoginIp + ", description=" + description
				+ ", mobileValid=" + mobileValid + ", mobileLoginValid="
				+ mobileLoginValid + ", mobileClientValid=" + mobileClientValid
				+ ", sessionTimeOutValid=" + sessionTimeOutValid
				+ ", mobileIMEI=" + mobileIMEI + "]";
	}

}
