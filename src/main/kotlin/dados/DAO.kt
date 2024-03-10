package dados

import javax.persistence.EntityManager

abstract class DAO<Tmodel, TEntity>(
    val manager: EntityManager,
    val entityType: Class<TEntity>
) {

    abstract fun toEntity(model: Tmodel): TEntity
    abstract fun toModel(entity: TEntity): Tmodel

    open fun getLista(): List<Tmodel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun adicionar(objeto: Tmodel) {
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    private fun recuperarEntityPeloId(id: Int): TEntity{
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id = :id", entityType)
        query.setParameter("id", id)
        return query.singleResult
    }

    open fun recuperarPeloId(id: Int): Tmodel {
        val entity = recuperarEntityPeloId(id)
        return toModel(entity)
    }

    open fun apagar(id: Int) {
        val entity = recuperarEntityPeloId(id)

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}