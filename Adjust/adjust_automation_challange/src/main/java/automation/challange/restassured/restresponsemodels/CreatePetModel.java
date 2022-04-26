package automation.challange.restassured.restresponsemodels;

import java.util.ArrayList;

public class CreatePetModel {
    private int id;
    PetCategoryModel CategoryObject;
    private String name;
    ArrayList<String> photoUrls = new ArrayList <String> ();
    ArrayList <PetTagModel> tags = new ArrayList <PetTagModel> ();
    private String status;

    public int getId() {
        return id;
    }

    public PetCategoryModel getCategory() {
        return CategoryObject;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(PetCategoryModel categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
