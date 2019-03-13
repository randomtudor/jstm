package utilities;

public class AccountData {
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private String dayOfBirth;
  private String monthOfBirth;
  private String yearOfBirth;
  private String company;
  private String adress;
  private String city;
  private String state;
  private String postcode;
  private String country;
  private String mobilePhone;
  private String alias;
  private TestType type;

  public static AccountData createNewAccountData(final TestType type) {
    final AccountData accountData = new AccountData();

    switch (type) {
      case POSITIVE:
        accountData.setEmail(randomEmail());
        accountData.setFirstName(Utilities.randomString(6, true, false));
        accountData.setLastName(Utilities.randomString(6, true, false));
        accountData.setPassword(Utilities.randomString(12, true, true));
        accountData.setMonthOfBirth(Utilities.randomNumber(1, 12));

        if (accountData.getMonthOfBirth().equals("2"))
          accountData.setDayOfBirth(Utilities.randomNumber(1, 28));
        else if (Integer.parseInt(accountData.getMonthOfBirth()) % 2 == 0)
          accountData.setDayOfBirth(Utilities.randomNumber(1,30));
        else
          accountData.setDayOfBirth(Utilities.randomNumber(1,31));

        accountData.setYearOfBirth(Utilities.randomNumber(1900, 2019));
        accountData.setCompany(Utilities.randomString(12, true, false));
        accountData.setAdress(Utilities.randomString(12, true, false));
        accountData.setCity(Utilities.randomString(12, true, false));
        accountData.setState(Utilities.randomNumber(1, 51));
        accountData.setPostcode(Utilities.randomString(5, false, true));
        accountData.setCountry("21");
        accountData.setMobilePhone(Utilities.randomString(10, false, true));
        accountData.setAlias(Utilities.randomString(12, true, false));
        accountData.setType(TestType.POSITIVE);
        break;
      case NEGATIVE:
        accountData.setEmail(randomEmail());
        accountData.setFirstName(Utilities.randomString(12, true, false) + "101");
        accountData.setLastName(Utilities.randomString(12, true, false) + "102");
        accountData.setPassword(Utilities.randomString(24, true, true) + "!@#$%^&*()");
        accountData.setDayOfBirth(Utilities.randomNumber(1, 31));
        accountData.setMonthOfBirth(Utilities.randomNumber(1, 12));
        accountData.setYearOfBirth(Utilities.randomNumber(1900, 2019));
        accountData.setCompany(Utilities.randomString(12, true, false) + "!@#$%");
        accountData.setAdress(Utilities.randomString(12, true, false) + "!@#$%%");
        accountData.setCity(Utilities.randomString(12, true, false) + "123#$");
        accountData.setState(Utilities.randomNumber(1, 51));
        accountData.setPostcode(Utilities.randomString(5, false, true));
        accountData.setCountry("21");
        accountData.setMobilePhone(Utilities.randomString(5, false, true) + "aa");
        accountData.setAlias(Utilities.randomString(12, true, false) + "12#$");
        accountData.setType(TestType.NEGATIVE);
        break;
    }

    return accountData;
  }

  public static String randomEmail() {
    return Utilities.randomString(12, true, false) + "@testdata.com";
  }

  public static String randomPhoneNumber() {
    return Utilities.randomString(10, false, true);
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getDayOfBirth() {
    return this.dayOfBirth;
  }

  public void setDayOfBirth(final String dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
  }

  public String getMonthOfBirth() {
    return this.monthOfBirth;
  }

  public void setMonthOfBirth(final String monthOfBirth) {
    this.monthOfBirth = monthOfBirth;
  }

  public String getYearOfBirth() {
    return this.yearOfBirth;
  }

  public void setYearOfBirth(final String yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public String getCompany() {
    return this.company;
  }

  public void setCompany(final String company) {
    this.company = company;
  }

  public String getAdress() {
    return this.adress;
  }

  public void setAdress(final String adress) {
    this.adress = adress;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  public void setState(final String state) {
    this.state = state;
  }

  public String getPostcode() {
    return this.postcode;
  }

  public void setPostcode(final String postcode) {
    this.postcode = postcode;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  public String getMobilePhone() {
    return this.mobilePhone;
  }

  public void setMobilePhone(final String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getAlias() {
    return this.alias;
  }

  public void setAlias(final String alias) {
    this.alias = alias;
  }

  public TestType getType() {
    return this.type;
  }

  public void setType(final TestType type) {
    this.type = type;
  }
}
