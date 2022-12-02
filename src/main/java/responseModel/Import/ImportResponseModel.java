package responseModel.Import;

public class ImportResponseModel {
    private String timeCreated;
    private int numOfItems;

    public ImportResponseModel(String timeCreated, int num){
        this.timeCreated = timeCreated;
        this.numOfItems = num;
    }

    public String getTimeCreated(){
        return this.timeCreated;
    }

    public int getNumOfItems(){
        return this.numOfItems;
    }

}
