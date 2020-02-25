package com.salon.ui.model.response;




public class UserMasterResponse extends PersonResponse {

    private PersonResponse person;

    public PersonResponse getPerson() {
        return person;
    }

    public void setPerson(PersonResponse person) {
        this.person = person;
    }

    private SpecializationResponse specialization;

    public SpecializationResponse getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationResponse specialization) {
        this.specialization = specialization;
    }

    //    private MasterResponse master;//Response;
//    public MasterResponse getMaster() {
//        return master;
//    }
//    public void setMaster(MasterResponse master) {
//        this.master = master;
//    }
}
