package entity;

public class Search {


    //Connected to UI Search bar

    private String from;
    private String to;

    public Search(String from, String to){
        this.from = from;
        this.to = to;
    }

    public String sendRequest(){
        /**traverse DB look for "to" - this can be done in a for loop or if DB has a find feature;
         if(to exists){
            push to request var in DB ""from" has requested to follow"
            return "Request sent"
         }

         else{

            return "Does not exist"
         }
         **/
        return null;
    }

}
