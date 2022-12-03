package entity.User;

// Entity layer

class CommonUser implements User {

    private final String firstName;

    private final String lastName;

    private final String username;

    CommonUser(String username, String firstName,String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public String getFirstName(){
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getUsername(){
        return this.username;
    }

}