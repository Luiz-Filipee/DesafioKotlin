package dados

import javax.persistence.*

@Entity
@Table(name = "albuns")
class AlbumEntity(
    val titulo: String = "Titulo do album",
    @ManyToOne
    val banda: BandaEntity = BandaEntity(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}