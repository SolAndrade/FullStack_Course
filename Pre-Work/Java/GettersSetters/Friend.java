class Friend{
 
    private String name; 
    private boolean online;
    private Date birthday;
    private String bio;
    
    // Constructor 
    public Friend(String name, Date birthday, String bio){
      setName(name);
      setBirthday(birthday);
      setBio(bio);
      /* We are defaulting online to true since a new user must be online to register */
      this.online = true; 
    }
    
    // Setters
    
    public void setName(String name){
      this.name = name;
    }
    
    public void setBirthday(Date birthday){
      this.birthday = birthday;
    }
    
    public void setBio(String bio){
      this.bio = bio;
    }
    
    public void setOnline(boolean online){
      this.online = online;
    }
    
    // Getters
    
    public String getName(){
      return this.name;
    }
    
    public Date getBirthday(){
      return this.birthday;
    }
    
    public String getBio(){
      return this.bio;
    }
    
    public boolean isOnline(){
      return this.online;
    }
    
  }