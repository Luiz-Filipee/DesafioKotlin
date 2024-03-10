package modelos

class Album(
    val titulo: String = "Titulo do album",
    val banda: Banda = Banda(),
    val id: Int = 0
) {
    override fun toString(): String {
        return "$titulo ($id) - $banda"
    }
}