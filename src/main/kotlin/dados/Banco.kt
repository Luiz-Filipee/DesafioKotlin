package dados

import javax.persistence.EntityManager
import javax.persistence.Persistence

object Banco {
    fun getEntityManger(): EntityManager{
        val factory = Persistence.createEntityManagerFactory("musicas")
        return factory.createEntityManager()
    }
}