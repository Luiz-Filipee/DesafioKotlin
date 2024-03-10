package dados

import extensions.toEntity
import extensions.toModel
import modelos.Album
import javax.persistence.EntityManager

class AlbumDAO(manager: EntityManager): DAO<Album, AlbumEntity>(manager, AlbumEntity::class.java) {

    override fun toEntity(model: Album): AlbumEntity {
        return model.toEntity()
    }

    override fun toModel(entity: AlbumEntity): Album {
        return entity.toModel()
    }
}