package dados

import javax.persistence.*

@Entity
@Table(name = "bandas")
class BandaEntity(
    val nome: String = "Nome da banda",
    val descricao: String = "Descricao da banda",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}