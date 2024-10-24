package fr.fullstack.project

import grails.converters.JSON
import grails.converters.XML

class ApiController {

    def annonce(){
        switch (request.getMethod()){
            case "GET":
                if(!params.id)
                   return response.status = 400;
                def annonceInstance = Annonce.get(params.id);
                if (!annonceInstance)
                   return response.status = 404;
                response.withFormat {
                    xml {render annonceInstance as XML}
                    json {render annonceInstance as JSON}
                }
                break
            case "POST":
                break
            case "PATCH":
                break
            case "DELETE":
                break
            default:
                return response.status = 405;
                break
        }
        return response.status = 406;
    }
    def annonces(){
        switch (request.getMethod()){
            case "GET":
                def annoncesList = Annonce.list();
                response.withFormat {
                    xml {render annoncesList as XML}
                    json {render annoncesList as JSON}
                }
                break;
            case "POST":
                break;
        }

    }

    def user(){

    }
    def users(){

    }
}
