package fr.fullstack.project

class Annonce {

    String title;
    String decription;
    Float price;
    Boolean active =Boolean.FALSE;
    Date dateCreated;
    Date lastUpdated;
    List illustrations;

    static belongsTo = [author: User];
    static hasMany = [illustrations: Illustration];

    static constraints = {
        title nullable: false,blank: false,size: 5..255;
        decription nullable: false,blank: false;
        price min: 0f;
        active nullable: false;
        illustrations nullable: true;
    }
}
