package com.reactions.deathlines.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import com.reactions.deathlines.domain.entity.Entity
import com.reactions.deathlines.presentation.R
import com.reactions.deathlines.presentation.databinding.ItemAlbumBinding

class AlbumListAdapter : PagedListAdapter<Entity.Album, AlbumListAdapter.DataHolder>(AlbumDiffCallback()) {

    private val onAlbumItemClickSubject = PublishSubject.create<Entity.Album>()
    val albumItemClickEvent: Observable<Entity.Album> = onAlbumItemClickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind: ItemAlbumBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context),
                R.layout.item_album, parent, false) as ItemAlbumBinding

        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val album = getItem(position)
        album?.let { holder.bind(album) }
    }

    inner class DataHolder(private var itemAlbumBinding: ItemAlbumBinding) : RecyclerView.ViewHolder
    (itemAlbumBinding.root), View.OnClickListener {

        fun bind(albumItem: Entity.Album) {
            itemAlbumBinding.albumEntity = albumItem
            itemAlbumBinding.root.setOnClickListener(this)
            //albumEntityBinding.productItemImvThumbnail.loadUrl(albumItem.image.url)
            itemAlbumBinding.executePendingBindings()
        }

        override fun onClick(view: View) {
            val album = getItem((adapterPosition))
            album?.let {
                val product: Entity.Album = album
                onAlbumItemClickSubject.onNext(product)
            }
        }
    }
}