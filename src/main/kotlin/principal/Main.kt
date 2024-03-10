package principal

import dados.AlbumDAO
import dados.Banco
import dados.BandaDAO
import modelos.Album

fun main(args: Array<String>) {

    val manager = Banco.getEntityManger()

    val  albumDAO = AlbumDAO(manager)
    val bandaDao = BandaDAO(manager)
    val titas = bandaDao.recuperarPeloId(1)

    val goBack = Album("Go Back", titas)
    val cabecaDinossauro = Album("Cabeça dinossauro", titas)

    albumDAO.adicionar(cabecaDinossauro)
    albumDAO.adicionar(goBack)

    val listaAlbuns = albumDAO.getLista()
    println(listaAlbuns)

    manager.close()

}