package entity;

public class Request {

    private String from;

    public Request(String from){
        this.from = from;
    }


    public String accept(){
        /**
         Moves from to friends list, moves current user to from's friend list in DB.
         **/
        return this.from + " added as a friend.";
    }

    public String decline(){
        /**
         Removes from's request
         **/
        return this.from + " was not added as a friend";
    }
}

