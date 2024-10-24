package mooc

import fr.fullstack.project.Annonce
import fr.fullstack.project.Illustration
import fr.fullstack.project.User

class BootStrap {

    def init = { servletContext ->
        ["ALice","Bob","Dofa"].each{
            String username ->
                def userInstance = new User(username: username)
                (1..5).each {
                    def annonceInstance = new Annonce(title: "Title $username $it",
                    decription: "Description $username $it",
                            price:100*it,
                            active:Boolean.TRUE)
                    (1..5).each{
                        annonceInstance.addToIllustrations(
                                new Illustration(filename: "filename_$username-$it)")
                        )
                    }

                    userInstance.addToAnnonces(annonceInstance)
                    userInstance.save(flush: true,failOnError: true)
                }

        }
    }
    def destroy = {
    }
}
