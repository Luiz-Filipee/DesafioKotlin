package dados

import modelos.Banda
import javax.persistence.EntityManager

class BandaDAO(manager: EntityManager): DAO<Banda, BandaEntity>(manager, BandaEntity::class.java) {

    override fun toEntity(model: Banda): BandaEntity {
        return BandaEntity(model.nome, model.descricao, model.id)
    }

    override fun toModel(entity: BandaEntity): Banda {
        return Banda(entity.nome, entity.descricao, entity.id)
    }
}