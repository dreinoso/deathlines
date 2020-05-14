package com.reactions.deathlines.domain.usecase.album

import androidx.paging.PagedList
import io.reactivex.Flowable
import com.reactions.deathlines.domain.common.ResultState
import com.reactions.deathlines.domain.common.transformer.FTransformer
import com.reactions.deathlines.domain.common.transformer.STransformer
import com.reactions.deathlines.domain.entity.Entity
import com.reactions.deathlines.domain.repository.album.AlbumsRepository

/**
 * Album use case implementation
 */
class GetAlbumsUseCaseImpl(
        private val transformerFlowable: FTransformer<ResultState<PagedList<Entity.Album>>>,
        private val transformerSingle: STransformer<ResultState<Int>>,
        private val transformerSingleList: STransformer<ResultState<List<Entity.Album>>>,
        private val repository: AlbumsRepository) : GetAlbumsUseCase {

    /**
     * Get all of albums use case implementation
     */
    override fun getAlbums(): Flowable<ResultState<PagedList<Entity.Album>>> =
            repository.getAlbums()/*.compose(transformerFlowable)*/

    override fun deleteAlbum(album: Entity.Album) = repository.deleteAlbum(album).compose(transformerSingle)

    /*override fun loadAlbums(pageNumber: Int): Single<ResultState<List<Entity.Album>>> =
            repository.loadAlbums(pageNumber).compose(transformerSingleList)*/
}